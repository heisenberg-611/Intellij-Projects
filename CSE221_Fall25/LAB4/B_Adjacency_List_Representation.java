/**
 *    author:  kabir_singh
 *    created: 2025.11.08 13:28:21
 **/
import java.io.*;
import java.util.*;

public class B_Adjacency_List_Representation{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) u[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) v[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) w[i] = Integer.parseInt(st.nextToken());


        int[][][] edges = new int[N + 1][N][2];
        int[] count = new int[N + 1]; 


        for (int i = 0; i < M; i++) {
            int from = u[i];
            int to = v[i];
            int weight = w[i];
            int idx = count[from];
            edges[from][idx][0] = to;
            edges[from][idx][1] = weight;
            count[from]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(':');
            for (int j = 0; j < count[i]; j++) {
                sb.append(" (")
                  .append(edges[i][j][0])
                  .append(',')
                  .append(edges[i][j][1])
                  .append(')');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}