package B_adts.rational;

/**
 * ADT for reduced-form rational numbers.
 * If r is a Rational.of(a, b) and g is the gcd(a, b),
 * then r.numer() equals a/g and r.denom() equals b/g.
 */
public interface Rational {
    /**
     * Returns a Rational representing a/b; throws ArithmeticException if b == 0.
     */
    static Rational of(int a, int b) {
        return new RationalImpl1(a, b);
    }

    /**
     * Returns the numerator of this Rational in reduced form.
     */
    int numer();

    /**
     * Returns the denominator of this Rational in reduced form.
     */
    int denom();
}