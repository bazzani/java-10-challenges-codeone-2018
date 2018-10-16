package the.java.challenges;

import static java.lang.String.join;

// A - a:c:e:g
// B - b:c:f:g
// C - b:d:f:h
// D - Throws java.lang.ClassCastException at line 18

public class VarChallenge {
   public static void main(String... fIsForFamily) throws IllegalAccessException, InstantiationException {
       var frank   = new Murphy() {public Integer hasChildren(){return 3;}};
       var sue     = new Murphy() {public Integer hasChildren(){return 3;}};
       var kevin   = new Murphy();
       var bill    = sue.getClass().newInstance();
       var maureen = (Murphy) null;
       var var     = Major.class;

       String m1 = frank.getClass().equals(sue.getClass())       ? "a" : "b";
       String m2 = sue.hasChildren().equals(frank.hasChildren()) ? "c" : "d";
       String m3 = sue.getClass().equals(kevin.getClass())       ? "e" : "f";
       String m4 = bill.getClass().equals(sue.getClass())        ? "g" : "h";

       System.out.println(join(":", m1, m2, m3, m4));
   }
   static class Murphy {}
   static class Major extends Murphy {}
}




// Non-Denotable types (like Anonymous Classes) can be inferred by var.
// assigning null to var
// var is not a keyword

// cons of using var
// why did Java use var? - show generics example Gen/1/2/3
