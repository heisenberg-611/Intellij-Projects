/**
 *    author:  kabir_singh
 *    created: 2025.12.04 21:09:18
 **/
import java.io.*;

public class E_Edge_Queries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[] differ = new int[N + 1];
        String[] uLine = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int u = Integer.parseInt(uLine[i]);
            differ[u]--;
        }
        String[] vLine = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(vLine[i]);
            differ[v]++;
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(differ[i]);
            if (i < N)
                System.out.print(" ");
        }
        System.out.println();
    }
}