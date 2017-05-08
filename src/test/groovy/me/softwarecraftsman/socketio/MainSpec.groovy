import spock.lang.Specification

import io.socket.client.IO;
import io.socket.emitter.Emitter;
import io.socket.client.Socket;

class AppSpec extends Specification {

  def "send a message and recieve a response"(){
    def retVal = '';
    Socket socket = IO.socket("http://localhost:3000");
    socket.on(io.socket.client.Socket.EVENT_CONNECT, new Emitter.Listener() {

        @Override
        public void call(Object... args) {
        socket.emit("chat message", "sending from spock spec");
        }

        }).on("chat message", new Emitter.Listener() {

          @Override
          public void call(Object... args) {
           println(args[0]);
           retVal = args[0];
          }

       }).on(io.socket.client.Socket.EVENT_DISCONNECT, new Emitter.Listener() {

        @Override
         public void call(Object... args) {}

      });
     socket.connect();
     Thread.sleep(300);
     expect: retVal == 'Got this: sending from spock spec'
  }
}
