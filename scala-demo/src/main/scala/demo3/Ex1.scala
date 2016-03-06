package demo3

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, _}
import akka.stream.scaladsl.GraphDSL.Implicits._
import akka.stream.scaladsl._

object Ex1 extends App {
  implicit val system = ActorSystem("demo3")
  implicit val materializer = ActorMaterializer()

  // Create a stream composing two sources
  val numbers = Source(List(1,2,3))
  val strings = Source(List("a", "b", "c"))

  val composite = Source.fromGraph(
    GraphDSL.create() { implicit b =>
      val zip = b.add(Zip[Int,String]())
      numbers ~> zip.in0
      strings ~> zip.in1

      SourceShape(zip.out)
    }
  )

  composite.runForeach(println)
  system.terminate
}
