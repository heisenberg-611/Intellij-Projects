/**
 *    author:  kabir_singh
 *    created: 2025.11.04 20:40:16
 **/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Fast_Matrix_Drift{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        final int MOD = 1_000_000_007;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a11 = Integer.parseInt(st.nextToken());
            int a12 = Integer.parseInt(st.nextToken());
            int a21 = Integer.parseInt(st.nextToken());
            int a22 = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(br.readLine());

            int b11 = a11, b12 = a12, b21 = a21, b22 = a22;

            int r11 = 1, r12 = 0, r21 = 0, r22 = 1;

            while (X > 0) {
                if ((X & 1) == 1) {

                    int nr11 = (int)(((long)r11 * b11 + (long)r12 * b21) % MOD);
                    int nr12 = (int)(((long)r11 * b12 + (long)r12 * b22) % MOD);
                    int nr21 = (int)(((long)r21 * b11 + (long)r22 * b21) % MOD);
                    int nr22 = (int)(((long)r21 * b12 + (long)r22 * b22) % MOD);
                    r11 = nr11; r12 = nr12; r21 = nr21; r22 = nr22;
                }

                int nb11 = (int)(((long)b11 * b11 + (long)b12 * b21) % MOD);
                int nb12 = (int)(((long)b11 * b12 + (long)b12 * b22) % MOD);
                int nb21 = (int)(((long)b21 * b11 + (long)b22 * b21) % MOD);
                int nb22 = (int)(((long)b21 * b12 + (long)b22 * b22) % MOD);
                b11 = nb11; b12 = nb12; b21 = nb21; b22 = nb22;

                X >>= 1;
            }

            pw.println(r11 + " " + r12);
            pw.println(r21 + " " + r22);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}