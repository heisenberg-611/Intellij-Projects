/**
 *    author:  kabir_singh
 *    created: 2025.12.05 00:23:25
 **/
import java.io.*;
import java.util.*;

public class A_Can_you_Traverse_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] head = new int[n + 1];
        int[] to = new int[2 * m + 2];
        int[] nxt = new int[2 * m + 2];
        int eid = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            to[eid] = v;
            nxt[eid] = head[u];
            head[u] = eid++;
            to[eid] = u;
            nxt[eid] = head[v];
            head[v] = eid++;
        }

        boolean[] vis = new boolean[n + 1];
        int[] q = new int[n + 1];
        int[] res = new int[n];
        int front = 0, rear = 0, idx = 0;

        vis[1] = true;
        q[rear++] = 1;

        while (front < rear) {
            int u = q[front++];
            res[idx++] = u;
            for (int e = head[u]; e != 0; e = nxt[e]) {
                int v = to[e];
                if (!vis[v]) {
                    vis[v] = true;
                    q[rear++] = v;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            if (i > 0)
                sb.append(' ');
            sb.append(res[i]);
        }
        System.out.print(sb);
    }
}