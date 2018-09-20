package the.java.challenges;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CompletableFuture {

    public static void main(String[] args) {
        challengeYourself();
    }

    static ExecutorService executor = Executors.newCachedThreadPool();

    static void challengeYourself() {
        CompletableFuture<Void> startSanFranAdventure = new CompletableFuture<>();

        Supplier<List<String>> sightSupplier = () -> List.of("Alcatraz", "Cable Car",
                "Golden Gate", "Lombard Street");

        Function<List<String>, CompletableFuture<List<Integer>>> sightRater =
                sights -> {
                    sleep(300); // take your time to view, then please rate the sights...
                    Supplier<List<Integer>> ratingSupplier = () ->
                            sights.stream()
                                    .map(String::length)
                                    .collect(Collectors.toList());
                    return CompletableFuture.supplyAsync(ratingSupplier);
                };

        startSanFranAdventure.supplyAsync(sightSupplier, executor)
                .thenComposeAsync(sightRater, executor)
                .thenAcceptAsync(ratings -> {
                    Integer rating = ratings.stream()
                            .filter(integer -> integer > 12)
                            .findFirst()
                            .orElse(0);
                    System.out.print("Rating: " + rating);
                }, executor);

        sleep(400);
        System.out.println(" done");
//        startSanFranAdventure.complete(null); // this should kick off the Void CF
    }

    private static void getThreadName(String lambdaName) {
        System.out.println(Thread.currentThread().getName() + " : " + lambdaName);
    }

    private static void sleep(int howLong) {
        try {
            Thread.sleep(howLong);
        } catch (InterruptedException e) {
        }
    }
}
