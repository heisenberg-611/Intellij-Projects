/**
 *    author:  kabir_singh
 *    created: 2025.12.04 21:56:28
 **/
import java.io.*;
import java.util.*;

public class G_The_Knights_of_Knigsberg {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] hasKnight = new boolean[N + 1][M + 1];
        int[] xs = new int[K]; 
        int[] ys = new int[K]; 
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xs[i] = x;
            ys[i] = y;
            hasKnight[x][y] = true;
        }
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int i = 0; i < K; i++) {
            int x = xs[i];
            int y = ys[i];
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (hasKnight[nx][ny]) {
                        pw.println("YES");
                        pw.flush();
                        br.close();
                        pw.close();
                        return;
                    }
                }
            }
        }
        pw.println("NO");
        pw.flush();
        br.close();
        pw.close();
    }
}