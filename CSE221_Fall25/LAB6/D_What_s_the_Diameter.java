/**
 *    author:  kabir_singh
 *    created: 2025.12.12 09:57:04
 **/
import java.io.*;
import java.util.*;

public class D_What_s_the_Diameter{
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

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1; i <=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++){
            int u = fs.nextInt();
            int v = fs.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        int [] dist = new int[N+1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        dist[1] = 0;
        queue.add(1);

        int a = 1;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : graph[u]){
                if(dist[v] == -1){
                    dist[v] = dist[u]+1;
                    queue.add(v);
                    if(dist[v] > dist[a]) a = v;
                }
            }
        }
        Arrays.fill(dist, -1);
        dist[a] = 0;
        queue.clear();
        queue.add(a);

        int B = a;       
        int diameter = 0;

        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : graph[u]){
                if(dist[v] == -1){
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                    if(dist[v] > diameter){
                        diameter = dist[v];
                        B = v;
                    }
                }
            }
        }
        System.out.println(diameter);
        System.out.println(a + " " + B);
    }
}