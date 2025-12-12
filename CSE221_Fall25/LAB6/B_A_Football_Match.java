/**
 *    author:  kabir_singh
 *    created: 2025.12.09 21:56:15
 **/
import java.io.*;
import java.util.*;
public class B_A_Football_Match{
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
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int N = fs.nextInt();
        int M = fs.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Integer> [] graph = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            int u = fs.nextInt();
            int v = fs.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] col = new int[N+1];
        long ans = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int j = 1; j<=N; j++){
            if(col[j] != 0){
                continue;
            }
            int cnt1 = 0;
            int cnt2 = 0;

            col[j] = 1;
            queue.add(j);
            cnt1++;

            while(!queue.isEmpty()){
                int u = queue.poll();
                for(int v : graph[u]){
                    if(col[v] == 0){
                        col[v] = 3 -col[u];
                        if(col[v] == 1) cnt1++;
                        else cnt2++;
                        queue.add(v);
                    } else if(col[v] == col[u]){
                        System.out.println(-1);
                        return;
                    }
                }
            }
            ans+=Math.max(cnt1,cnt2);
        }
        System.out.println(ans);
    }
}