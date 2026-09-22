
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {

        // Step 1: Store frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Scan the string from left to right
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequencyMap.get(ch) == 1) {
                return ch;
            }
        }

        // Return special value if no unique character exists
        return '\0';
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }

        scanner.close();
    }
}