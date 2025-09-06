public class Task3b {
    // Task 1: max out-degree (count of edges in adjacency list)
    public static int vertexMaxOutDegree(EdgeNode[] adjList) {
        int maxDegree = -1;
        int vertex = -1;

        for (int i = 0; i < adjList.length; i++) {
            int degree = 0;
            EdgeNode current = adjList[i];
            while (current != null) {
                degree++;
                current = current.next;
            }
            if (degree > maxDegree) {
                maxDegree = degree;
                vertex = i;
            }
        }
        return vertex;
    }

    // Task 2: max sum of outgoing edge weights
    public static int vertexMaxWeightSum(EdgeNode[] adjList) {
        int maxSum = Integer.MIN_VALUE;
        int vertex = -1;

        for (int i = 0; i < adjList.length; i++) {
            int sum = 0;
            EdgeNode curr = adjList[i];
            while (curr != null) {
                sum += curr.weight;
                curr = curr.next;
            }
            if (sum > maxSum) {
                maxSum = sum;
                vertex = i;
            }
        }
        return vertex;
    }

    public static void addEdge(EdgeNode[] adjList, int from, int toV, int weight) {
        EdgeNode newNode = new EdgeNode(toV, weight, null);

        if (adjList[from] == null) {
            adjList[from] = newNode;
        } else {
            EdgeNode curr = adjList[from];
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public static void main(String[] args) {
        // Create a directed, edge-weighted graph with 7 vertices (0-6)
        EdgeNode[] adjList = new EdgeNode[7];

        // Add at least 16 edges with weights
        // Edges from vertex 0
        addEdge(adjList, 0, 1, 5);
        addEdge(adjList, 0, 2, 7);
        addEdge(adjList, 0, 4, 3);

        // Edges from vertex 1
        addEdge(adjList, 1, 0, 5);  // Corresponding edge (can be different weight in a directed graph)
        addEdge(adjList, 1, 2, 2);
        addEdge(adjList, 1, 3, 8);

        // Edges from vertex 2
        addEdge(adjList, 2, 0, 7);
        addEdge(adjList, 2, 4, 4);
        addEdge(adjList, 2, 5, 9);

        // Edges from vertex 3
        addEdge(adjList, 3, 1, 8);
        addEdge(adjList, 3, 4, 1);
        addEdge(adjList, 3, 6, 10);

        // Edges from vertex 4
        addEdge(adjList, 4, 5, 6);
        addEdge(adjList, 4, 6, 12);

        // Edges from vertex 5
        addEdge(adjList, 5, 2, 9);
        addEdge(adjList, 5, 6, 2);

        // Edges from vertex 6
        addEdge(adjList, 6, 0, 15);
        addEdge(adjList, 6, 3, 10);

        // Print the adjacency list for verification
        System.out.println("Adjacency List (Directed, Edge-Weighted Graph):");
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + " -> ");
            EdgeNode current = adjList[i];
            while (current != null) {
                System.out.print("(" + current.toV + ", " + current.weight + ") ");
                current = current.next;
            }
            System.out.println();
        }

        // Find vertex with maximum out-degree
        int maxDegreeVertex = vertexMaxOutDegree(adjList);

        // Calculate and display the max degree
        int maxDegree = 0;
        EdgeNode current = adjList[maxDegreeVertex];
        while (current != null) {
            maxDegree++;
            current = current.next;
        }

        System.out.println("\nVertex with maximum out-degree: " + maxDegreeVertex);
        System.out.println("Maximum out-degree: " + maxDegree);

        // Find vertex with maximum sum of outgoing edge weights
        int maxWeightVertex = vertexMaxWeightSum(adjList);

        // Calculate and display the max weight sum
        int maxSum = 0;
        current = adjList[maxWeightVertex];
        while (current != null) {
            maxSum += current.weight;
            current = current.next;
        }

        System.out.println("\nVertex with maximum sum of outgoing edge weights: " + maxWeightVertex);
        System.out.println("Maximum sum of outgoing edge weights: " + maxSum);
    }
}
