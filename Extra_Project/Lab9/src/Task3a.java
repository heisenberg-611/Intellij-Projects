//public class Task3a {
//    // Task 1: Find vertex with maximum out-degree (count of outgoing edges)
//    public static int vertexMaxOutDegree(int[][] adjMatrix) {
//        int maxDegree = -1;
//        int vertex = -1;
//
//        for (int i = 0; i < adjMatrix.length; i++) {
//            int outDegree = 0;
//            for (int j = 0; j < adjMatrix[i].length; j++) {
//                if (adjMatrix[i][j] != 0) {
//                    outDegree++;
//                }
//            }
//            if (outDegree > maxDegree) {
//                maxDegree = outDegree;
//                vertex = i;
//            }
//        }
//        return vertex;
//    }
//
//    // Task 2: Find vertex with max sum of outgoing edge weights
//    public static int vertexMaxWeightSum(int[][] adjMatrix) {
//        int maxSum = Integer.MIN_VALUE;
//        int vertex = -1;
//
//        for (int i = 0; i < adjMatrix.length; i++) {
//            int sum = 0;
//            for (int j = 0; j < adjMatrix[i].length; j++) {
//                sum += adjMatrix[i][j]; // add weight (0 if no edge)
//            }
//            if (sum > maxSum) {
//                maxSum = sum;
//                vertex = i;
//            }
//        }
//        return vertex;
//    }
//
//    public static void main(String[] args) {
//        // Create a directed, edge-weighted graph with 7 vertices (0-6)
//        int[][] adjMatrix = new int[7][7];
//
//        // Add at least 16 edges with weights
//        // Edge from vertex 0
//        adjMatrix[0][1] = 5;
//        adjMatrix[0][2] = 7;
//        adjMatrix[0][4] = 3;
//
//        // Edge from vertex 1
//        adjMatrix[1][0] = 5;  // Corresponding edge (can be different weight in a directed graph)
//        adjMatrix[1][2] = 2;
//        adjMatrix[1][3] = 8;
//
//        // Edge from vertex 2
//        adjMatrix[2][0] = 7;
//        adjMatrix[2][4] = 4;
//        adjMatrix[2][5] = 9;
//
//        // Edge from vertex 3
//        adjMatrix[3][1] = 8;
//        adjMatrix[3][4] = 1;
//        adjMatrix[3][6] = 10;
//
//        // Edge from vertex 4
//        adjMatrix[4][5] = 6;
//        adjMatrix[4][6] = 12;
//
//        // Edge from vertex 5
//        adjMatrix[5][2] = 9;
//        adjMatrix[5][6] = 2;
//
//        // Edge from vertex 6
//        adjMatrix[6][0] = 15;
//        adjMatrix[6][3] = 10;
//
//        // Print the adjacency matrix for verification
//        System.out.println("Adjacency Matrix (Directed, Edge-Weighted Graph):");
//        for (int i = 0; i < adjMatrix.length; i++) {
//            for (int j = 0; j < adjMatrix[i].length; j++) {
//                System.out.print(adjMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        // Find vertex with maximum out-degree
//        int maxDegreeVertex = vertexMaxOutDegree(adjMatrix);
//
//        // Calculate and display the max degree
//        int maxDegree = 0;
//        for (int j = 0; j < adjMatrix[maxDegreeVertex].length; j++) {
//            if (adjMatrix[maxDegreeVertex][j] != 0) {
//                maxDegree++;
//            }
//        }
//
//        System.out.println("\nVertex with maximum out-degree: " + maxDegreeVertex);
//        System.out.println("Maximum out-degree: " + maxDegree);
//
//        // Find vertex with maximum sum of outgoing edge weights
//        int maxWeightVertex = vertexMaxWeightSum(adjMatrix);
//
//        // Calculate and display the max weight sum
//        int maxSum = 0;
//        for (int j = 0; j < adjMatrix[maxWeightVertex].length; j++) {
//            maxSum += adjMatrix[maxWeightVertex][j];
//        }
//
//        System.out.println("\nVertex with maximum sum of outgoing edge weights: " + maxWeightVertex);
//        System.out.println("Maximum sum of outgoing edge weights: " + maxSum);
//    }
//}
public class Task3a {
    /**
     * Finds all vertices that have the maximum out-degree in a directed graph
     * represented using an adjacency matrix.
     *
     * @param adjMatrix The adjacency matrix representation of the graph
     * @return An array of vertex indices that have the maximum out-degree
     */
    public static int[] vertexMaxOutDegree(int[][] adjMatrix) {
        // Find the maximum out-degree first
        int maxDegree = -1;
        int count = 0;  // Count of vertices with max degree

        // First pass: Find the maximum degree and count vertices with that degree
        for (int i = 0; i < adjMatrix.length; i++) {
            int outDegree = 0;
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != 0) {
                    outDegree++;
                }
            }

            if (outDegree > maxDegree) {
                maxDegree = outDegree;
                count = 1;
            } else if (outDegree == maxDegree) {
                count++;
            }
        }

        // Create an array of the correct size to hold all max degree vertices
        int[] maxVertices = new int[count];

        // Second pass: Fill the array with vertices that have the maximum degree
        int index = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            int outDegree = 0;
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != 0) {
                    outDegree++;
                }
            }

            if (outDegree == maxDegree) {
                maxVertices[index++] = i;
            }
        }

        return maxVertices;
    }

    /**
     * Finds the vertex with the maximum sum of outgoing edge weights in a directed graph
     * represented using an adjacency matrix.
     *
     * @param adjMatrix The adjacency matrix representation of the graph
     * @return The vertex index with the maximum sum of outgoing edge weights
     */
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

        // Find all vertices with maximum out-degree
        int[] maxDegreeVertices = vertexMaxOutDegree(adjMatrix);

        // Calculate and display the max degree
        int maxDegree = 0;
        if (maxDegreeVertices.length > 0) {
            int firstVertex = maxDegreeVertices[0];
            for (int j = 0; j < adjMatrix[firstVertex].length; j++) {
                if (adjMatrix[firstVertex][j] != 0) {
                    maxDegree++;
                }
            }
        }

        // Format the vertices array as a string
        StringBuilder verticesStr = new StringBuilder();
        for (int i = 0; i < maxDegreeVertices.length; i++) {
            verticesStr.append(maxDegreeVertices[i]);
            if (i < maxDegreeVertices.length - 1) {
                verticesStr.append(", ");
            }
        }

        System.out.println("\nVertices with maximum out-degree: " + verticesStr);
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