package demo1;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;

import akka.Done;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import scala.concurrent.Future;
import scala.runtime.BoxedUnit;

public class Ex1 {
  public static void main(String[] args) {
    ActorSystem system = ActorSystem.create("demo1");
    ActorMaterializer materializer = ActorMaterializer.create(system);

    // Create a source with some integer and print them
    Source<Integer, ?> source = Source.from(Arrays.asList(0,1,2,3));
    Sink<Integer, CompletionStage<Done>> sink = Sink.foreach(x -> System.out.println(x));
    RunnableGraph<?> runnable = source.to(sink);
    runnable.run(materializer);
  }
}
