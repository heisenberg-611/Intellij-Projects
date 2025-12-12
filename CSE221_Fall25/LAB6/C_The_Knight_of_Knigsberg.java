/**
 *    author:  kabir_singh
 *    created: 2025.12.09 22:41:59
 **/
import java.io.*;
import java.util.*;
public class C_The_Knight_of_Knigsberg{
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    static int[] dx = {2,2,-2,-2,1,1,-1,-1};
    static int[] dy = {1,-1,1,-1,2,-2,2,-2};
    public static void main(String[] args) throws IOException{
        FastScanner fs = new FastScanner(System.in);
        int N = fs.nextInt();
        int xi1 = fs.nextInt(),yi1 = fs.nextInt();
        int xi2 = fs.nextInt(),yi2 = fs.nextInt();
        if(xi1 == xi2 && yi1 == yi2){
            System.out.println(0);
            return;
        }
        boolean [][] visited = new boolean[N+1][N+1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{xi1, yi1, 0});
        visited[xi1][yi1] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dis=cur[2];

            for(int j = 0; j < 8; j++){
                int nx  = x +dx[j];
                int ny = y + dy[j];

                if(nx >= 1 && nx<=N && ny >=1 && ny <=N && !visited[nx][ny]){
                    if(nx == xi2 && ny == yi2){
                        System.out.println(dis +1);
                        return;
                    }
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dis + 1});
                }
            }
        }
        System.out.println(-1);
    }
}