package com.itsaky.androidide.lsp.kotlin.compiler.index

import com.google.common.truth.Truth.assertThat
import com.itsaky.androidide.eventbus.events.editor.DocumentCloseEvent
import com.itsaky.androidide.eventbus.events.editor.DocumentOpenEvent
import com.itsaky.androidide.lsp.kotlin.fixtures.KtLspTest
import com.itsaky.androidide.projects.FileManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.appdevforall.codeonthego.indexing.InMemoryIndex
import org.appdevforall.codeonthego.indexing.jvm.JvmSymbolDescriptor
import org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex
import org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataDescriptor
import org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex
import org.appdevforall.codeonthego.indexing.util.BackgroundIndexer
import org.junit.After
import org.junit.Test
import java.nio.file.Path

/**
 * A full-pass index of an open file must analyse the instance FIR resolves the path to - the live
 * buffer - not PsiManager's disk copy. Analysing the disk copy is what produced "No fir element was
 * found" for its declarations in production (ADFA-5763), and it indexes text the user has replaced.
 */
internal class IndexWorkerOpenFileTest : KtLspTest() {
	override val enableParserEventSystem = true

	private var openedPath: Path? = null

	@After
	fun closeDoc() {
		openedPath?.let { FileManager.onDocumentClose(DocumentCloseEvent(it)) }
	}

	@Test
	fun `indexing an open file indexes its live buffer, not the disk copy`(): Unit =
		runBlocking {
			val onDisk = "package p\n\nfun onDisk() = 0\n"
			val vf = createSourceFile("Main.kt", onDisk).virtualFile
			val path = env.sourceRoots.first().resolve("Main.kt")
			FileManager.onDocumentOpen(DocumentOpenEvent(path, "$onDisk\nfun onlyInBuffer() = 1\n", 1))
			openedPath = path
			env.ktSymbolIndex.refreshCurrentKtFile(path)

			val backing = InMemoryIndex(JvmSymbolDescriptor)
			val sourceIndex =
				object : JvmSymbolIndex(backing, BackgroundIndexer(backing)) {
					override fun visibleSourceIds(): Collection<String>? = null
				}
			val worker =
				IndexWorker(
					project = env.project,
					queue = WorkerQueue(),
					fileIndex = KtFileMetadataIndex(InMemoryIndex(KtFileMetadataDescriptor)),
					sourceIndex = sourceIndex,
					scope = CoroutineScope(Dispatchers.Default + SupervisorJob()),
					withLiveKtFile = { p, block -> env.ktSymbolIndex.withLiveKtFileAsync(p) { block(it) } },
				)

			worker.submitCommand(IndexCommand.IndexSourceFile(vf))
			worker.submitCommand(IndexCommand.Stop)
			withTimeout(10_000) { worker.start() }

			val names = sourceIndex.findByPrefix("").map { it.shortName }.toSet()
			assertThat(names).containsExactly("onDisk", "onlyInBuffer")
		}
}
