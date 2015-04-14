    var sys = require("sys");  
    sys.puts("Hello World");

    process.stdin.resume();
    process.stdin.setEncoding('utf8');

    process.stdin.once('data', function (input) { //process.stdin.on // sürekli olarak klavyeden girilenleri okur
        process.stdout.write('data: ' + input);
    });

    console.log("log...");
