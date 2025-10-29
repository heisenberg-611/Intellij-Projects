import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Two_Sum_Revisited {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] arr1 = new long[N];
        long[] arr2 = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            arr2[j] = Long.parseLong(st.nextToken());
        }

        int i = 0;
        int j = M - 1;
        int bestI = i;
        int bestJ = j;
        long minDiff = Math.abs(arr1[i] + arr2[j] - K);

        while (i < N && j >= 0) {
            long sum = arr1[i] + arr2[j];
            long diff = Math.abs(sum - K);
            if (diff < minDiff) {
                minDiff = diff;
                bestI = i;
                bestJ = j;
            }
            if (sum < K) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println((bestI + 1) + " " + (bestJ + 1));
    }
}