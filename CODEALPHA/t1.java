import java.util.ArrayList;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        while (true) {
            System.out.print("Enter a grade (or enter 'done' to finish): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade or 'done' to finish.");
            }
        }
        if (!grades.isEmpty()) {
            double sum = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                sum += grade;

                if (grade > highest) {
                    highest = grade;
                }

                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = sum / grades.size();
            System.out.println("\nGrade Summary:");
            System.out.println("Number of grades: " + grades.size());
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        } else {
            System.out.println("No grades entered.");
        }

        scanner.close();
    }
}
