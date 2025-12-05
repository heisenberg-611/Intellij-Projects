/**
 *    author:  kabir_singh
 *    created: 2025.12.05 12:52:27
 **/
import java.io.*;
import java.util.*;

public class F_Cycle_Detection {
    static ArrayList<Integer>[] adj;
    static int[] state;
    static boolean hasCycle;

    public static boolean dfs(int u) {
        state[u] = 1;
        for (int v : adj[u]) {
            if (state[v] == 0) {
                if (dfs(v)) return true;
            } else if (state[v] == 1) {
                return true;
            }
        }
        state[u] = 2;
        return false;
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
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        state = new int[N + 1];
        hasCycle = false;
        for (int i = 1; i <= N; i++) {
            if (state[i] == 0) {
                if (dfs(i)) {
                    hasCycle = true;
                    break;
                }
            }
        }
        pw.println(hasCycle ? "YES" : "NO");
        pw.flush();
        pw.close();
        br.close();
    }
}