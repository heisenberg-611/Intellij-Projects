/**
 *    author:  kabir_singh
 *    created: 2025.11.04 21:05:52
 **/
import java.io.*;
import java.util.*;
public class E_Fast_Series_Drift{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            
            a %= m;
            if (a == 0) {
                sb.append("0\n");
                continue;
            }
            if (a == 1) {
                sb.append(n % m).append('\n');
                continue;
            }
            
            long[] res = powerAndSum(a, n, m);
            long sumPrefix = res[1];
            long ans = (a * sumPrefix) % m;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
    
    static long[] powerAndSum(long base, long n, long mod) {
        if (n == 0) {
            return new long[]{1 % mod, 0};
        }
        if (n == 1) {
            return new long[]{base % mod, 1 % mod};
        }
        
        long[] half = powerAndSum(base, n / 2, mod);
        long powHalf = half[0];
        long sumHalf = half[1]; 
        
        long powFull = (powHalf * powHalf) % mod;
        long sumFull;
        
        if (n % 2 == 0) {
 
            sumFull = (sumHalf * ((1 + powHalf) % mod)) % mod;
        } else {
 
            long sumEven = (sumHalf * ((1 + powHalf) % mod)) % mod;
 
            sumFull = (sumEven + powFull) % mod;
 
            powFull = (powFull * base) % mod;
        }
        return new long[]{powFull, sumFull};
    }
}