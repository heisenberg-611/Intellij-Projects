/**
 *    author:  kabir_singh
 *    created: 2025.12.09 20:29:13
 **/
import java.io.*;
import java.util.*;

public class A_Advising {
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
    public static void main(String[] args) throws IOException{
        FastScanner fs = new FastScanner(System.in);
        int N = fs.nextInt();
        int M = fs.nextInt();
        @SuppressWarnings("unchecked")
        List <Integer> [] graph = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        int [] backedge = new int[N+1];
        for(int i = 0; i<M;i++){
            int A = fs.nextInt();
            int B = fs.nextInt();
            graph[A].add(B);
            backedge[B]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 1;i <= N; i++){
            if(backedge[i] == 0){
                queue.add(i);
            }
        }

        int[] order = new int[N];
        int idx = 0;

        while(!queue.isEmpty()){
            int u= queue.poll();
            order[idx++] = u;
            for(int v : graph[u]){
                backedge[v]--;
                if(backedge[v]==0){
                    queue.add(v);
                }
            }
        }

        if(idx!=N){
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++){
                sb.append(order[i]).append(' ');
            }
            System.out.println(sb.toString().trim());
        }
    }
}
