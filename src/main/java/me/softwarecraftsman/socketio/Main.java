package me.softwarecraftsman.socketio;
import io.socket.*;

public class Main{
  public static void main(String args[]){
    System.out.println("Working");
    /*
    socket = IO.socket("http://localhost");
    socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
    
      @Override
        public void call(Object... args) {
            socket.emit("foo", "hi");
            socket.disconnect();
          }
    
    }).on("event", new Emitter.Listener() {
    
      @Override
        public void call(Object... args) {}
    
    }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
    
      @Override
        public void call(Object... args) {}
    
    });
    socket.connect();
    */
  }
}
