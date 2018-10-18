package the.java.challenges;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

import static java.lang.Thread.sleep;

public class ProcessHandleChallenge {
    static final int CONSTRUCTION_TIME = 100;
    static int piggyCount = 0;
    static Map<Long, Integer> piggies = new LinkedHashMap<>();

    public static void main(String... threeLittlePigs) throws IOException, InterruptedException {
        var javaCmd = ProcessHandle.current().info().command().get(); // ~/java.exe

        for (int piggyIndex = 0; piggyIndex < 3; Wolf.lickLips()) {
            Process littlePig = new ProcessBuilder(javaCmd, "--list-modules").start();
            littlePig.toHandle().onExit().thenAccept(huffAndPuff);
            buildPiggyHouse(piggyIndex * CONSTRUCTION_TIME);
            piggies.put(littlePig.pid(), piggyCount = ++piggyIndex);
        }
        sleep(1000);
    }

    static Consumer<ProcessHandle> huffAndPuff = piggy -> {
        if (piggies.get(piggy.pid()) != 3) { eatPiggy(piggy); }
        else { System.out.println("Wolf for dinner!"); }
    };

    private static void buildPiggyHouse(int buildTime) throws InterruptedException {
        sleep(buildTime);
    }

    private static void eatPiggy(ProcessHandle piggy) {
        System.out.println("Yum Yum Piggy : " + piggies.get(piggy.pid()));
        --piggyCount;
        piggies.remove(piggy.pid());
    }

    static class Wolf {
        static int hungerFactor;
        static void lickLips() { ++hungerFactor; }
    }
}


