package demo5

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object ErrorHandling1 extends App {
  implicit val system = ActorSystem("demo5")
  implicit val materializer = ActorMaterializer()

  // Create a stream that will complete with a failure because of a division by zero

}
