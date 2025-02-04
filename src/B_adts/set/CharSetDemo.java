package B_adts.set;

public class CharSetDemo {
    public static void main(String[] args) {
        String s = "Mississippi";

        // how many distinct characters does s contain?

        CharSet set = CharSet.create();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        System.out.println(set.size());
    }
}
