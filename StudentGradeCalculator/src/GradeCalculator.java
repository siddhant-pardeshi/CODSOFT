import java.util.Scanner;

class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of Subjects : ");
        int subjects = scanner.nextInt();
        int totalMarks = 0;
        // Input marks for each subject
        for(int i = 1 ; i <= subjects ; i++){
            System.out.print("Enter marks for Subject number " + i + " (out of 100): ");
            int Marks = scanner.nextInt();

            // Calculate total marks
            totalMarks += Marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / subjects;

        // Determine overall grade based on average percentage
        char overallGrade = calculateOverallGrade(averagePercentage);

        // Display results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Overall Grade: " + overallGrade);

        scanner.close();
    }

    // Function to calculate overall grade based on average percentage
    private static char calculateOverallGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
