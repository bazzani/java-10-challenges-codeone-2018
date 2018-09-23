package the.java.challenges;

public class VarChallenge {
    public static void main(String[] args) {
        var myVar = new Object();
        var yourVar = new Object(){public Integer doit(){return 1;}};
        var theirVar = new Object(){public Integer doit(){return 1;}};
        var otherVar = yourVar;

        boolean c1 = myVar.getClass().equals(yourVar.getClass());
        boolean c2 = yourVar.getClass().equals(theirVar.getClass());
        boolean c3 = otherVar.getClass().equals(myVar.getClass());
        boolean c4 = yourVar.doit().equals(otherVar.doit());

        System.out.println(c1 + ":" + c2 + ":" + c3 + ":" + c4);
    }
}
