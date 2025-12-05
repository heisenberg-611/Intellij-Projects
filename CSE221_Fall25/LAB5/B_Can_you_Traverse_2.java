/**
 *    author:  kabir_singh
 *    created: 2025.12.05 00:23:19
 **/
import java.io.*;
import java.util.*;

public class B_Can_you_Traverse_2 {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;

    public static void dfs(int u) {
        visited[u] = true;
        sb.append(u).append(' ');
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int[] u = new int[M];
        for (int i = 0; i < M; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());
            adj[u[i]].add(v);
            adj[v].add(u[i]);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(1);
        pw.println(sb.toString().trim());
        pw.flush();
        pw.close();
        br.close();
    }
}