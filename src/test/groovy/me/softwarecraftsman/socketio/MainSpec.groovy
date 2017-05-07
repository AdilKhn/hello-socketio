import spock.lang.Specification

import io.socket.engineio.client.*;
import io.socket.client.*;
import io.socket.emitter.*;
import me.softwarecraftsman.socketio.Main;

class AppSpec extends Specification {
  def setupSpec(){
    print 'DOING SETUP'
  }
  def sendMessage(){
    return 'hello from socketio'
  }

  def "socket gets a message on 'chat message'"() {
    def recievedString = sendMessage()
    expect: Main.mainMethod() == 'done'
  }
}
