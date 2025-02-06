package B_adts.rational;

public class RationalImpl2 implements Rational {
    // in this implementation, numer and denom are stored in reduced form
    private final int numer, denom;

    public RationalImpl2(int a, int b) {
        Utils.requireNonZero(b);
        int gcd = Utils.gcd(a, b);
        numer = a / gcd;
        denom = b / gcd;
    }

    @Override
    public int numer() {
        return numer;
    }

    @Override
    public int denom() {
        return denom;
    }
}
