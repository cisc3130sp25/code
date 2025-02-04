package B_adts.rational;

public class RationalImpl1 implements Rational {
    // in this implementation, numer and denom are not stored in reduced form,
    // but the methods return reduced results

    private final int numer, denom;

    public RationalImpl1(int a, int b) {
        Utils.requireNonZero(b);
        numer = a;
        denom = b;
    }

    @Override
    public int numer() {
        return numer / Utils.gcd(numer, denom);
    }

    @Override
    public int denom() {
        return denom / Utils.gcd(numer, denom);
    }
}
