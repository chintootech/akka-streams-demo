package demo1;

import akka.actor.ActorSystem;
import akka.japi.function.Function2;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

import java.util.concurrent.CompletionStage;
import java.util.stream.IntStream;

public class Ex3 {
  public static void main(String[] args) throws Exception {
    ActorSystem system = ActorSystem.create("demo1");
    ActorMaterializer materializer = ActorMaterializer.create(system);

    // Create a source with some integer and print them
    IntStream stream = IntStream.range(1, 11);
    Source<Integer, ?> source = Source.from(() -> stream.iterator());
    Integer zero = 0;
    Function2<Integer, Integer, Integer> f = (x, y) -> x + y;
    Sink<Integer, CompletionStage<Integer>> foldingSink = Sink.fold(zero, f);
    CompletionStage<Integer> foldingResult = source.runWith(foldingSink, materializer);

    foldingResult.thenAcceptAsync(c -> System.out.println("Number received: " + c),
        system.dispatcher());
  }
}
