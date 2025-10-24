import java.util.*;

public class C_Fast_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            long N = sc.nextLong();
            long sum = N * (N + 1) / 2;
            System.out.println(sum);
        }
        
        sc.close();
    }
}
