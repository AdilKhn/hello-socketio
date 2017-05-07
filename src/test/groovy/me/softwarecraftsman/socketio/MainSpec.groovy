 import spock.lang.Specification


 class AppSpec extends Specification {
   def "The Greeting"(){
    "this should happen"
    expect: new App().getGreeting() == 'Hi'
  }
   def "The Farewell"(){
    expect: new App().getFarewell() == 'Bye'
  }
 }
