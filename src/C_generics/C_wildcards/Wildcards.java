package C_generics.C_wildcards;

/*
- Recall that every Java class either explicitly extends another 
  class or implicitly extends the Object class.
    - (There is only one exception to this rule: the Object class itself,
      which neither explicitly nor implicitly extends another class.)
- Thus every class (except Object) inherits from Object.

- When A inherits from B, we say that A is a subtype of B and 
  that B is a supertype of A.
    - For example, Double is a subtype of Number.
    - Also, Double is a subtype of Object, since Number extends Object.
- A variable of a supertype can refer to an object of a subtype. 
  This is an example of polymorphism.
    - For example, we can say this: Object o = new Double(1);
    - Moreover, if we have a method like this:
          public static void someMethod(Object o) {
              // ...
          }
      we can invoke the method like this:
          someMethod(new Double(1));
- However, the reverse is not true.
    - Thus we cannot say Double r = new Object();
    - And if we have a method like this:
          public static void someMethod(Double r) {
              // ...
          }
      we cannot invoke it like this:
          someMethod(new Object());

- When we have an array or List or ArrayList or Pair that is declared 
  to contain elements of some type, those elements are really 
  just references of that type, not objects.
- Therefore, those elements can refer to objects of their subtypes.
    - For example, suppose we have:
          Object[] arr = new Object[2];
          ArrayList<Object> list = new ArrayList<>();
          Pair<Object> pair = new Pair<>(new Object(), new Object());
      then the following lines work:
          arr[0] = new Double(1);
          arr[1] = 56;
          list.add(new Double(1));
          pair.setFirst(new Double(1));
      The idea is: every Double is an Object, so an element
      of an ArrayList<Object> can refer to a Double.
      It's like saying Object o = new Double(1), which works.
    - Similarly, if we have:
          Number[] numberArr = new Number[10];
          ArrayList<Number> numberList = new ArrayList<>();
          Pair<Number> numberPair = new Pair<>(new Double(1), new Double(4));
          // cannot say new Number(), since Number is an abstract class.
      then the following lines work:
          numberArr[0] = new Double(1);
          numberList.add(new Double(1));
          numberPair.setFirst(new Double(1));
      Again the idea is: every Double is a Number, so an
      element of an ArrayList<Number> can refer to a Double.
      It's like saying Number num = new Double(1), which works.
    - But -- and this important -- it doesn't work in reverse. Thus, 
      if we have this:
          ArrayList<Double> list = new ArrayList<>();
      we cannot do this:
          list.add(new Object());
      Why? The idea is that an Object isn't a Double. It's like
      saying Double r = new Object(), which doesn't work.

- Question: is Double[] a subtype of Object[]?
    - Answer: yes.
    - Thus we can say Object[] arr = new Double[3];
    - This also works: Object[] arr = {new Double(1), new Double(2)};
    - Every element of arr is a reference of type Object and can 
      therefore refer to a Double.

- Question: is ArrayList<Double> a subtype of ArrayList<Object>?
    - Answer: no. (This is not intuitive.)
    - Thus if we have a method like this:
          public static void someMethod(ArrayList<Object> list) {
              // ...
          }
      we CANNOT invoke it like this:
          ArrayList<Double> list = new ArrayList<>();
          someMethod(list);
    - Why not?
        - Suppose we have the following perfectly legal method:
              public static void someMethod(ArrayList<Object> list) {
                list.add(0, new Object());
              }
          And somewhere else, we have this:
              ArrayList<Double> list = new ArrayList<>();
              someMethod(list); // supposing that this would be allowed
              Double r = list.get(0);
        - The code would compile fine, but the last line would 
          generate a ClassCastException, since a Double reference
          variable cannot refer to an object of type Object.
        - To avoid such issues, Java doesn't consider an 
          ArrayList<Double> to be a subtype of ArrayList<Object>.
- More generally: Even if A is a subtype of B, an ArrayList<A> is not 
  considered a subtype of ArrayList<B>.
  Similarly, a Pair<A> is not considered a subtype of Pair<B>.
- Here's a more intuitive way to understand why an ArrayList<A> is not 
  considered a subtype of ArrayList<B>.
    - "A is a subtype of B" means that A has at least whatever B has 
      (and possibly more).
        - For example, Double is a subtype of Object, since a Double
          can do at least whatever an Object can do (call toString, equals, etc.).
    - But while we can add both As and Bs to an ArrayList<B>, we can only 
      add As to an ArrayList<A>.
        - For example, while we can add Doubles and Objects to an
          ArrayList<Object>, we can only add Doubles to an ArrayList<Double>.

Bottom line:
If MyClass is a generic class (or interface), then MyClass<A> is never 
considered to be a subtype of MyClass<B>, even if A is a subtype of B. 

More examples:
- An ArrayList<Number> can contain Integers and Doubles, but not Strings.
- An ArrayList<Object> can contain Integers, Doubles, and Strings.
- ArrayList<Double> is a subtype of List<Double>
- ArrayList<Double> is NOT a subtype of List<Number>
- ArrayList<Double> is NOT a subtype of ArrayList<Number>
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wildcards {
    public static void main(String[] args) {
        // method header:
        // public static void printRandomObject(List<Object> list)
        List<Object> objectList = List.of(new Object(), "cat", 34);
        System.out.print("random element of object list: ");
        printRandomObject(objectList);

        // won't compile, since List<String> is not a subtype of List<Object>
        // List<String> stringList = List.of("hello", "world");
        // System.out.println("random element of String list: ");
        // printRandomObject(stringList); // stringList is a List<String>

        // method header: public static void printRandomElement(List<?> list)
        System.out.print("random element of object list: ");
        printRandomElement(objectList);
        List<String> stringList = List.of("hello", "world");
        System.out.print("random element of String list: ");
        printRandomElement(stringList);


        // method header: public static double sum(List<? extends Number> list)
        List<Number> numberList = List.of(56, 7.8);
        System.out.println(sum(numberList));
        List<Integer> integerList = List.of(5, 7, 1);
        System.out.println(sum(integerList));
        List<Double> doubleList = List.of(1.1, 2.2);
        System.out.println(sum(doubleList));

        // method header:
        // public static void addRandomIntegerAtHead(List<? super Integer> list)
        ArrayList<Object> list = new ArrayList<>();
        list.add(5);
        addRandomIntegerAtHead(list);
    }

    // We cannot pass to this method a List<String>,
    // as List<String> is not considered to be a subtype of List<Object>,
    // even though String is a subtype of Object.
    public static void printRandomObject(List<Object> list) {
        Random generator = new Random();
        int index = generator.nextInt(list.size());
        System.out.println(list.get(index));
    }

    // we can pass to this method any of the following examples:
    // List<Object>, List<Integer>, List<Number>, List<String>,
    // ArrayList<Object>, ArrayList<Integer>, ArrayList<Number>, ArrayList<String>,
    public static void printRandomElement(List<?> list) {
        Random generator = new Random();
        int index = generator.nextInt(list.size());
        System.out.println(list.get(index));
    }
  /*
  The ? is called a wildcard; here we are using an unbounded wildcard. 
  (Below we discuss bounded wildcards.)
  List<?> means: List of unknown element type.
  The method header
      public static void printRandomElement(List<?> list)
  works just like
      public static <E> void printRandomElement(List<E> list).
  We can use an unbounded wildcard instead of E here, since we have 
  no need to use the type paramter E inside the method or for the 
  return type (unlike in the swap method, where we used E
  inside the method).
   */


    // The upper bounded wildcard, <? extends Foo>, where Foo is any type, 
    // matches Foo and any SUBtype of Foo.
    // We can pass to this method a List<Number>, a List<Double>, a List<Integer>,
    // an ArrayList<Number>, ArrayList<Double>, or an ArrayList<Integer>, etc.
    // But we cannot pass to this method a List<Object>, nor a List<String>.
    public static void doSomething1(List<? extends Number> list) {
        // ...
    }

    public static double sum(List<? extends Number> list) {
        double sum = 0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum;
    }

    // The lower bounded wildcard, <? super Foo>, where Foo is any type, 
    // matches Foo and any SUPERtype of Foo. 
    // We can pass to this method a List<Number>, a List<Object>,
    // an ArrayList<Number> or ArrayList<Object>.
    // But we cannot pass to this method an ArrayList<Double>
    // (nor an ArrayList<Integer>, etc.) nor an ArrayList<String>,
    // nor a List<String>, nor a List<Integer>
    public static void doSomething2(List<? super Number> list) {
        // ...
    }

    // we can pass to this method List<Integer>, or a List<Number>,
    // or List<Object>, but not a List<String>.
    public static void addRandomIntegerAtHead(List<? super Integer> list) {
        Random generator = new Random();
        int r = generator.nextInt();
        list.add(0, r);
    }
}