package me.softwarecraftsman.socketio;
import io.socket.client.IO;
import io.socket.emitter.Emitter;
import io.socket.client.Socket;

public class Main{
  public static void main(String args[])throws Exception{
    io.socket.client.Socket socket = IO.socket("http://localhost:3000");
    socket.on(io.socket.client.Socket.EVENT_CONNECT, new Emitter.Listener() {
    
      @Override
        public void call(Object... args) {
            socket.emit("chat message", "hello from java");
            socket.disconnect();
          }
    
    }).on("event", new Emitter.Listener() {
    
      @Override
        public void call(Object... args) {}
    
    }).on(io.socket.client.Socket.EVENT_DISCONNECT, new Emitter.Listener() {
    
      @Override
        public void call(Object... args) {}
    
    });
    socket.connect();
  }
  

  public static String mainMethod() throws Exception{
    Socket socket = IO.socket("http://localhost:3000");
   // socket.on(io.socket.client.Socket.EVENT_CONNECT, new Emitter.Listener() {

   //   @Override
   //     public void call(Object... args) {
   //         socket.emit("chat message", "hello from java");
   //       }

   // }).on("event", new Emitter.Listener() {

   //   @Override
   //     public void call(Object... args) {}

   // }).on(io.socket.client.Socket.EVENT_DISCONNECT, new Emitter.Listener() {

   //   @Override
   //     public void call(Object... args) {}

   // });
    socket.connect();
    Thread.sleep(300);
    socket.emit("chat message", "calling from groovy");
    Thread.sleep(300);
    socket.disconnect();
    return  "done";
  }
}
