package me.softwarecraftsman.socketio;
import io.socket.engineio.client.*;
import io.socket.client.*;
import io.socket.emitter.*;

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
    io.socket.client.Socket socket = IO.socket("http://localhost:3000");
    //socket.on(io.socket.client.socket.event_connect, new emitter.listener() {
    //
    //  @override
    //    public void call(object... args) {
    //        socket.emit("chat message", "hello from java");
    //      }
    //
    //}).on("chat message", new emitter.listener() {
    //
    //  @override
    //    public void call(object... args) {
    //      system.out.println("hello got a message"); 
    //    }
    //
    //}).on(io.socket.client.socket.event_disconnect, new emitter.listener() {
    //  @override
    //    public void call(object... args) {}
    //});
    socket.connect();
    socket.emit("chat message", "calling from groovy" );
    socket.disconnect();
    return  "done";
  }
}
