import java.util.InputMismatchException;
import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args)

    {
        Scanner scanner = new Scanner(System.in);

        int examScore = getExamScore(scanner);
        int assessmentScore = getAssessmentScore(scanner);
        boolean feesPaid = getFeesPaid(scanner);

        int totalScore = examScore + assessmentScore;
        String result = "";
        String certificateStatus = "";
        String repeatStatus = "";

        if (examScore >= 25 && assessmentScore >=15) {
            result = "Passed";
            if (feesPaid) {
                certificateStatus = "Certificate issued";
            } 

            else {
                certificateStatus = "Certificate not issued due to unpaid fees"; 
            }
        }

        else if (totalScore == 39) {
            result = "Condoned";

            if (feesPaid) {
                certificateStatus = "Certificate issued";
            }

            else {
                certificateStatus = "Certificate not issued due to unpaid fees";
            }
        }

        else {
            result = "Failed";
            repeatStatus = "Repeated";
        }

        System.out.println("\nResult:");
        System.out.println("Exam score: " + examScore + "/70");
        System.out.println("Assessment score: " + assessmentScore + "/30");
        System.out.println("Total score: " + totalScore);
        System.out.println("Results: " + result);
        System.out.println("Certificate status: " + certificateStatus);
        System.out.println("Repeat status: " + repeatStatus);

        if (examScore < 25) {
            System.out.println("\nYou failed exam");
        }

        if (assessmentScore < 15) {
            System.out.println("\nYou failed assessment");
        }
    }

    private static int getExamScore(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter your exam score (out of 70): ");
                int score = scanner.nextInt();
                if (score >= 0 && score <=70){
                    scanner.nextLine(); 
    
                    return score;
                }
                System.out.println("Invalid score. Please enter a value between 0 and 70.");
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
                
            }
        }
    }

    private static int getAssessmentScore(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter your assessment score (out of 30): ");
                int score = scanner.nextInt();
                if (score >= 0 && score <=30) {
                    scanner.nextLine();
                    
                    return score;
                }
                System.out.println("Invalid score. Please enter a value between 0 and 30.");
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
                
            }
        }
    }

    private static boolean getFeesPaid(Scanner scanner) {
        while (true) {
            System.out.print("Have you paid your fees in full? (Yes/No): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            }
            else if (input.equals("no")) {
                return false;
            }
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }
}