package the.java.challenges;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// A Rating: 0 time to go home :(
// B time to go home :( Rating: 12
// C time to go home :( Rating: 14
// D Rating: 12 time to go home :(

public class CompletableFutureChallenge {

    static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        CompletableFuture<Void> sanFranAdventure = new CompletableFuture<>();

        Supplier<List<String>> sightSupplier = () ->
                List.of("Alcatraz", "Cable Car", "Golden Gate", "Lombard Street");

        sanFranAdventure.supplyAsync(sightSupplier, executor)
                .thenComposeAsync(sights -> {
                    Supplier<List<Integer>> ratingSupplier = () ->
                            sights.stream()
                                    .map(String::length)
                                    .collect(Collectors.toList());
                    return CompletableFuture.supplyAsync(ratingSupplier);
                }, executor)
                .thenAcceptAsync(ratings -> {
                    Integer rating = ratings.stream()
                            .dropWhile(sightRating -> sightRating <= 12)
                            .findFirst()
                            .orElse(0);
                    System.out.print("Rating: " + rating + " ");
                }, executor);

        System.out.print("time to go home :( ");
    }
}
