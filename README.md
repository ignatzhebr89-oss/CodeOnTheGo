 <p align="center">
  <img src="./images/ADFA_logo.png" alt="Code On The Go" width="80" height="80"/>
</p>
<p align="center">
  💖 <strong>If you believe in our mission or just love our tools, please <a href="https://github.com/sponsors/appdevforall">sponsor our work</a>.</strong> 💖
</p>
<h2 align="center"><b>Code On The Go</b></h2>
<p align="center">
 Code on the Go is an IDE that lets you build Android apps on Android phones, without needing a traditional computer or Internet access. Code on the Go is a project of App Dev for All, a philanthropic venture focused on lowering the barriers to Android app development. </p>
<p><br>

<p align="center">
<img src="https://img.shields.io/badge/License-GPLv3-blue.svg" alt="License"></p>
<br>

<p align="center">
  <a href="https://github.com/appdevforall/CodeOnTheGo/issues">Report a bug or request a feature</a> &nbsp; &#8226; &nbsp;
   <a href="https://github.com/appdevforall/CodeOnTheGo/discussions">Support and discussions forum</a>&nbsp; &#8226; &nbsp;
   <a href="https://t.me/CodeOnTheGoOfficial">Telegram channel</a> &nbsp; &#8226; &nbsp;
<a href="https://github.com/appdevforall/CodeOnTheGo/wiki/Code-on-the-Go-Knowledge-Base">Knowledge base</a>
</p>

## Code on the Go and AndroidIDE

