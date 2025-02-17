import java.util.Scanner;

public class NewGS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Variables
            double examScore = 0, assessmentScore = 0, totalScore;
            boolean paidFees = false, Condoned = false, passedExam = false, passedAssess = false;
            String results = "", certificateStatus = "", repeatStatus = "", grade = "";

            // Prompt for exam score or sentinel value
            System.out.print("Enter exam score: ");
            examScore = scanner.nextDouble();

            // Check for sentinel value
            if (examScore == -1) {
                System.out.println("Exiting the program...");
                break;
            }

            // Validate exam score (must be between 0 and 70)
            while (examScore < 0 || examScore > 70) {
                System.out.println("Invalid. Enter a number between 0 and 70.");
                System.out.print("Enter exam score: ");
                examScore = scanner.nextDouble();
            }

            // Validate assessment score (must be between 0 and 30)
            System.out.print("Enter assessment score: ");
            assessmentScore = scanner.nextDouble();
            while (assessmentScore < 0 || assessmentScore > 30) {
                System.out.println("Invalid. Enter a number between 0 and 30.");
                System.out.print("Enter assessment score: ");
                assessmentScore = scanner.nextDouble();
            }

            // Validate fee payment status (Yes/No)
            while (true) {
                System.out.print("Have you paid your fees in full? (Yes/No): ");
                String input = scanner.next().trim().toLowerCase(); // Normalize input

                switch (input) {
                    case "yes":
                    case "y":
                        paidFees = true;
                        break;
                    case "no":
                    case "n":
                        paidFees = false;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
                        continue;
                }
                break; // Exit the loop if input is valid
            }

            // Total Score
            totalScore = examScore + assessmentScore;

            // Determine Grade
            if (totalScore >= 70) {
                grade = "A";
            } else if (totalScore >= 60) {
                grade = "B";
            } else if (totalScore >= 50) {
                grade = "C";
            } else if (totalScore >= 40) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Conditions
            passedExam = examScore >= 25;
            passedAssess = assessmentScore >= 15;
            Condoned = (totalScore == 39) && ((examScore == 25 && assessmentScore == 14) || (examScore == 24 && assessmentScore == 15));

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

            if (totalScore <= 39 && !Condoned) {
                certificateStatus = "Not issued.";
                results = "Failed";

                if (!passedExam && !passedAssess) {
                    certificateStatus = "Not issued.";
                    repeatStatus = "Repeated.";
                    results = "Failed";
                }
            }

            // Outputs
            System.out.println("\n--------------------");
            System.out.println("Exam score: " + examScore + "/70");
            System.out.println("Assessment score: " + assessmentScore + "/30");
            System.out.println("Total score: " + totalScore);
            System.out.println("Grade: " + grade);
            System.out.println("Results: " + results);
            System.out.println("Certificate status: " + certificateStatus);
            System.out.println("Repeat status: " + repeatStatus);

            if (!passedExam && !passedAssess) {
                System.out.println("\nYou failed both Exam and Assessment.");
            } else if (!passedExam && passedAssess) {
                System.out.println("\nYou failed Exam.");
            } else if (passedExam && !passedAssess) {
                System.out.println("\nYou failed Assessment.");
            }

            System.out.println("\n--------------------\n");
        }

        scanner.close();
    }
}