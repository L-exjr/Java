import java.util.Scanner;

public class GradingSystemArray {

    static class Student {
        double examScore;
        double assessmentScore;
        boolean feesPaid;
        boolean passExam;
        boolean passAssess;
        boolean condoned;
        boolean certificateIssued;
        boolean repeatRequired;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define array for 50,000 students
        final int MAX_STUDENTS = 50000;
        Student[] students = new Student[MAX_STUDENTS];

        System.out.print("Enter the number of students (<=50,000): ");
        int numStudents = scanner.nextInt();

        // Validate input
        if (numStudents < 1 || numStudents > MAX_STUDENTS) {
            System.out.println("Invalid number of students.");
            return;
        }

        // Input data for each student
        for (int i = 0; i < numStudents; i++) {
            students[i] = new Student();
            System.out.println("\nStudent " + (i + 1) + ":");
            
            System.out.print("Enter exam score: ");
            students[i].examScore = scanner.nextInt();
            
            System.out.print("Enter assessment score: ");
            students[i].assessmentScore = scanner.nextInt();
            
            System.out.print("Fees paid in full? (true/false): ");
            students[i].feesPaid = scanner.nextBoolean();
        }

        // Process each student
        for (int i = 0; i < numStudents; i++) {
            Student s = students[i];
            
            // Validate scores
            boolean examValid = s.examScore >= 0 && s.examScore <= 70;
            boolean assessValid = s.assessmentScore >= 0 && s.assessmentScore <= 30;

            // Determine pass/fail
            s.passExam = examValid && s.examScore >= 25;
            s.passAssess = assessValid && s.assessmentScore >= 15;

            // Check condoned status
            double total = s.examScore + s.assessmentScore;
            s.condoned = (total == 39) && 
                ((s.examScore == 25 && s.assessmentScore == 14) || 
                 (s.examScore == 24 && s.assessmentScore == 15));

            // Certificate eligibility
            s.certificateIssued = ((s.passExam && s.passAssess) || s.condoned) && s.feesPaid;

            // Repeat required
            s.repeatRequired = (total <= 39) && !s.passExam && !s.passAssess && !s.condoned;
        }

        // Output results
        System.out.println("\nResults:");
        for (int i = 0; i < numStudents; i++) {
            Student s = students[i];
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("Exams Passed: " + (s.passExam ? "Yes" : "No"));
            System.out.println("Assessment Passed: " + (s.passAssess ? "Yes" : "No"));
            System.out.println("Condoned: " + (s.condoned ? "Yes" : "No"));
            System.out.println("Certificate Issued: " + (s.certificateIssued ? "Yes" : "No"));
            System.out.println("Repeat Required: " + (s.repeatRequired ? "Yes" : "No"));
        }

        scanner.close();
    }
}