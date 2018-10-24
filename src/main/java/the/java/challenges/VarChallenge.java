package the.java.challenges;

import static java.lang.String.join;

// A - a:c:e:g
// B - b:c:f:g
// C - b:d:f:h
// D - Throws java.lang.ClassCastException at line 21





public class VarChallenge {
 public static void main(String... fIsForFamily)
    throws IllegalAccessException, InstantiationException {
  var frank   = new Murphy() {Integer hasChildren(){return 3;}};
  var sue     = new Murphy() {Integer hasChildren(){return 3;}};
  var kevin   = new Murphy();
  var bill    = sue.getClass().newInstance();
  var var     = (Murphy) null;

  var m1 = frank.getClass().equals(sue.getClass())       ? "a" : "b";
  var m2 = sue.hasChildren().equals(frank.hasChildren()) ? "c" : "d";
  var m3 = sue.getClass().equals(kevin.getClass())       ? "e" : "f";
  var m4 = sue.getClass().equals(bill.getClass())        ? "g" : "h";

  System.out.println(join(":", m1, m2, m3, m4));
 }
 static class Murphy {}
}







// Non-Denotable types (like Anonymous Classes) can be inferred by var.
// assigning null to var
// var is not a keyword

// cons of using var
// why did Java use var? - show generics example Gen/1/2/3
