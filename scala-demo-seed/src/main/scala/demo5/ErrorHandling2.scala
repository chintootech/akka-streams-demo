package demo5

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object ErrorHandling2 extends App {

  implicit val system = ActorSystem("demo5")
  implicit val materializer = ActorMaterializer()

  // Create a materializer with a supervision strategy that Resume if an ArithmeticException occurs.
  // The superision strategy is applied to the whole stream.

}
