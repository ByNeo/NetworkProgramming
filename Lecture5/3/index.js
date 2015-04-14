var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

// index.html dosyası istemcilere gönderiliyor...
app.get('/', function(req, res){
  res.sendFile(__dirname + '/index.html');
});

http.listen(8001, function(){
  console.log('listening on *:8001');
});


io.on('connection', function(socket)
{
    console.log('Bir kullanıcı bağlandı');

    socket.on('chat message', function(msg)
    {
        io.emit('chat message', msg);
    });
    socket.on('disconnect', function()
    {
        console.log('Kullanıcı ayrıldı...');
    });
});
