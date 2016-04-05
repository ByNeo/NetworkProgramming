/*
* This project partially uses the codes given in https://github.com/guille/chat-example.git
*
*
 */


var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

// index.html dosyası istemcilere gönderiliyor...
app.get('/', function(req, res){
  res.sendFile(__dirname + '/index.html');
});

http.listen(8080, function(){
    console.log('8080 Portu dinleniyor...');
});


io.on('connection', function(socket)
{
    console.log('Bir kullanıcı bağlandı');

    socket.on('mesaj', function(msg)
    {
        io.emit('mesaj', msg);
    });
    socket.on('disconnect', function()
    {
        console.log('Kullanıcı ayrıldı...');
    });
});
