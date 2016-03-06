package demo1

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._

object Ex1 extends App {
  implicit val system = ActorSystem("demo1")
  implicit val materializer = ActorMaterializer()

  // Create a source with some integer and print them
  val source = Source(List(1,2,3))
  val sink = Sink.foreach(println)
  val runnable: RunnableGraph[NotUsed] = source.to(sink)
  runnable.run()
}
