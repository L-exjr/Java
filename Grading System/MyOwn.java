import java.util.Scanner;

public class MyOwn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables
        double examScore, assessmentScore, totalScore;
        boolean paidFees, Condoned, passedExam, passedAssess;
        String results = "", certificateStatus = "", repeatStatus = "";

        // Validate exam score (must be between 0 and 70)
        do {
            System.out.print("Enter exam score: ");
            examScore = scanner.nextDouble();

            if (examScore < 0 || examScore > 70) {
                System.out.println("Invalid. Enter a number between 0 and 70.");
            }
        } while (examScore < 0 || examScore > 70);

        // Validate assessment score (must be between 0 and 30)
        do {
            System.out.print("Enter assessment score: ");
            assessmentScore = scanner.nextDouble();

            if (assessmentScore < 0 || assessmentScore > 30) {
                System.out.println("Invalid. Enter a number between 0 and 30.");
            }
        } while (assessmentScore < 0 || assessmentScore > 30);

        // Validate fee payment status (Yes/No)
        while (true) {
            System.out.print("Have you paid your fees in full? (Yes/No): ");
            String input = scanner.next().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")) {
                paidFees = true;
                break; // Exit the loop if input is valid
            } else if (input.equals("no") || input.equals("n")) {
                paidFees = false;
                break; // Exit the loop if input is valid
            } else {
                System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
            }
        }

        // Total Score
        totalScore = examScore + assessmentScore;

        // Conditions
        passedExam = examScore >= 25;
        passedAssess = assessmentScore >= 15;
        Condoned = (totalScore == 39) && ((examScore == 25 && assessmentScore == 14) || (examScore == 24 && assessmentScore ==15));

        if ((passedExam && passedAssess) || Condoned) {
            if (Condoned) {
                results = "Condoned"; // Set results to "Condoned" if the Condoned condition is true
            } else {
                results = "Passed"; // Set results to "Passed" if the student passed without condonation
            }
        
            // Continue with the rest of the logic
            if (paidFees) {
                certificateStatus = "Issued";
            } else {
                certificateStatus = "Not issued due to unpaid fees";
            }
        }

        if (totalScore <= 39 && !Condoned){
            certificateStatus = "Not issued.";
            results = "Failed";

            if (!passedExam && !passedAssess){
            certificateStatus = "Not issued.";
            repeatStatus = "Repeated.";
            results = "Failed";
            }
        }

        //Outputs
        System.out.println("\n--------------------");
        System.out.println("Exam score: " + examScore + "/70");
        System.out.println("Assessment score: " + assessmentScore + "/30");
        System.out.println("Total score: " + totalScore);
        System.out.println("Results: " + results);
        System.out.println("Certificate status: " + certificateStatus);
        System.out.println("Repeat status: " + repeatStatus);

        if(!passedExam && !passedAssess) {
            System.out.println("\nYou failed both Exam and Assessment.");
        } else if (!passedExam && passedAssess) {
            System.out.println("\nYou failed Exam.");
        } else if (passedExam && !passedAssess) {
            System.out.println("\nYou failed Assessment.");
        }

        scanner.close();
    }
}