
import java.util.Scanner;

public class BMICalculator {

    // Method to classify BMI
    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Method to print the wellness report
    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.printf("%-10s %-15s %-15s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double height = heights[i];
            double weight = weights[i];

            // Calculate BMI
            double bmi = weight / (height * height);

            // Get BMI classification
            String status = getBmiStatus(bmi);

            // Print details
            System.out.printf("%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                    i + 1,
                    height,
                    weight,
                    bmi,
                    status);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = scanner.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];

        // Accept data for each person
        for (int i = 0; i < n; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter height (meters): ");
            heights[i] = scanner.nextDouble();

            System.out.print("Enter weight (kg): ");
            weights[i] = scanner.nextDouble();

            // Basic input validation
            if (heights[i] <= 0 || weights[i] <= 0) {
                System.out.println("Height and weight must be positive.");

                i--;
            }
        }

        System.out.println("\n========== WELLNESS REPORT ==========");

        printWellnessReport(heights, weights);

        scanner.close();
    }
}