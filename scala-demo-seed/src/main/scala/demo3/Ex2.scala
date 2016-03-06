package demo3

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Ex2 extends App {
  implicit val system = ActorSystem("demo3")
  implicit val materializer = ActorMaterializer()

  // Create a new fan-in junction that takes 3 Int inputs and outputs the max

}
