/**
 *    author:  kabir_singh
 *    created: 2025.11.04 20:48:22
 **/

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G_220_Trees{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] in = new int[N];
        for (int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] pre = new int[N];
        for (int i = 0; i < N; i++) {
            pre[i] = Integer.parseInt(st.nextToken());
        }

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        buildPostOrder(in, 0, N - 1, pre, 0, N - 1, pw);
        pw.flush();
    }

    private static void buildPostOrder(int[] in, int inStart, int inEnd,
                                       int[] pre, int preStart, int preEnd,
                                       PrintWriter pw) {
        if (inStart > inEnd || preStart > preEnd) return;

        int root = pre[preStart];
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;

        buildPostOrder(in, inStart, rootIndex - 1,
                       pre, preStart + 1, preStart + leftSize,
                       pw);

        buildPostOrder(in, rootIndex + 1, inEnd,
                       pre, preStart + leftSize + 1, preEnd,
                       pw);

        pw.print(root + " ");
    }
}