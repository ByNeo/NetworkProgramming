
var express = require('express');
var app = express();
//var path = require('path');


//app.use(express.static(__dirname)); // Current directory is root
//app.use(express.static(path.join(__dirname, 'public'))); //  "public" off of current is root
app.use(express.static('public'));
//app.use(express.static('files'));
app.listen(8080);
console.log('8080 Portu dinleniyor...');



