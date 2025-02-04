package B_adts.rational;

// utility methods
class Utils {
    /*
    Euclid's algorithm:
        GCD(A, B) = GCD(B, A % B)
        GCD(A, 0) = Absolute value of A
    */
    static int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    static void requireNonZero(int val) {
        if (val == 0) {
            throw new ArithmeticException();
        }
    }
}
