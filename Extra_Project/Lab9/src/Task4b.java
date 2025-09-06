public class Task4b {
    // Adds an edge to adjacency list
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

    // Converts directed graph adjacency list to undirected by adding reverse edges
    public static void convertToUndirected(EdgeNode[] adjList) {
        int n = adjList.length;

        for (int i = 0; i < n; i++) {
            EdgeNode curr = adjList[i];
            while (curr != null) {
                int from = i;
                int to = curr.toV;
                int weight = curr.weight;

                // Check if reverse edge (to -> from) exists. If not, add it.
                if (!hasEdge(adjList, to, from)) {
                    addEdge(adjList, to, from, weight);
                }

                curr = curr.next;
            }
        }
    }

    // Check if edge from 'from' to 'to' exists in adjacency list
    public static boolean hasEdge(EdgeNode[] adjList, int from, int toV) {
        EdgeNode curr = adjList[from];
        while (curr != null) {
            if (curr.toV == toV) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static void printAdjList(EdgeNode[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + ": ");
            EdgeNode curr = adjList[i];
            while (curr != null) {
                System.out.print("-> (" + curr.toV + ", " + curr.weight + ") ");
                curr = curr.next;
            }
            System.out.println();
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
        addEdge(adjList, 1, 0, 5);  // Already bidirectional with vertex 0
        addEdge(adjList, 1, 2, 2);
        addEdge(adjList, 1, 3, 8);

        // Edges from vertex 2
        addEdge(adjList, 2, 0, 7);  // Already bidirectional with vertex 0
        addEdge(adjList, 2, 4, 4);
        addEdge(adjList, 2, 5, 9);

        // Edges from vertex 3
        addEdge(adjList, 3, 1, 8);  // Already bidirectional with vertex 1
        addEdge(adjList, 3, 4, 1);
        addEdge(adjList, 3, 6, 10);

        // Edges from vertex 4
        addEdge(adjList, 4, 5, 6);
        addEdge(adjList, 4, 6, 12);

        // Edges from vertex 5
        addEdge(adjList, 5, 2, 9);  // Already bidirectional with vertex 2
        addEdge(adjList, 5, 6, 2);

        // Edges from vertex 6
        addEdge(adjList, 6, 0, 15);
        addEdge(adjList, 6, 3, 10); // Already bidirectional with vertex 3

        System.out.println("Before conversion (Directed):");
        printAdjList(adjList);

        convertToUndirected(adjList);

        System.out.println("\nAfter conversion (Undirected):");
        printAdjList(adjList);
    }
}