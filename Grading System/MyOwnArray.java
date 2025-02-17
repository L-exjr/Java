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
                scanner.next();
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
        }

        /*while (true) {
            System.out.print("Have you paid your fees in full? (Yes/No): ");
            String input = scanner.next().trim().toLowerCase(); // Normalize input

            if (input.equals("yes") || input.equals("y")) {
                paidFees = true;
                break; // Exit the loop if input is valid
            } else if (input.equals("no") || input.equals("n")) {
                paidFees = false;
                break; // Exit the loop if input is valid
            } else {
                System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
            }
        }*/

        scanner.close();
    }
}