public class Task2b {

    public static int vertexWithMaxSum(EdgeNode[] adjList) {
        int maxSum = Integer.MIN_VALUE;
        int vertex = -1;

        for (int i = 0; i < adjList.length; i++) {
            int sum = 0;
            EdgeNode current = adjList[i];
            while (current != null) {
                sum += current.weight;
                current = current.next;
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
            appendLL(adjList[from], newNode);
        }
    }

    public static void appendLL(EdgeNode head, EdgeNode eNode) {
        EdgeNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = eNode;
    }

    public static void main(String[] args) {
        // Create an undirected, edge-weighted graph with 7 vertices (0-6)
        EdgeNode[] adjList = new EdgeNode[7];

        // Add edges with weights (ensuring the graph is undirected by adding edges in both directions)
        // Edges between vertex 0 and others
        addEdge(adjList, 0, 1, 5);
        addEdge(adjList, 1, 0, 5);

        addEdge(adjList, 0, 2, 7);
        addEdge(adjList, 2, 0, 7);

        addEdge(adjList, 0, 4, 3);
        addEdge(adjList, 4, 0, 3);

        addEdge(adjList, 0, 6, 15);
        addEdge(adjList, 6, 0, 15);

        // Edges between vertex 1 and others
        addEdge(adjList, 1, 2, 2);
        addEdge(adjList, 2, 1, 2);

        addEdge(adjList, 1, 3, 8);
        addEdge(adjList, 3, 1, 8);

        // Edges between vertex 2 and others
        addEdge(adjList, 2, 4, 4);
        addEdge(adjList, 4, 2, 4);

        addEdge(adjList, 2, 5, 9);
        addEdge(adjList, 5, 2, 9);

        // Edges between vertex 3 and others
        addEdge(adjList, 3, 4, 1);
        addEdge(adjList, 4, 3, 1);

        addEdge(adjList, 3, 6, 10);
        addEdge(adjList, 6, 3, 10);

        // Edges between vertex 4 and others
        addEdge(adjList, 4, 5, 6);
        addEdge(adjList, 5, 4, 6);

        addEdge(adjList, 4, 6, 12);
        addEdge(adjList, 6, 4, 12);

        // Edges between vertex 5 and 6
        addEdge(adjList, 5, 6, 2);
        addEdge(adjList, 6, 5, 2);

        // Print the adjacency list for verification
        System.out.println("Adjacency List (Undirected, Edge-Weighted Graph):");
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + " -> ");
            EdgeNode current = adjList[i];
            while (current != null) {
                System.out.print("(" + current.toV + ", " + current.weight + ") ");
                current = current.next;
            }
            System.out.println();
        }

        // Find vertex with maximum sum of edge weights
        int maxVertex = vertexWithMaxSum(adjList);

        // Calculate and display the max weight sum
        int maxSum = 0;
        EdgeNode current = adjList[maxVertex];
        while (current != null) {
            maxSum += current.weight;
            current = current.next;
        }

        System.out.println("\nVertex with maximum sum of edge weights: " + maxVertex);
        System.out.println("Maximum sum of edge weights: " + maxSum);
    }
}
