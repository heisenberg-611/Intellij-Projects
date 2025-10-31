import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class D_A_Beautiful_Sorted_List {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stA = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stA.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(stB.nextToken());
        }
        
        int[] finalBoss = new int[N + M];
        int i = 0, j = 0, k = 0;
        
        while (i < N && j < M) {
            if (A[i] <= B[j]) {
                finalBoss[k++] = A[i++];
            } else {
                finalBoss[k++] = B[j++];
            }
        }
        
        while (i < N) {
            finalBoss[k++] = A[i++];
        }
        
        while (j < M) {
            finalBoss[k++] = B[j++];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < N + M; idx++) {
            if (idx > 0) sb.append(" ");
            sb.append(finalBoss[idx]);
        }
        System.out.println(sb.toString());
    }
}