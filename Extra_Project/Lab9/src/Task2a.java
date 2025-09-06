public class Task2a {
    public static int vertexWithMaxSum(int[][] adjMatrix) {
        int maxSum = Integer.MIN_VALUE;
        int vertex = -1;

        for (int i = 0; i < adjMatrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < adjMatrix[i].length; j++) {
                sum += adjMatrix[i][j];
            }
            if (sum > maxSum) {
                maxSum = sum;
                vertex = i;
            }
        }

        return vertex;
    }

    public static void main(String[] args) {
        // Create an undirected, edge-weighted graph with 7 vertices (0-6)
        int[][] adjMatrix = new int[7][7];

        // Add edges with weights (ensuring the graph is undirected by making the matrix symmetric)
        // Edge between vertex 0 and 1
        adjMatrix[0][1] = 5;
        adjMatrix[1][0] = 5;

        // Edge between vertex 0 and 2
        adjMatrix[0][2] = 7;
        adjMatrix[2][0] = 7;

        // Edge between vertex 0 and 4
        adjMatrix[0][4] = 3;
        adjMatrix[4][0] = 3;

        // Edge between vertex 0 and 6
        adjMatrix[0][6] = 15;
        adjMatrix[6][0] = 15;

        // Edge between vertex 1 and 2
        adjMatrix[1][2] = 2;
        adjMatrix[2][1] = 2;

        // Edge between vertex 1 and 3
        adjMatrix[1][3] = 8;
        adjMatrix[3][1] = 8;

        // Edge between vertex 2 and 4
        adjMatrix[2][4] = 4;
        adjMatrix[4][2] = 4;

        // Edge between vertex 2 and 5
        adjMatrix[2][5] = 9;
        adjMatrix[5][2] = 9;

        // Edge between vertex 3 and 4
        adjMatrix[3][4] = 1;
        adjMatrix[4][3] = 1;

        // Edge between vertex 3 and 6
        adjMatrix[3][6] = 10;
        adjMatrix[6][3] = 10;

        // Edge between vertex 4 and 5
        adjMatrix[4][5] = 6;
        adjMatrix[5][4] = 6;

        // Edge between vertex 4 and 6
        adjMatrix[4][6] = 12;
        adjMatrix[6][4] = 12;

        // Edge between vertex 5 and 6
        adjMatrix[5][6] = 2;
        adjMatrix[6][5] = 2;

        // Print the adjacency matrix for verification
        System.out.println("Adjacency Matrix (Undirected, Edge-Weighted Graph):");
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Find vertex with maximum sum of edge weights
        int maxVertex = vertexWithMaxSum(adjMatrix);

        // Calculate and display the max weight sum
        int maxSum = 0;
        for (int j = 0; j < adjMatrix[maxVertex].length; j++) {
            maxSum += adjMatrix[maxVertex][j];
        }

        System.out.println("\nVertex with maximum sum of edge weights: " + maxVertex);
        System.out.println("Maximum sum of edge weights: " + maxSum);
    }
}
