public class MatrixOperations {

    public static void main(String[] args) {
        // Step 1: Create a 3x3 matrix and fill it with the first 9 even numbers
        int[][] matrix = new int[3][3];
        int evenNumber = 2; // Starting from the first even number
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = evenNumber;
                evenNumber += 2; // Increment to the next even number
            }
        }

        // Display the matrix
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Step 2: Calculate the product of the leading diagonal elements
        int leadingDiagonalProduct = 1;
        for (int i = 0; i < 3; i++) {
            leadingDiagonalProduct *= matrix[i][i];
        }
        System.out.println("Product of leading diagonal elements: " + leadingDiagonalProduct);

        // Step 3: Calculate the product of the trailing diagonal elements
        int trailingDiagonalProduct = 1;
        for (int i = 0; i < 3; i++) {
            trailingDiagonalProduct *= matrix[i][2 - i];
        }
        System.out.println("Product of trailing diagonal elements: " + trailingDiagonalProduct);

        // Step 4: Calculate the difference between the products of the trailing and leading diagonal elements
        int differenceDiagonalProducts = trailingDiagonalProduct - leadingDiagonalProduct;
        System.out.println("Difference between trailing and leading diagonal products: " + differenceDiagonalProducts);

        // Step 5: Calculate the difference between the products of trailing diagonal odd and even numbers
        int trailingDiagonalOddProduct = 1;
        int trailingDiagonalEvenProduct = 1;
        boolean hasOdd = false;
        boolean hasEven = false;

        for (int i = 0; i < 3; i++) {
            int value = matrix[i][2 - i];
            if (value % 2 == 0) {
                trailingDiagonalEvenProduct *= value;
                hasEven = true;
            } else {
                trailingDiagonalOddProduct *= value;
                hasOdd = true;
            }
        }

        // If there are no odd or even numbers, set their product to 0
        if (!hasOdd) trailingDiagonalOddProduct = 0;
        if (!hasEven) trailingDiagonalEvenProduct = 0;

        int differenceTrailingProducts = trailingDiagonalOddProduct - trailingDiagonalEvenProduct;
        System.out.println("Difference between trailing diagonal odd and even products: " + differenceTrailingProducts);
    }
}