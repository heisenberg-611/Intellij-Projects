import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_Two_Sum_Trouble{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        int left = 0;
        int right = N - 1;
        
        while (left < right) {
            long currentSum = arr[left] + arr[right];
            
            if (currentSum == S) {
                System.out.println((left + 1) + " " + (right + 1));
                return;
            } else if (currentSum < S) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(-1);
    }
}