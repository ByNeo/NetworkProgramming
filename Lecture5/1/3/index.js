//var app = require('express')();
//var http = require('http').Server(app);

var express = require('express');
var app = express();
//var path = require('path');




//app.use(express.static(__dirname)); // Current directory is root
//app.use(express.static(path.join(__dirname, 'public'))); //  "public" off of current is root
app.use(express.static('public'));
app.use(express.static('files'));
app.listen(8000);
console.log('Listening on port 8080');

// index.html dosyası istemcilere gönderiliyor...
/*app.get('/', function(req, res){
  res.sendFile(__dirname + '/index.html');
});

http.listen(8000, function(){
  console.log('listening on *:8000');
});
 */

