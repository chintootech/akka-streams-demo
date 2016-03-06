package demo1

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Ex1 extends App {
  implicit val system = ActorSystem("demo1")
  implicit val materializer = ActorMaterializer()

  // Create a source with some integer and print them
}
