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
}
