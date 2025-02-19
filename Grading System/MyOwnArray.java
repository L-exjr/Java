import java.util.Scanner;

public class MyOwnArray {

    static class Student {
        String certStat = "", results = "", repeatStat = "";
        double examScore, assessmentScore, totalScore;
        boolean condoned, paidFees, passExam, passAssess;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initializing Array
        Student[] students = new Student[60000];

        int numStudents;

        // Number of students
        do {
            System.out.print("Enter number of students: ");
            numStudents = scanner.nextInt();

            if (numStudents < 1 || numStudents > 60000) {
                System.out.println("Invalid. Enter number between 0 and 60,000");
            }
        } while (numStudents < 1 || numStudents > 60000);

        for (int i=0; i < numStudents; i++) {
            students[i] = new Student();
            System.out.println("\nStudent " + (i + 1) + ":");

            do {
                System.out.print("Enter exam score: ");
                students[i].examScore = scanner.nextDouble();
    
                if (students[i].examScore < 0 || students[i].examScore > 70) {
                    System.out.println("Invalid. Enter a number between 0 and 70.");
                    scanner.next();
                }
            } while (students[i].examScore < 0 || students[i].examScore > 70);

            do {
                System.out.print("Enter assessment score: ");
                students[i].assessmentScore = scanner.nextDouble();
    
                if (students[i].assessmentScore < 0 || students[i].assessmentScore > 30) {
                    System.out.println("Invalid. Enter a number between 0 and 30.");
                    scanner.next();
                }
            } while (students[i].assessmentScore < 0 || students[i].assessmentScore > 30);

            while (true) {
                System.out.print("Have you paid your fees in full? (Yes/No): ");
                String input = scanner.next().trim().toLowerCase(); // Normalize input
    
                if (input.equals("yes") || input.equals("y")) {
                    students[i].paidFees = true;
                    break; // Exit the loop if input is valid
                } else if (input.equals("no") || input.equals("n")) {
                    students[i].paidFees = false;
                    break; // Exit the loop if input is valid
                } else {
                    System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
                }
            }
            // Total Score
            students[i].totalScore = students[i].examScore + students[i].assessmentScore;

            // Conditions
            students[i].passExam = students[i].examScore >= 25;
            students[i].passAssess = students[i].assessmentScore >= 15;
            students[i].condoned = (students[i].totalScore == 39) && ((students[i].examScore == 25 && students[i].assessmentScore == 14) || (students[i].examScore == 24 && students[i].assessmentScore ==15));

            if ((students[i].passExam && students[i].passAssess) || students[i].condoned) {
                if (students[i].condoned) {
                    students[i].results = "Condoned"; // Set results to "Condoned" if the Condoned condition is true
                } else {
                    students[i].results = "Passed"; // Set results to "Passed" if the student passed without condonation
                }
        
                // Continue with the rest of the logic
                if (students[i].paidFees) {
                    students[i].certStat = "Issued";
                } else {
                    students[i].certStat = "Not issued due to unpaid fees";
                }
            }

            if (students[i].totalScore <= 39 && !students[i].condoned){
                students[i].certStat = "Not issued.";
                students[i].results = "Failed";

                if (!students[i].passExam && !students[i].passAssess){
                    students[i].certStat = "Not issued.";
                    students[i].repeatStat = "Repeated.";
                    students[i].results = "Failed";
                }
            }

            //Outputs
            System.out.println("\n--------------------");
            System.out.println("Exam score: " + students[i].examScore + "/70");
            System.out.println("Assessment score: " + students[i].assessmentScore + "/30");
            System.out.println("Total score: " + students[i].totalScore);
            System.out.println("Results: " + students[i].results);
            System.out.println("Certificate status: " + students[i].certStat);
            System.out.println("Repeat status: " + students[i].repeatStat);

            if(!students[i].passExam && !students[i].passAssess) {
                System.out.println("\nYou failed both Exam and Assessment.");
            } else if (!students[i].passExam && students[i].passAssess) {
                System.out.println("\nYou failed Exam.");
            } else if (students[i].passExam && !students[i].passAssess) {
                System.out.println("\nYou failed Assessment.");
            }

        }
        
        scanner.close();
    }
}