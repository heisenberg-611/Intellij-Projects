/**
 *    author:  kabir_singh
 *    created: 2025.11.04 20:55:28
 **/
import java.io.*;
import java.util.*;

public class H_220_Trees_Reassessed {
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
        int[] post = new int[N];
        for (int i = 0; i < N; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        int[] pos = new int[N + 1];
        for (int i = 0; i < N; i++) {
            pos[in[i]] = i;
        }

        int[][] stack = new int[N][4];
        int top = -1;

        int[] pre = new int[N];
        int preIdx = 0;

        stack[++top] = new int[]{0, N - 1, 0, N - 1};

        while (top >= 0) {
            int[] frame = stack[top--];
            int inStart = frame[0], inEnd = frame[1];
            int postStart = frame[2], postEnd = frame[3];

            if (inStart > inEnd || postStart > postEnd) continue;

            int root = post[postEnd];
            pre[preIdx++] = root;

            if (inStart == inEnd) continue;

            int rootPos = pos[root];
            int leftSize = rootPos - inStart;

            if (rootPos + 1 <= inEnd) {
                stack[++top] = new int[]{
                    rootPos + 1, inEnd,
                    postStart + leftSize, postEnd - 1
                };
            }
            if (inStart <= rootPos - 1) {
                stack[++top] = new int[]{
                    inStart, rootPos - 1,
                    postStart, postStart + leftSize - 1
                };
            }
        }


        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < N; i++) {
            if (i > 0) pw.print(" ");
            pw.print(pre[i]);
        }
        pw.println();
        pw.flush();
    }
}