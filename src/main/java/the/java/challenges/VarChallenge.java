package the.java.challenges;

import java.lang.reflect.InvocationTargetException;

import static java.lang.String.join;

public class VarChallenge {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        var myVar = new Object();
        var yourVar = new Object(){public Integer doit(){return 1;}};
        var theirVar = new Object(){public Integer doit(){return 1;}};
        var otherVar = yourVar.getClass().getDeclaredConstructor().newInstance();

        String v1 = myVar.getClass().equals(yourVar.getClass())    ? "a" : "b";
        String v2 = yourVar.getClass().equals(theirVar.getClass()) ? "c" : "d";
        String v3 = otherVar.getClass().equals(yourVar.getClass()) ? "e" : "f";
        String v4 = yourVar.doit().equals(otherVar.doit())         ? "g" : "h";

        System.out.println(join(":", v1, v2, v3, v4));

        // anonymous inner classes
        // 
    }
}
