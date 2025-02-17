public class GaussianElimination {

    // Method to perform Gaussian Elimination
    public static double[] solve(double[][] matrix, double[] constants) {
        int n = constants.length;

        // Augment the matrix with the constants
        double[][] augmentedMatrix = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][n] = constants[i];
        }

        // Forward elimination to achieve row-echelon form
        for (int i = 0; i < n; i++) {
            // Make the diagonal element 1 by dividing the row
            double diagElement = augmentedMatrix[i][i];
            for (int j = 0; j <= n; j++) {
                augmentedMatrix[i][j] /= diagElement;
            }

            // Eliminate the current column in rows below
            for (int k = i + 1; k < n; k++) {
                double factor = augmentedMatrix[k][i];
                for (int j = 0; j <= n; j++) {
                    augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                }
            }
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

    public static void main(String[] args) {
        // Example system of equations:
        // 2x + y - z = 8
        // -3x - y + 2z = -11
        // -2x + y + 2z = -3
        double[][] matrix = {
            {1, 1, 1},
            {4, 3, -1},
            {3, 5, 3}
        };
        double[] constants = {1, 6, 4};

        // Solve the system
        double[] solution = solve(matrix, constants);

        // Print the solution
        System.out.println("Solution:");
        for (int i = 0; i < solution.length; i++) {
            System.out.printf("x%d = %.2f%n", i + 1, solution[i]);
        }
    }
}