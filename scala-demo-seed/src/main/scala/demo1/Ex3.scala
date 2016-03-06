package demo1

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Ex3 extends App {
  implicit val system = ActorSystem("demo1")
  implicit val materializer = ActorMaterializer()

  // Create a stream that folds it's elements

}
