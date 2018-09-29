package the.java.challenges;

public class VarChallenge {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        var myVar = new Object();
        var yourVar = new Object(){public Integer doit(){return 1;}};
        var theirVar = new Object(){public Integer doit(){return 1;}};
        var otherVar = yourVar.getClass().newInstance();

        String v1 = myVar.getClass().equals(yourVar.getClass()) ? "a" : "b";
        String v2 = yourVar.getClass().equals(theirVar.getClass()) ? "c" : "d";
        String v3 = otherVar.getClass().equals(yourVar.getClass()) ? "e" : "f";
        String v4 = otherVar.getClass().equals(Object.class) ? "g" : "h";

        System.out.println(v1 + ":" + v2 + ":" + v3 + ":" + v4);
    }
}
