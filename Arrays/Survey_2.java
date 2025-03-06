import java.util.Scanner;

public class Survey_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] ratings = new int[20];

        System.out.println("On a scale of 1 to 5, rate the quality of teaching of Java");

        for (int i=0; i < ratings.length; i++){
            while(true){
                System.out.print("Student " + (i + 1) + ": ");
                int rating = input.nextInt();

                if (rating >= 1 && rating <= 5) {
                    ratings[i] = rating;
                    break;
                } else {
                    System.out.println("Invalid rating. Please enter a number between 1 and 5");
                }
            }
        }

        int[] frequency = new int[6];

        for (int rating:ratings){
            frequency[rating]++;
        }

        System.out.println("");

        for (int i=1; i < frequency.length; i++){
            System.out.println("Rating " + i + ": " + frequency[i] + " student(s)");
        }
        input.close();
    }
}