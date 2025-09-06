public class Task0a {
    public static void main(String[] args) {
        int n = 7;
        int[][] adjMatrix = new int[n][n];
        int[][] edges = {
                {0,1}, {0,2}, {0,3}, {0,4},
                {1,2}, {1,5}, {1,6}, {1,3},
                {2,3}, {2,4}, {2,5},
                {3,4}, {3,6},
                {4,5}, {4,6},
                {5,6}
        };
        for (int[] e : edges) {
            adjMatrix[e[0]][e[1]] = 1;
            adjMatrix[e[1]][e[0]] = 1;
        }
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(adjMatrix[i][j] + " ");
            System.out.println();
        }
    }
}
