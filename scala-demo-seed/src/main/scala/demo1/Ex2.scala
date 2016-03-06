package demo1

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Ex2 extends App {
  implicit val system = ActorSystem("demo1")
  implicit val materializer = ActorMaterializer()

  // Create a stream with a mapping stage (using a Flow)

}
