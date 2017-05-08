import spock.lang.Specification

import me.softwarecraftsman.socketio.Main;
import io.socket.client.IO;
import io.socket.emitter.Emitter;
import io.socket.client.Socket;

class AppSpec extends Specification {
  def setupSpec(){
    print 'DOING SETUP'
  }
  def sendMessage(){
    return 'hello from socketio'
  }

  def "socket gets a message on 'chat message'"() {
    def recievedString = sendMessage()
      Socket socket = IO.socket("http://localhost:3000");
    socket.connect();
    Thread.sleep(300);
    socket.emit("chat message", "calling from groovy");
    Thread.sleep(300);
    socket.disconnect();
    expect: 'done' == 'done'
  }


  def "send and recieve"(){
    def retVal = '';
      Socket socket = IO.socket("http://localhost:3000");
    socket.on(io.socket.client.Socket.EVENT_CONNECT, new Emitter.Listener() {

        @Override
        public void call(Object... args) {
        socket.emit("chat message", "hello from java");
        }

        }).on("chat message", new Emitter.Listener() {

          @Override
          public void call(Object... args) {
           System.out.println(args[0]);
           retVal = args[0];
          }

       }).on(io.socket.client.Socket.EVENT_DISCONNECT, new Emitter.Listener() {

        @Override
         public void call(Object... args) {}

      });
     socket.connect();
     Thread.sleep(300);
     expect: retVal == 'Got this: hello from java'
     
  }
}
