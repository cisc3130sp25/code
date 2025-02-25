package E_recursion;
 
public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindromeEfficient("racecar"));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
 
        String middle = s.substring(1, s.length() - 1);
        return s.charAt(0) == s.charAt(s.length() - 1)
                && isPalindrome(middle);
    }
 
    public static boolean isPalindromeEfficient(String s) {
        return isPalindromeEfficient(s, 0, s.length() - 1);
    }
 
    // Determines whether the characters in s from
    // startIndex through endIndex form a palindrome.
    // more efficient since we don't create new Strings (with substring method)
    private static boolean isPalindromeEfficient(String s,
                                                int startIndex,
                                                int endIndex) {
        if (startIndex >= endIndex) {
            return true;
        } else {
            return s.charAt(startIndex) == s.charAt(endIndex)
                    && isPalindromeEfficient(s, startIndex + 1, endIndex - 1);
        }
    }
 
    public static double sum(double[] arr) {
        return sum(arr, 0);
    }
 
    // returns the sum of the elements of arr from
    // startIndex and onwards
    private static double sum(double[] arr, int startIndex) {
        if (startIndex >= arr.length) {
            return 0;
        } else {
            return arr[startIndex] + sum(arr, startIndex + 1);
        }
    }
}