var io = require('socket.io-client');
var socket = io('http://localhost:3000');

var stdin = process.openStdin();

stdin.addListener("data", function(d) {
  socket.emit('chat message', d.toString());
  if (d.toString() == "exit\n"){
    console.log("exiting...");
    process.exit(0);
  }
});
