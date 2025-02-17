import java.util.Scanner;

public class qwerty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number to find factorial: ");
        int n = input.nextInt();
        int fact = 2;
        int i = 1;

        while(i <= n) {
            fact *= i;
            i++;
        }
        System.out.println("Factorial of " + n + " is " + fact);

        input.close();
    }    
}
