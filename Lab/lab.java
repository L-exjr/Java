import java.util.Scanner;

public class lab {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[20];
        int count = 0;

        System.out.println("Enter numbers between 1 and 20 (No Duplicates)");
        
        while (count < 20) {
            System.out.print("Enter number " + (count + 1) + ": ");
            int num = input.nextInt();

            if (num < 1 || num > 20) {
                System.out.println("Number must be between 1 and 20. Try again.");
                continue;
            }

            boolean isDuplicate = false;

            for (int i=0; i < count; i++) {
                if (numbers[i] == num) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("Number already entered. Try again");
            } else {
                numbers[count] = num;
                count++;
            }
        }

        int[] oddNumbers = new int[9];
        int[] evenNumbers = new int[9];
        int oddCount = 0, evenCount = 0;

        for (int num : numbers) {
            if (num % 2 != 0 && oddCount < 9) {
                oddNumbers[oddCount++] = num;
            } else if (num % 2 == 0 && evenCount < 9) {
                evenNumbers[evenCount++] = num;
            }

            if (oddCount == 9 && evenCount == 9) {
                break;
            }
        }

        int[][] oddArray = new int[3][3];
        int[][] evenArray = new int[3][3];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                oddArray[i][j] = oddNumbers[index];
                evenArray[i][j] = evenNumbers[index];

                index++;
            }
        }

        System.out.println("\nFirst 9 odd Numbers in a 3*3 array: " );
        printArray(oddArray);

        System.out.println("\nmFirst 9 even Numbers in a 3*3 array: " );
        printArray(evenArray);

        input.close();
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}