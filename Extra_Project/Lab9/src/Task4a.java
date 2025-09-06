public class Task4a {
    // Converts the directed graph adjacency matrix to undirected by symmetrizing weights
    public static void convertToUndirected(int[][] adjMatrix) {
        int n = adjMatrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] != 0) {
                    // If there's a directed edge i -> j, set the weight from j -> i to the same value
                    adjMatrix[j][i] = adjMatrix[i][j];
                }
            }
        }
    }

    public static void printMatrix(int[][] adjMatrix) {
        for (int[] row : adjMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a directed, edge-weighted graph with 7 vertices (0-6)
        int[][] adjMatrix = new int[7][7];

        // Add at least 16 edges with weights
        // Edge from vertex 0
        adjMatrix[0][1] = 5;
        adjMatrix[0][2] = 7;
        adjMatrix[0][4] = 3;

        // Edge from vertex 1
        adjMatrix[1][0] = 5;  // Already bidirectional with vertex 0
        adjMatrix[1][2] = 2;
        adjMatrix[1][3] = 8;

        // Edge from vertex 2
        adjMatrix[2][0] = 7;  // Already bidirectional with vertex 0
        adjMatrix[2][4] = 4;
        adjMatrix[2][5] = 9;

        // Edge from vertex 3
        adjMatrix[3][1] = 8;  // Already bidirectional with vertex 1
        adjMatrix[3][4] = 1;
        adjMatrix[3][6] = 10;

        // Edge from vertex 4
        adjMatrix[4][5] = 6;
        adjMatrix[4][6] = 12;

        // Edge from vertex 5
        adjMatrix[5][2] = 9;  // Already bidirectional with vertex 2
        adjMatrix[5][6] = 2;

        // Edge from vertex 6
        adjMatrix[6][0] = 15;
        adjMatrix[6][3] = 10; // Already bidirectional with vertex 3

        System.out.println("Before conversion (Directed):");
        printMatrix(adjMatrix);

        convertToUndirected(adjMatrix);

        System.out.println("\nAfter conversion (Undirected):");
        printMatrix(adjMatrix);
    }
}