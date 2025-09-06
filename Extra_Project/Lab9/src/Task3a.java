public class Task3a {
    // Task 1: Find vertex with maximum out-degree (count of outgoing edges)
    public static int vertexMaxOutDegree(int[][] adjMatrix) {
        int maxDegree = -1;
        int vertex = -1;

        for (int i = 0; i < adjMatrix.length; i++) {
            int outDegree = 0;
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != 0) {
                    outDegree++;
                }
            }
            if (outDegree > maxDegree) {
                maxDegree = outDegree;
                vertex = i;
            }
        }
        return vertex;
    }

    // Task 2: Find vertex with max sum of outgoing edge weights
    public static int vertexMaxWeightSum(int[][] adjMatrix) {
        int maxSum = Integer.MIN_VALUE;
        int vertex = -1;

        for (int i = 0; i < adjMatrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < adjMatrix[i].length; j++) {
                sum += adjMatrix[i][j]; // add weight (0 if no edge)
            }
            if (sum > maxSum) {
                maxSum = sum;
                vertex = i;
            }
        }
        return vertex;
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
        adjMatrix[1][0] = 5;  // Corresponding edge (can be different weight in a directed graph)
        adjMatrix[1][2] = 2;
        adjMatrix[1][3] = 8;

        // Edge from vertex 2
        adjMatrix[2][0] = 7;
        adjMatrix[2][4] = 4;
        adjMatrix[2][5] = 9;

        // Edge from vertex 3
        adjMatrix[3][1] = 8;
        adjMatrix[3][4] = 1;
        adjMatrix[3][6] = 10;

        // Edge from vertex 4
        adjMatrix[4][5] = 6;
        adjMatrix[4][6] = 12;

        // Edge from vertex 5
        adjMatrix[5][2] = 9;
        adjMatrix[5][6] = 2;

        // Edge from vertex 6
        adjMatrix[6][0] = 15;
        adjMatrix[6][3] = 10;

        // Print the adjacency matrix for verification
        System.out.println("Adjacency Matrix (Directed, Edge-Weighted Graph):");
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Find vertex with maximum out-degree
        int maxDegreeVertex = vertexMaxOutDegree(adjMatrix);

        // Calculate and display the max degree
        int maxDegree = 0;
        for (int j = 0; j < adjMatrix[maxDegreeVertex].length; j++) {
            if (adjMatrix[maxDegreeVertex][j] != 0) {
                maxDegree++;
            }
        }

        System.out.println("\nVertex with maximum out-degree: " + maxDegreeVertex);
        System.out.println("Maximum out-degree: " + maxDegree);

        // Find vertex with maximum sum of outgoing edge weights
        int maxWeightVertex = vertexMaxWeightSum(adjMatrix);

        // Calculate and display the max weight sum
        int maxSum = 0;
        for (int j = 0; j < adjMatrix[maxWeightVertex].length; j++) {
            maxSum += adjMatrix[maxWeightVertex][j];
        }

        System.out.println("\nVertex with maximum sum of outgoing edge weights: " + maxWeightVertex);
        System.out.println("Maximum sum of outgoing edge weights: " + maxSum);
    }
}
