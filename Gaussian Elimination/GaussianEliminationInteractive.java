import java.util.Scanner;

public class GaussianEliminationInteractive {

    // Method to perform Gaussian Elimination
    public static double[] solve(double[][] matrix, double[] constants) {
        int n = constants.length;

        // Augment the matrix with the constants
        double[][] augmentedMatrix = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][n] = constants[i];
        }

        System.out.println("\nInitial Augmented Matrix:");
        printMatrix(augmentedMatrix);

        // Forward elimination to achieve row-echelon form
        for (int i = 0; i < n; i++) {
            // Make the diagonal element 1 by dividing the row
            double diagElement = augmentedMatrix[i][i];
            for (int j = 0; j <= n; j++) {
                augmentedMatrix[i][j] /= diagElement;
            }
            System.out.println("\nStep " + (i + 1) + ": Make pivot element 1 (Row " + (i + 1) + "):");
            printMatrix(augmentedMatrix);

            // Eliminate the current column in rows below
            for (int k = i + 1; k < n; k++) {
                double factor = augmentedMatrix[k][i];
                for (int j = 0; j <= n; j++) {
                    augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                }
            }
            System.out.println("\nStep " + (i + 1) + ": Eliminate column " + (i + 1) + " below pivot:");
            printMatrix(augmentedMatrix);
        }

        // Back-substitution to find the solution
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = augmentedMatrix[i][n];
            for (int j = i + 1; j < n; j++) {
                solution[i] -= augmentedMatrix[i][j] * solution[j];
            }
        }

        return solution;
    }

    // Method to print the matrix
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%10.2f", value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of equations
        System.out.print("Enter the number of equations: ");
        int n = scanner.nextInt();

        // Input the coefficients matrix
        double[][] matrix = new double[n][n];
        System.out.println("Enter the coefficients of the equations:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Coefficient of x" + (j + 1) + " in equation " + (i + 1) + ": ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Input the constants
        double[] constants = new double[n];
        System.out.println("Enter the constants:");
        for (int i = 0; i < n; i++) {
            System.out.print("Constant for equation " + (i + 1) + ": ");
            constants[i] = scanner.nextDouble();
        }

        // Solve the system
        double[] solution = solve(matrix, constants);

        // Display the solution
        System.out.println("\nFinal Solution:");
        for (int i = 0; i < solution.length; i++) {
            System.out.printf("x%d = %.2f%n", i + 1, solution[i]);
        }

        scanner.close();
    }
}