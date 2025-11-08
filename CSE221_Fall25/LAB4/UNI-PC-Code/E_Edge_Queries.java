import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E_Edge_Queries{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] diff = new int[N + 1]; // 1-indexed; diff[i] = indegree[i] - outdegree[i]

        // Read u array
        st = new StringTokenizer(br.readLine());
        int[] u = new int[M];
        for (int i = 0; i < M; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }

        // Read v array and update diff on the fly (save memory if desired)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());
            diff[u[i]]--; // outgoing from u[i]
            diff[v]++;    // incoming to v
        }

        // Output: diff[1] to diff[N]
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (i > 1) sb.append(' ');
            sb.append(diff[i]);
        }
        System.out.println(sb);
    }
}