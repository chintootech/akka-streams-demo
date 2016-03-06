package demo3;

import akka.actor.ActorSystem;
import akka.dispatch.OnComplete;
import akka.stream.ActorMaterializer;
import akka.stream.ClosedShape;
import akka.stream.FanInShape2;
import akka.stream.Graph;
import akka.stream.Inlet;
import akka.stream.Outlet;
import akka.stream.UniformFanInShape;
import akka.stream.javadsl.*;
import scala.collection.immutable.Seq;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import scala.runtime.BoxedUnit;

import java.util.concurrent.CompletionStage;

public class Ex2 {
  public static void main(String[] args) throws Exception {
//    ActorSystem system = ActorSystem.create("demo3");
//    ActorMaterializer materializer = ActorMaterializer.create(system);
//
//    Graph<FanInShape2<Integer, Integer, Integer>, ?> zip =
//    		  ZipWith.create((Integer left, Integer right) -> Math.max(left, right));
//    // Create a new fan-in junction that takes 3 Integer inputs and outputs the max
//    Graph<UniformFanInShape<Integer, Integer>, ?> maxOfThree = Flow.fromGraph(GraphDSL.create( b -> {
//        FanInShape2<Integer,Integer,Integer> zip1 = b.add(zip);
//        FanInShape2<Integer, Integer, Integer> zip2 = b.add(zip);
//
//        b.from(zip1.out()).toInlet(zip2.in0());
//
//        // return the shape, which has three inputs and one output
//        return new UniformFanInShape<Integer, Integer>(zip2.out(), new Inlet[] {zip1.in0(), zip1.in1(), zip2.in1()});
//      }));

//    //Sink<Integer, Future<Integer>> sink = Sink.head();
//      Sink<Object, CompletionStage<Object>> sink = Sink.head();
//
//    RunnableGraph<Future<Integer>> runnable = RunnableGraph.<Future<Integer>>fromGraph(
//        Flow.fromGraph(GraphDSL.create(sink, (b, out) -> {
//            Outlet<Integer> s1 = b.add(Source.single(1)).out();
//            Outlet<Integer> s2 = b.add(Source.single(2)).out();
//            Outlet<Integer> s3 = b.add(Source.single(3)).out();
//        UniformFanInShape<Integer, Integer> pm3 = b.add(maxOfThree);
//
//        b.from(s1).toInlet(pm3.in(0));
//        b.from(s2).toInlet(pm3.in(1));
//        b.from(s3).toInlet(pm3.in(2));
//        b.from(pm3.out()).to(out);
//        return ClosedShape.getInstance();
//      }
//    )));
//
//    Future<Integer> max = runnable.run(materializer);
//    //System.out.println(Await.result(max, Duration.Inf()));
//    max.onComplete(new OnComplete<Integer>() {
//          @Override
//          public void onComplete(Throwable failure, Integer success) throws Exception {
//              if (failure != null) System.err.println("Failure: " + failure);
//              system.shutdown();
//              System.out.println(Await.result(max, Duration.Inf()));
//          }
//      }, system.dispatcher());
  }
}
