/**
 *    author:  kabir_singh
 *    created: 2025.12.05 11:06:09
 **/
import java.io.*;
import java.util.*;

public class D_Through_the_Jungle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }
        int[] dist1 = new int[N + 1];
        int[] parent1 = new int[N + 1];
        Arrays.fill(dist1, -1);
        Queue<Integer> q = new ArrayDeque<>();
        dist1[S] = 0;
        parent1[S] = -1;
        q.offer(S);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (dist1[v] == -1) {
                    dist1[v] = dist1[u] + 1;
                    parent1[v] = u;
                    q.offer(v);
                }
            }
        }
        int[] dist2 = new int[N + 1];
        int[] parent2 = new int[N + 1];
        Arrays.fill(dist2, -1);
        dist2[K] = 0;
        parent2[K] = -1;
        q.offer(K);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (dist2[v] == -1) {
                    dist2[v] = dist2[u] + 1;
                    parent2[v] = u;
                    q.offer(v);
                }
            }
        }
        if (dist1[K] == -1 || dist2[D] == -1) {
            pw.println(-1);
        } else {
            List<Integer> path = new ArrayList<>();
            int cur = K;
            while (cur != -1) {
                path.add(cur);
                cur = parent1[cur];
            }
            Collections.reverse(path);
            cur = D;
            Stack<Integer> stack = new Stack<>();
            while (cur != K) {
                stack.push(cur);
                cur = parent2[cur];
            }
            while (!stack.isEmpty()) {
                path.add(stack.pop());
            }
            pw.println(path.size() - 1);
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) pw.print(" ");
                pw.print(path.get(i));
            }
            pw.println();
        }
        pw.flush();
        br.close();
        pw.close();
    }
}