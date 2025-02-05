package C_generics.A_generic_classes.B_old_style_generics;

/*
This is the old-fashioned way of doing generics in Java. 
It easily leads to buggy code.
This way has been out of style since Java version 5, 
which was released in 2004.
 */

public class ObjectPair {
    private Object first, second;

    public ObjectPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        ObjectPair integerPair = new ObjectPair(45, 33); // works

        ObjectPair stringPair = new ObjectPair("a", "b"); // works

      // so far, so good.
      // but there are issues with this approach to writing generic classes

        String f = (String) stringPair.getFirst(); // cast required!

        // compiler lets this through, but we want to prevent this!
        stringPair.setFirst(33);

        // compiler will allow, but this line will generate a
        // ClassCastExceptionwhen the program runs
        f = (String) stringPair.getFirst();
    }
}
