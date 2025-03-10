import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double[] scores;
    double total, average;
    char grade;

    public Student(String name, double[] scores) {
        this.name = name;
        this.scores = scores;
        calculateResults();
    }

    private void calculateResults() {
        total = 0;
        for (double score : scores) {
            total += score;
        }

        average = total/scores.length;

        if (average >= 70) {
            grade = 'A';
        } else if (average >= 60) {
            grade = 'B';
        } else if (average >= 50) {
            grade = 'C';
        } else if (average >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Total Score: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("");
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Student Grade Calculator");
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();

        for (int i = 0; i < numStudents; i++) {
            input.nextLine();
            System.out.print("\nEnter student name: ");
            String name = input.nextLine();

            System.out.print("Enter number of subjects: ");
            int numSubjects = input.nextInt();
            double[] scores = new double[numSubjects];

            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter score for subject " + (j + 1) + ": ");
                scores[j] = input.nextInt();

                while (scores[j] < 0 || scores[j] > 100) {
                    System.out.println("Invalid score. Enter a value between 0 and 100.");
                    System.out.print("Enter score for subject " + (j + 1) + ": ");
                    scores[j] = input.nextInt();
                }
            }

            students.add(new Student(name, scores));
        }

        System.out.println("\nGrade Report:");
        for (Student student : students) {
            student.displayStudent();
        }

        input.close();
    }
}