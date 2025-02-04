package B_adts.rational;

public class RationalDemo {
    public static void main(String[] args) {
        Rational r1 = Rational.of(6, 15);
        Rationals.print(r1); // 2/5

        Rational r2 = Rational.of(60, 12);
        Rationals.print(r2); // 5/1

        Rational product = Rationals.product(r1, r2);
        Rationals.print(product); // 2/1
    }
}