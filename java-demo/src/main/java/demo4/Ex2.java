package demo4;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.*;
import akka.stream.javadsl.*;

import java.util.stream.IntStream;

public class Ex2 {
  public static void main(String[] args) throws Exception {
    ActorSystem system = ActorSystem.create("demo2");
    ActorMaterializer materializer = ActorMaterializer.create(system);

    // Let's create a cycle
    //
    // source → merge → printer → bcast → sink.ignore
    //             ↑                ↓
    //             ←←←←←←←←←
    RunnableGraph<NotUsed> runnable = RunnableGraph.fromGraph(GraphDSL.create(b -> {
      IntStream numbers = IntStream.iterate(1, x -> x + 1);
      Outlet<Integer> source = b.add(Source.from(() -> numbers.iterator())).out();
      UniformFanInShape<Integer, Integer> merge = b.add(Merge.create(2));
      UniformFanOutShape<Integer, Integer> bcast = b.add(Broadcast.create(2));
      FlowShape<Integer, Integer> printer = b.add(Flow.of(Integer.class).map(x -> {
        System.out.println(x);
        return x;
      }));
      SinkShape<Integer> sink = b.add(Sink.ignore());

      b.from(source).viaFanIn(merge).via(printer).viaFanOut(bcast).to(sink);
      b.to(merge).fromFanOut(bcast);
      return ClosedShape.getInstance();
    }));

    runnable.run(materializer);
  }
}
