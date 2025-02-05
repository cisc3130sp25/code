package C_generics.A_generic_classes.D_variations;

import C_generics.A_generic_classes.C_current_style.Pair;
import C_generics.A_generic_classes.C_current_style.PositiveInteger;


/*
If we want a Pair class that will only allow us to create
a pair of Number, a pair of Integer, a pair of PositiveInteger, etc.,
but not other types of pairs, such as a pair of String,
this is another way to do it.

Note that this class is not a generic class -- it just
inherits from a generic class.
 */

public class NumberPair2 extends Pair<Number> {
    public NumberPair2(Number first, Number second) {
        super(first, second);
    }

    public double sum() {
        return getFirst().doubleValue() + getSecond().doubleValue();
    }

    public static void main(String[] args) {
        NumberPair2 pair = new NumberPair2(23.5, new PositiveInteger(1));
        Number first = pair.getFirst();
        Number second = pair.getSecond();
        System.out.println(pair.sum());

        // cannot do this:
        // NumberPair2 stringPair = new NumberPair2("a", "b");
    }
}