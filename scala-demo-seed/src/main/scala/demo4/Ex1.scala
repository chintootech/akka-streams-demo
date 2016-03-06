package demo4

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Ex1 extends App {
  implicit val system = ActorSystem("demo4")
  implicit val materializer = ActorMaterializer()

  // Create a slow stream and show CPUs usage

}
