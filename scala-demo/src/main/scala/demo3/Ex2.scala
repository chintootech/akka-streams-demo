package demo3

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, _}
import akka.stream.scaladsl.GraphDSL.Implicits._
import akka.stream.scaladsl._

import scala.concurrent.Await
import scala.concurrent.duration._

object Ex2 extends App {
  implicit val system = ActorSystem("demo3")
  implicit val materializer = ActorMaterializer()

  // Create a new fan-in junction that takes 3 Int inputs and outputs the max
  val maxOfThree = GraphDSL.create() { implicit b =>
    val zip1 = b.add(ZipWith[Int, Int, Int](math.max))
    val zip2 = b.add(ZipWith[Int, Int, Int](math.max))

    zip1.out ~> zip2.in0

    UniformFanInShape(zip2.out, zip1.in0, zip1.in1, zip2.in1)
  }

  // and now let's create a stream using this new fan-in shape

  val sink = Sink.head[Int]
  val g = RunnableGraph.fromGraph(
    GraphDSL.create(sink) { implicit b => out =>
      val s1 = Source.single(1)
      val s2 = Source.single(2)
      val s3 = Source.single(3)
      val pm3 = b.add(maxOfThree)

      s1 ~> pm3
      s2 ~> pm3
      s3 ~> pm3
      pm3 ~> out
      
      ClosedShape
    }
  )

  val max = g.run()
  val res = Await.result(max, Duration.Inf)
  println(res)
  system.terminate
}
