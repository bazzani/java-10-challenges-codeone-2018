package the.java.challenges;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionFactoriesChallenge {
    public static void main(String... doYourBest) {
        List<String> dcHeros = List.of("Batman", "Robin", "Superman", "Robin");
        Set<String> dcVillains = Set.of("Joker", "Penguin", "Lex Luthor");
        Map<String, String> dcBattles = Map.of("Batman", "Joker", "Robin",
                "Penguin", "Superman", "Lex Luthor",
                "Penguin", "Batman");
        Set<String> herosSet = Set.copyOf(dcHeros);

        try {
            dcHeros.add("Wonder Woman");
        } catch (UnsupportedOperationException e) {
            System.out.println("no space for heros");
        }

        try {
            dcVillains.stream().collect(Collectors.toList()).add("Harley Quinn");
        } catch (UnsupportedOperationException e) {
            System.out.println("no space for villains");
        }

        try {
            Set.copyOf(dcVillains).remove("Harley Quinn");
        } catch (UnsupportedOperationException | NullPointerException e) {
            System.out.println("Where is Harley?");
        }
    }

    // modify in try catch


// https://dzone.com/articles/immutable-vs-unmodifiable-in-jdk-10
// View Collections
// Collections.checkedCollection,
// Collections.synchronizedCollection
// Collections.unmodifiableCollection
// List.subList
// NavigableSet.subSet
// Map.entrySet
// Unmodifiable Collections
// Unmodifiable View Collections
// Collections.unmodifiableCollection
// Collections.unmodifiableList
// Collectors toUnmodifiableList(), toUnmodifiableSet(), toUnmodifiableMap
}
