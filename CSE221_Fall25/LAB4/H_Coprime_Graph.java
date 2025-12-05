/**
 *    author:  kabir_singh
 *    created: 2025.12.04 22:56:58
 **/
import java.io.*;
import java.util.*;

public class H_Coprime_Graph{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[][] neighbors = new int[N + 1][];
        int[] count = new int[N + 1];
        for (int x = 1; x <= N; x++) {
            int[] buf = new int[N];
            int len = 0;
            for (int j = 1; j <= N; j++) {
                if (j == x) continue;
                int a = x, b = j;
                while (b != 0) {
                    int t = b;
                    b = a % b;
                    a = t;
                }
                int g = a;
                if (g == 1) {
                    buf[len++] = j;
                }
            }
            neighbors[x] = Arrays.copyOf(buf, len);
            Arrays.sort(neighbors[x]);
            count[x] = len;
        }
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if (K <= count[X]) {
                pw.println(neighbors[X][K - 1]);
            } else {
                pw.println(-1);
            }
        }
        pw.flush();
        br.close();
        pw.close();
    }
}