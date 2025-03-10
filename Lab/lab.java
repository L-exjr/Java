public class lab {
    public static void main(String args[]) {
        //The Matrix with even numbers
        int[][] evenMatrix = new int[3][3];
        int evenNumber = 2;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                evenMatrix[i][j] = evenNumber;
                evenNumber += 2; 
            }
        }

        //The Matrix with odd numbers
        int[][] oddMatrix = new int[3][3];
        int oddNumber = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                oddMatrix[i][j] = oddNumber;
                oddNumber += 2;
            }
        }

        //Displaying the matrices
        /*System.out.println("Even Matrix:");
        for (int[] row : evenMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("\nOdd Matrix:");
        for (int[] row : oddMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }*/


        // Leading diagonal product for the even matrix
        int evenLeadingdiagonal = 1;
        for (int i = 0; i < 3; i++) {
            evenLeadingdiagonal *= evenMatrix[i][i];
        }
        System.out.println("Product of leading diagonal elements for the even matrix: " + evenLeadingdiagonal);

        //Leading diagonal product for the odd matrix
        int oddLeadingdiagonal =1 ;
        for (int i = 0; i < 3; i++){
            oddLeadingdiagonal *= oddMatrix[i][i];
        }

        System.out.println("Product of leading diagonal elements for the odd matrix: " + oddLeadingdiagonal);

        //Trailing diagonal product for the even matrix
        int evenTrailingdiagonal = 1;
        for (int i = 0; i < 3; i++) {
            evenTrailingdiagonal *= evenMatrix[i][2 - i];
        }
        System.out.println("\nProduct of trailing diagonal elements: " + evenTrailingdiagonal);

        //Trailing diagonal product for the odd matrix
        int oddTrailingdiagonal = 1;
        for (int i = 0; i < 3; i++) {
            oddTrailingdiagonal *= oddMatrix[i][2 - i];
        }
        System.out.println("Product of trailing diagonal elements: " + oddTrailingdiagonal);

        //Difference between the products of the trailing and leading diagonal elements for even Matrix
        int evenDifference = evenTrailingdiagonal - evenLeadingdiagonal;
        System.out.println("\nDifference between trailing and leading diagonal products (Even Matrix): " + evenDifference);

        //Difference between the products of the trailing and leading diagonal elements for odd Matrix
        int oddDifference = oddTrailingdiagonal - oddLeadingdiagonal;
        System.out.println("Difference between trailing and leading diagonal products (Odd Matrix): " + oddDifference);

        //Difference between the trailing diagonal products
        int trailingDifference = oddTrailingdiagonal - evenTrailingdiagonal;
        System.out.println("\nDifference between trailing diagonals (Odd and Even Matrix): " + trailingDifference);
    }
}