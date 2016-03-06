package demo4

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._

object Ex1 extends App {
  implicit val system = ActorSystem("demo4")
  implicit val materializer = ActorMaterializer()

  // Create a slow stream and show CPUs usage
  val source = Source.fromIterator(() => Iterator.from(1))
  source.map { e => Thread.sleep(1000); e}.runForeach(println)
}
