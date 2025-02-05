package C_generics.A_generic_classes.C_current_style;

public class PositiveInteger extends Number {
    private int value;

    public PositiveInteger(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
