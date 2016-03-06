package demo5

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object ErrorHandling3 extends App {

  implicit val system = ActorSystem("demo5")
  implicit val mat = ActorMaterializer()

  // Create a materializer with a supervision strategy that Resume if an ArithmeticException occurs.
  // The supervision strategy is applied only to the relevant junction.

}
