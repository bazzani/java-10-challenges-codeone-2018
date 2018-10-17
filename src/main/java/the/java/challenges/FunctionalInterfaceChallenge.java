package the.java.challenges;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

// A - -2
// B - 6
// C - 10
// D - java.lang.ArithmeticException: / by zero

public class FunctionalInterfaceChallenge {
    public static void main(String[] breakingBad) {
        BiFunction<Integer, Integer, Integer> walter = (a, b) -> a + b;
        Function<Integer, Integer> jesse = a -> a - 2;
        Function<Integer, Integer> mike = b -> b * 3;

        BiConsumer<Integer, Integer> gustavo = (a, b)
                -> System.out.println(a + 2 / b + 2);

        BiFunction<Integer, Integer, Integer> saul =
                walter.andThen(jesse).andThen(jesse).andThen(jesse);
        int firstLaunder = saul.apply(2, 2);

        walter.andThen(jesse).andThen(mike);
        int secondLaunder = walter.apply(2, 2);

        gustavo.accept(firstLaunder, secondLaunder);
    }
}
