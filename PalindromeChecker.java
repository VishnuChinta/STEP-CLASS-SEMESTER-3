
import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative comparison
    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text) {

        return recursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean recursiveHelper(String text, int left, int right) {

        // Base case
        if (left >= right) {
            return true;
        }

        // Compare characters
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        // Recursive call
        return recursiveHelper(text, left + 1, right - 1);
    }

    // Approach 3: Array reversal
    public static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();

        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or text: ");
        String text = scanner.nextLine();

        // Convert to lowercase for case-insensitive comparison
        text = text.toLowerCase();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text);
        boolean result3 = isPalindromeArrayReversal(text);

        System.out.println("\n========== RESULTS ==========");

        System.out.println("Iterative: " +
                (result1 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (result2 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (result3 ? "Palindrome" : "Not Palindrome"));

        // Verify that all approaches agree
        if (result1 == result2 && result2 == result3) {
            System.out.println("\nAll three approaches agree.");
        } else {
            System.out.println("\nResults do not agree.");
        }

        scanner.close();
    }
}