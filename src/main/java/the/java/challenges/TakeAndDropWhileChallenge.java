package the.java.challenges;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * A - 76578
 * B - 78657
 * C - 786578
 * D - 7 and random values
 */
public class TakeAndDropWhileChallenge {

    public static void main(String... castleVania) {
        List<Integer> alucardHits = List.of(9, 7, 1, 8, 5);
        Set<Integer> draculaHits = Set.of(9, 6, 5, 7, 8);

        Stream<Integer> alucardPerformedHits = alucardHits.stream()
                .takeWhile(i -> i > 5)
                .dropWhile(i -> i > 8);

        Stream<Integer> draculaPerformedHits = draculaHits.stream()
                .takeWhile(i -> i > 1)
                .dropWhile(i -> i > 7);

        Stream.of(alucardPerformedHits, draculaPerformedHits).flatMap(h -> h)
                .forEach(System.out::print);
    }

}
