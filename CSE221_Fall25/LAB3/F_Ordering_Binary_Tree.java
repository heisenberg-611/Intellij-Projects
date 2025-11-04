/**
 *    author:  kabir_singh
 *    created: 2025.11.04 20:42:06
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class F_Ordering_Binary_Tree{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, N - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int l = range[0];
            int r = range[1];
            if (l > r) continue;
            int mid = (l + r) >>> 1;
            if (sb.length() > 0) sb.append(' ');
            sb.append(A[mid]);
            stack.push(new int[]{mid + 1, r});
            stack.push(new int[]{l, mid - 1});
        }

        pw.println(sb);
        pw.flush();
    }
}