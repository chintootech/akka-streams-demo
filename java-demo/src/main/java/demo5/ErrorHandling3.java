package demo5;

import java.util.concurrent.CompletionStage;
import java.util.stream.IntStream;

import akka.actor.ActorSystem;
import akka.japi.function.Function;
import akka.stream.ActorAttributes;
import akka.stream.ActorMaterializer;
import akka.stream.Supervision;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class ErrorHandling3 {
  public static void main(String[] args) throws Exception {
    ActorSystem system = ActorSystem.create("demo5");
    ActorMaterializer materializer = ActorMaterializer.create(system);

    Function<Throwable, Supervision.Directive> decider = e -> {
      if (e instanceof ArithmeticException)
        return Supervision.resume();
      else
        return Supervision.stop();
    };

    IntStream stream = IntStream.range(0, 6);
    Source<Integer, ?> source = Source.from(() -> stream.iterator()).map(x -> 100 / x)
        .withAttributes(ActorAttributes.withSupervisionStrategy(decider));
    CompletionStage<Integer> result = source.runWith(Sink.fold(0, (x, y) -> x + y), materializer);
    // this will print 228
    result.thenAcceptAsync(res -> System.out.println("Result: " + res),
        system.dispatcher());
  }
}
