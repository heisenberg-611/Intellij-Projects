package LAB1;
import java.util.*;

public class D_Is_Sorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            boolean sorted = true;
            for (int i = 0; i < N - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sorted = false;
                    break;
                }
            }
            
            if (sorted) System.out.println("YES");
            else System.out.println("NO");
        }
        
        sc.close();
    }
}
