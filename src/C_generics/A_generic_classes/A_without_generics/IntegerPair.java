package C_generics.A_generic_classes.A_without_generics;

public class IntegerPair {
    private Integer first, second;

    public IntegerPair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        IntegerPair pair = new IntegerPair(45, 33); // autoboxing
        System.out.println(pair); // (45, 33)
        pair.setFirst(76);
        System.out.println(pair.getFirst()); // 76

        // doesn't work
        // IntegerPair pair2 = new IntegerPair("a", "b");
    }
}