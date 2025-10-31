import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F_Longest_K_Distinct_Subarray{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] freq = new int[N + 1];
        int distinct = 0;
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < N; right++) {
            int val = A[right];
            if (freq[val] == 0) {
                distinct++;
            }
            freq[val]++;

            while (distinct > K) {
                int leftVal = A[left];
                freq[leftVal]--;
                if (freq[leftVal] == 0) {
                    distinct--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}