Code on the Go is the successor to [AndroidIDE](https://github.com/AndroidIDEOfficial/AndroidIDE), a popular mobile IDE that was archived in 2024. Code on the Go is actively maintained and updated weekly by App Dev for All. 

## Installation

Download the [Code on the Go APK](https://www.appdevforall.org/code-on-the-go?utm_source=gh&utm_medium=readme) from the [App Dev for All](https://www.appdevforall.org/?utm_source=gh&utm_medium=readme) website.


## Contributing

See the [contributing guide](./CONTRIBUTING.md).

## Thanks to

Code on the Go includes software developed by the [Apache Software Foundation](https://www.apache.org). Additional thanks to these developers:

- [Akash Yadav](https://github.com/itsaky) for [AndroidIDE](https://github.com/AndroidIDEOfficial/AndroidIDE)
- [Rosemoe](https://github.com/Rosemoe) for [CodeEditor](https://github.com/Rosemoe/sora-editor)
- [Termux](https://github.com/termux) for [Terminal Emulator](https://github.com/termux/termux-app)
- [Bogdan Melnychuk](https://github.com/bmelnychuk)
  for [AndroidTreeView](https://github.com/bmelnychuk/AndroidTreeView)
- [George Fraser](https://github.com/georgewfraser) for
  the [Java Language Server](https://github.com/georgewfraser/java-language-server)
- [Vivek](https://github.com/itsvks19) for [LayoutEditor](https://github.com/itsvks19/LayoutEditor)
 
Thanks to all the developers who have contributed to this project! 

## Contact us

- [Website](https://www.appdevforall.org)
- [Official Telegram channel](https://t.me/CodeOnTheGoOfficial)
- [Telegram discussions](https://t.me/CodeOnTheGoDiscussions)
- [Email](mailto:feedback@appdevforall.org)

## Documentation and reference materials
### Creative Commons
The following PDF is redistributed under the Creative Commons Attribution 4.0 International License (CC BY 4.0):
- Java, Java, Java: Object-Oriented Problem Solving, Third Edition by R. Morelli and R. Walde, previously published by Pearson Education, Inc. (Source: https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving)
  
### Free books from Goalkicker.com
- Android Notes for Professionals (Source: https://goalkicker.com/AndroidBook/)
- Java Notes for Professionals (Source: https://goalkicker.com/JavaBook/)
- Kotlin Notes for Professionals (Source: https://goalkicker.com/KotlinBook/)

### Third-Party Documentation
This project includes unmodified documentation from:

#### Android Mobile App Developer Tools
licensed under CC BY 4.0:
https://creativecommons.org/licenses/by/4.0/   
Source: https://developer.android.com

#### Kotlin Programming Language
licensed under CC BY 4.0:
https://creativecommons.org/licenses/by/4.0/   
Source: https://kotlinlang.org/

#### OpenJDK Development Kit (JDK) documentation
licensed under Debian Open Publications license: 
https://www.debian.org/opl   
Source: https://packages.debian.org/unstable/openjdk-17-doc


## License

```
Code On The Go is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Code On The Go is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Code On The Go.  If not, see <https://www.gnu.org/licenses/>.
```

Any violations to the license can be reported either by opening an issue or writing a mail to us
directly.

<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HollyGRAM</title>
<style>
*{box-sizing:border-box}
body{margin:0;background:#17212b;color:white;font-family:Arial}
header{padding:18px;background:#17212b;display:flex;justify-content:space-between}
button{cursor:pointer;border:0;color:white}
.page{display:none;padding:16px;padding-bottom:90px}
.page.active{display:block}
.search,input{width:100%;padding:13px;background:#242f3d;border:0;border-radius:10px;color:white;margin:8px 0}
.tabs{display:flex;justify-content:space-around;padding:15px;color:#55aaff}
.chat{display:flex;align-items:center;padding:14px;border-bottom:1px solid #263442;gap:12px}
.avatar{width:50px;height:50px;border-radius:50%;background:#2488d8;display:grid;place-items:center;font-size:22px}
.info{flex:1}
.info p{margin:5px 0;color:#9eabb8;font-size:13px}
.item{background:#242f3d;padding:16px;margin:10px 0;border-radius:12px}
.owner{border:1px solid #d9a83d}
.action{background:#2488d8;padding:13px;border-radius:9px;width:100%;margin:5px 0}
.bottom{position:fixed;bottom:0;width:100%;display:flex;justify-content:space-around;background:#17212b;padding:15px}
.bottom button{background:none;color:#9eabb8}
.bottom button.active{color:#55aaff}
</style>
</head>
<body>
<header>
<b>HollyGRAM</b>
<button onclick="show('settings')">⚙️</button>
</header>

<div id="chats" class="page active">
<input placeholder="Поиск">
<div class="tabs">Все чаты　 Личные　 Каналы</div>
<div class="chat"><div class="avatar">H</div><div class="info"><b>HollyGRAM</b><p>Добро пожаловать!</p></div></div>
<div class="chat"><div class="avatar">⭐</div><div class="info"><b>Избранное</b><p>Сохранённые сообщения</p></div></div>
<div class="chat"><div class="avatar">👑</div><div class="info"><b>Мой канал</b><p>Мои публикации</p></div></div>
</div>

<div id="contacts" class="page">
<h2>Контакты</h2>
<div class="item">👤 Мои контакты</div>
</div>

<div id="calls" class="page">
<h2>Звонки</h2>
<div class="item">📞 История звонков</div>
</div>

<div id="settings" class="page">
<h2>Настройки</h2>
<div class="item">👤 Мой профиль</div>
<div class="item">🔔 Уведомления</div>
<div class="item">🔒 Конфиденциальность</div>
<div class="item">🎨 Внешний вид</div>
<div class="item">🌐 Язык</div>
<div class="item owner" onclick="show('admin')">
👑 OWNER — Админ-панель
</div>
</div>

<div id="admin" class="page">
<h2>👑 OWNER</h2>
<div class="item">⭐ Выдача звёзд</div>
<input id="starUser" placeholder="ID пользователя">
<input id="starCount" type="number" placeholder="Количество звёзд">
<button class="action" onclick="giveStars()">Выдать звёзды</button>

<div class="item">🎁 Выдача NFT</div>
<input id="nftUser" placeholder="ID получателя">
<input id="nftName" placeholder="Название NFT">
<button class="action" onclick="giveNFT()">Выдать NFT</button>

<div class="item">🚫 Блокировка пользователя</div>
<input id="blockUser" placeholder="ID пользователя">
<button class="action" onclick="block()">Заблокировать</button>
<button class="action" onclick="unblock()">Разблокировать</button>

<div class="item">📊 Статистика</div>
<p id="stats">Выдано звёзд: 0<br>Выдано NFT: 0</p>
<button class="action" onclick="show('settings')">Назад</button>
</div>

</div>

<nav class="bottom">
<button onclick="show('chats')" id="bchats" class="active">💬<br>Чаты</button>
<button onclick="show('contacts')" id="bcontacts">👥<br>Контакты</button>
<button onclick="show('calls')" id="bcalls">📞<br>Звонки</button>
<button onclick="show('settings')" id="bsettings">⚙️<br>Настройки</button>
</nav>

<script>
let stars=0,nfts=0;
function show(id){
document.querySelectorAll('.page').forEach(p=>p.classList.remove('active'));
document.getElementById(id).classList.add('active');
document.querySelectorAll('.bottom button').forEach(b=>b.classList.remove('active'));
if(document.getElementById('b'+id))
document.getElementById('b'+id).classList.add('active');
}
function giveStars(){
let u=document.getElementById('starUser').value;
let n=Number(document.getElementById('starCount').value);
if(!u||!n||n<1)return alert('Заполни поля');
stars+=n;
update();
alert('Добавлено '+n+' звёзд пользователю '+u);
}
function giveNFT(){
let u=document.getElementById('nftUser').value;
let n=document.getElementById('nftName').value;
if(!u||!n)return alert('Заполни поля');
nfts++;
update();
alert('NFT '+n+' выдан пользователю '+u);
}
function block(){
let u=document.getElementById('blockUser').value;
if(!u)return alert('Введи ID');
alert('Демо: пользователь '+u+' отмечен для блокировки');
}
function unblock(){
let u=document.getElementById('blockUser').value;
if(!u)return alert('Введи ID');
alert('Демо: блокировка '+u+' снята');
}
function update(){
document.getElementById('stats').innerHTML=
'Выдано звёзд: '+stars+'<br>Выдано NFT: '+nfts;
}
</script>
</body>
</html>


