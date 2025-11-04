/**
 *    author:  kabir_singh
 *    created: 2025.11.04 21:00:47
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Fast_Power_Drift{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        long a = Long.parseLong(data[0]);
        long b = Long.parseLong(data[1]);
        
        final long MOD = 107;
        a %= MOD;
        if (a == 0) {
            System.out.println(0);
            return;
        }
 
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        System.out.println(res);
    }
}