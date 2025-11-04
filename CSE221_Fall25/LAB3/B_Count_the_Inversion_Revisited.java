/**
 *    author:  kabir_singh
 *    created: 2025.11.04 20:30:27
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Count_the_Inversion_Revisited {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        final int OFFSET = 1_000_000;
        final int SIZE = 2_000_001;
        int[] fenw = new int[SIZE + 1];

        long ans = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            long sq = (long) a * a;

            if (sq < 1_000_000L) {
                int idx = (int) sq + OFFSET;
                long sum = 0;
                for (int k = idx + 1; k > 0; k -= k & -k) sum += fenw[k];
                ans += total - sum;
            }

            int pos = a + OFFSET;
            for (int k = pos + 1; k <= SIZE; k += k & -k) fenw[k]++;
            total++;
        }

        System.out.println(ans);
    }
}
