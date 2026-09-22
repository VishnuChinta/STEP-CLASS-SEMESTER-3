
import java.util.Scanner;

public class ReverseCustomerName {

    // Method to reverse the customer name
    public static String reverseCustomerName(String customerName) {

        // Convert string to character array
        char[] characters = customerName.toCharArray();

        // Use StringBuilder to construct the reversed name
        StringBuilder reversedName = new StringBuilder();

        for (int i = characters.length - 1; i >= 0; i--) {

            reversedName.append(characters[i]);
        }

        return reversedName.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        // Call the reverse method
        String reversedName = reverseCustomerName(customerName);

        // Print original and reversed names
        System.out.println("\n========== CUSTOMER DETAILS ==========");

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }
}