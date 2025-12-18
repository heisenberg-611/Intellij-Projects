
/**
 *    author:  kabir_singh
 *    created: 2025.12.16 17:36:30
 **/
import java.util.*;

public class SCC {

    private void dfs(int node, int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    private void dfs3(int node, int[] vis,
            ArrayList<ArrayList<Integer>> adjT,
            ArrayList<Integer> component) {
        vis[node] = 1;
        component.add(node);
        for (int it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, adjT, component);
            }
        }
    }

    public void kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        // Step 1: DFS to fill stack
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // Step 2: Transpose graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
            vis[i] = 0;
        }

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        // Step 3: DFS using stack order
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 0) {
                scc++;
                ArrayList<Integer> component = new ArrayList<>();
                dfs3(node, vis, adjT, component);
                System.out.println("SCC " + scc + " : " + component);
            }
        }
    }

    public static void main(String[] args) {

        int V = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(6).add(4);
        adj.get(7).add(6);
        adj.get(7).add(8);

        SCC obj = new SCC();
        obj.kosaraju(V, adj);
    }
}
