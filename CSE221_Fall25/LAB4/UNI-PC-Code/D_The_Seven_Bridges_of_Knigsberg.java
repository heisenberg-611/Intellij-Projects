import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_The_Seven_Bridges_of_Knigsberg{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] deg = new int[N + 1];
        int[] parent = new int[N + 1];
        int[] rank = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        int[] u = new int[M];
        int[] v = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) u[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) v[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int a = u[i], b = v[i];
            if (a == b) {
                deg[a] += 2;
            } else {
                deg[a]++;
                deg[b]++;
            }

            // Find root of a
            int ra = a;
            while (parent[ra] != ra) ra = parent[ra];
            // Find root of b
            int rb = b;
            while (parent[rb] != rb) rb = parent[rb];

            if (ra != rb) {
                if (rank[ra] < rank[rb]) {
                    parent[ra] = rb;
                } else if (rank[ra] > rank[rb]) {
                    parent[rb] = ra;
                } else {
                    parent[rb] = ra;
                    rank[ra]++;
                }
            }
        }

        // Find representative component for non-isolated nodes
        int comp = -1;
        for (int i = 1; i <= N; i++) {
            if (deg[i] == 0) continue;
            int r = i;
            while (parent[r] != r) r = parent[r];
            if (comp == -1) comp = r;
            else if (comp != r) {
                System.out.println("NO");
                return;
            }
        }

        int odd = 0;
        for (int i = 1; i <= N; i++) {
            if ((deg[i] & 1) == 1) odd++;
        }

        System.out.println(odd == 0 || odd == 2 ? "YES" : "NO");
    }
}