import java.util.Scanner;

public class GradingSystem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input scores and fee status
        System.out.print("Enter exam score: ");
        double examScore = scanner.nextDouble();

        System.out.print("Enter assessment score: ");
        double assessmentScore = scanner.nextDouble();

        System.out.print("Has the student paid fees in full? (true/false): ");
        boolean feesPaid = scanner.nextBoolean();

        // Validate scores
        boolean examValid = examScore >= 0 && examScore <= 70;
        boolean assessmentValid = assessmentScore >= 0 && assessmentScore <= 30;

        // Determine pass/fail for exams and assessment
        boolean passExam = examValid && examScore >= 25;
        boolean passAssess = assessmentValid && assessmentScore >= 15;

        // Calculate total and condoned status
        boolean condoned = false;
        double total = 0;
        if (examValid && assessmentValid) {
            total = examScore + assessmentScore;
            condoned = (total == 39) && 
                ((examScore == 25 && assessmentScore == 14) || 
                 (examScore == 24 && assessmentScore == 15));
        }

        // Determine certificate status
        boolean certificateIssued = ((passExam && passAssess) || condoned) && feesPaid;

        // Determine if student needs to repeat
        boolean repeatRequired = false;
        if (examValid && assessmentValid) {
            repeatRequired = (total <= 39) && !passExam && !passAssess && !condoned;
        }

        // Output results
        System.out.println("Passed Exams: " + (passExam ? "Yes" : "No"));
        System.out.println("Passed Assessment: " + (passAssess ? "Yes" : "No"));
        System.out.println("Condoned Status: " + (condoned ? "Yes" : "No"));
        System.out.println("Certificate Issued: " + (certificateIssued ? "Yes" : "No"));
        System.out.println("Repeat Required: " + (repeatRequired ? "Yes" : "No"));

        scanner.close();
    }
}