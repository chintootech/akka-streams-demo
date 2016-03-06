package demo3

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Ex1 extends App {
  implicit val system = ActorSystem("demo3")
  implicit val materializer = ActorMaterializer()

  // Create a stream composing two sources

}
