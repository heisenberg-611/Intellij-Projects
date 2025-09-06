public class Task1 {

    public static class EdgeNode {
        int toV;
        int weight;
        EdgeNode next;

        public EdgeNode(int toV, int weight, EdgeNode next) {
            this.toV = toV;
            this.weight = weight;
            this.next = next;
        }
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

    public static int maxDegree(EdgeNode[] adjList) {
        int maxDeg = 0;
        for (EdgeNode head : adjList) {
            int degree = 0;
            EdgeNode current = head;
            while (current != null) {
                degree++;
                current = current.next;
            }
            if (degree > maxDeg) {
                maxDeg = degree;
            }
        }
        return maxDeg;
    }
    public static void main(String[] args) {
        // Example: Adjacency list for a graph with 5 vertices
        EdgeNode[] adjList = new EdgeNode[5];

        // Add some edges
        addEdge(adjList, 0, 1, 10); // Edge from 0 to 1 with weight 10
        addEdge(adjList, 0, 2, 15); // Edge from 0 to 2 with weight 15
        addEdge(adjList, 1, 3, 12); // Edge from 1 to 3 with weight 12
        addEdge(adjList, 1, 4, 7);  // Edge from 1 to 4 with weight 7
        addEdge(adjList, 2, 3, 5);  // Edge from 2 to 3 with weight 5

        // Print adjacency list
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + ": ");
            EdgeNode current = adjList[i];
            while (current != null) {
                System.out.print("-> (" + current.toV + ", " + current.weight + ") ");
                current = current.next;
            }
            System.out.println();
        }

        // Print maximum degree
        int maxDeg = maxDegree(adjList);
        System.out.println("Maximum degree of the graph: " + maxDeg);
    }

}