
/**
 *    author:  kabir_singh
 *    created: 2025.12.12 13:43:21
 **/
import java.io.*;
import java.util.*;

public class F_Number_Transformation {
    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null)
                    return null;
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

        final int LIMIT = 5000;
        boolean[] isPrime = new boolean[LIMIT + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= LIMIT; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= LIMIT; j += i)
                    isPrime[j] = false;
            }
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] primeFactors = new ArrayList[LIMIT + 1];
        for (int i = 0; i <= LIMIT; ++i)
            primeFactors[i] = new ArrayList<>();
        for (int x = 2; x <= LIMIT; ++x) {
            int n = x;
            for (int p = 2; p * p <= n; ++p) {
                if (n % p == 0) {
                    primeFactors[x].add(p);
                    while (n % p == 0)
                        n /= p;
                }
            }
            if (n > 1 && n != x)
                primeFactors[x].add(n);
        }

        int T = fs.nextInt();
        StringBuilder out = new StringBuilder();
        while (T-- > 0) {
            int s = fs.nextInt();
            int t = fs.nextInt();
            if (s == t) {
                out.append(0).append('\n');
                continue;
            }
            if (s > t) {
                out.append(-1).append('\n');
                continue;
            }

            int[] dist = new int[t + 1];
            Arrays.fill(dist, -1);
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            dist[s] = 0;
            dq.addLast(s);

            while (!dq.isEmpty()) {
                int u = dq.removeFirst();
                if (u > t)
                    continue;
                if (primeFactors[u].isEmpty())
                    continue;
                for (int p : primeFactors[u]) {
                    int v = u + p;
                    if (v <= t && dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        dq.addLast(v);
                    }
                }
            }

            out.append(dist[t]).append('\n');
        }
        System.out.print(out.toString());
    }

}