/**
 *    author:  kabir_singh
 *    created: 2025.12.05 11:34:35
 **/
import java.io.*;
import java.util.*;

public class E_Easy_Tree_Queries{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Precompute subtree sizes using iterative DFS (stack)
        int[] subtreeSize = new int[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);

        // First DFS stack to get order (postorder-like processing)
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> postStack = new ArrayDeque<>();
        stack.push(R);
        parent[R] = 0; // mark root's parent as dummy 0 (unused)

        while (!stack.isEmpty()) {
            int u = stack.pop();
            postStack.push(u); // for processing children first
            for (int v : adj.get(u)) {
                if (v == parent[u]) continue;
                parent[v] = u;
                stack.push(v);
            }
        }

        // Process nodes in reverse DFS order (children before parent)
        while (!postStack.isEmpty()) {
            int u = postStack.pop();
            subtreeSize[u] = 1;
            for (int v : adj.get(u)) {
                if (v == parent[u]) continue;
                subtreeSize[u] += subtreeSize[v];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int X = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[X]).append('\n');
        }

        System.out.print(sb);
    }
}