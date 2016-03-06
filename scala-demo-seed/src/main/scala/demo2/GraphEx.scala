package demo2

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

// Important for using the FLowGraph DSL!

object GraphEx extends App {
  implicit val system = ActorSystem("demo2")
  implicit val materializer = ActorMaterializer()

  // create a stream for the following graph
  //                      f2
  // in -> f1 -> bcast /     \ merge -> f3 -> out
  //                   \  f4 /

}
