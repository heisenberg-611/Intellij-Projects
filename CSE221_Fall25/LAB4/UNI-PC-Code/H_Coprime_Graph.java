import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_Coprime_Graph{
    // Fast gcd (Euclidean)
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // Pre-allocate: max possible neighbors per node = N-1
        int[][] adj = new int[N + 1][N]; // adj[i] holds neighbors of i (0-indexed within row)
        int[] deg = new int[N + 1];      // deg[i] = actual count

        // Precompute neighbors
        for (int i = 1; i <= N; i++) {
            int idx = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (gcd(i, j) == 1) {
                    adj[i][idx++] = j;
                }
            }
            deg[i] = idx;
            // Sort only the first 'deg[i]' elements
            Arrays.sort(adj[i], 0, deg[i]);
        }

        // Process queries
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (K > deg[X]) {
                sb.append("-1\n");
            } else {
                sb.append(adj[X][K - 1]).append('\n');
            }
        }

        System.out.print(sb);
    }
}