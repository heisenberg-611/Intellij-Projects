/**
 *    author:  kabir_singh
 *    created: 2025.12.05 00:23:19
 **/
import java.io.*;
import java.util.*;

public class B_Can_you_Traverse_2 {
    static final InputStream in = System.in;
    static final byte[] buf = new byte[1 << 16];
    static int len = 0, ptr = 0;

    static int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buf);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buf[ptr++];
    }

    static int nextInt() throws IOException {
        int c;
        do {
            c = read();
            if (c == -1) return -1;
        } while (c <= ' ');

        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }

        int x = 0;
        while (c > ' ') {
            x = x * 10 + (c - '0');
            c = read();
        }
        return x * sign;
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        int M = nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        int[] u = new int[M];
        for (int i = 0; i < M; i++) u[i] = nextInt();      
        for (int i = 0; i < M; i++) {                    
            int a = u[i];
            int b = nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        boolean[] vis = new boolean[N + 1];
        int[] st = new int[N];
        int top = 0;

        st[top++] = 1;
        vis[1] = true;

        StringBuilder sb = new StringBuilder();

        while (top > 0) {
            int x = st[--top];
            sb.append(x).append(' ');
            ArrayList<Integer> adj = g[x];
            for (int i = adj.size() - 1; i >= 0; i--) {
                int y = adj.get(i);
                if (!vis[y]) {
                    vis[y] = true;       
                    st[top++] = y;
                }
            }
        }

        if (sb.length() > 0) sb.setLength(sb.length() - 1); 

        PrintWriter out = new PrintWriter(System.out);
        out.println(sb.toString());
        out.flush();
    }
}