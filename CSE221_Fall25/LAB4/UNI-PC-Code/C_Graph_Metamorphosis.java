/**
 *    author:  kabir_singh
 *    created: 2025.12.04 21:09:40
 **/
import java.io.*;
import java.util.*;

public class C_Graph_Metamorphosis{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] mat = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int v = Integer.parseInt(st.nextToken());
                mat[i][v] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j > 0) sb.append(' ');
                sb.append(mat[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}