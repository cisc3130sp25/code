package B_adts.rational;

/**
 * Convenience methods for working with Rational objects.
 */
public class Rationals {
    /**
     * Prints a Rational in the form of a/b.
     */
    public static void print(Rational r) {
        System.out.println(r.numer() + "/" + r.denom());
    }

    /**
     * Returns the product of the two provided Rational objects.
     */
    public static Rational product(Rational r1, Rational r2) {
        return Rational.of(r1.numer() * r2.numer(), r1.denom() * r2.denom());
    }

    // Note that the above methods don't care about the internal representation:
    // they work equally well with RationalImpl1 and RationalImpl2 objects.

    // We can also have sum, difference, quotient, equals operations
}
