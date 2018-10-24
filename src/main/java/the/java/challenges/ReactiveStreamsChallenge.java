package the.java.challenges;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * A - Homer Barney Lenny Moe, get the shotgun
 * B - Homer No beer. Moe, get the shotgun
 * C - It will be a random result
 * D - Homer Barney Lenny and StackOverflowError will be thrown
 */
public class ReactiveStreamsChallenge {

    public static void main(String... moesTavern) throws InterruptedException {
        var moe = new BeerPourer();
        BeerDrinker drunkenHobo = new BeerDrinker();
        moe.subscribe(drunkenHobo);
        var drinkers = List.of("Homer ", "Barney ", "Lenny");
        drinkers.stream().forEach(s -> moe.submit(s));

        while (anyDrinkersLeft(drinkers)) { Thread.sleep(10); }

        System.out.print(" Moe, get the shotgun");
        moe.close();
    }

    private static boolean anyDrinkersLeft(List<String> drinkers) {
        return drinkers.size() > BeerDrinker.counter; }
}

class BeerPourer extends SubmissionPublisher<String> { }

class BeerDrinker implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;
    public static int counter = 0;

    public void onSubscribe(Flow.Subscription subscription) { this.subscription = subscription;
        this.subscription.request(1); }

    public void onNext(String simpson) { System.out.print(simpson);
        this.subscription.request(counter++);
    }
    public void onError(Throwable e) { System.out.print("No beer."); counter = 4; }
    public void onComplete() {
        throw new StackOverflowError(); }
}