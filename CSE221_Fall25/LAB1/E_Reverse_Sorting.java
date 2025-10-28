package LAB1;
import java.io.*;
import java.util.*;

public class E_Reverse_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int[] base = new int[n];
        
        tok = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            base[i] = Integer.parseInt(tok.nextToken());
        }

        if (n == 1) {
            out.println("YES");
            out.println(0);
            out.close();
            return;
        }
        if (n == 2) {
            if (base[0] <= base[1]) {
                out.println("YES");
                out.println(0);
            } else {
                out.println("NO");
            }
            out.close();
            return;
        }

        int[] ref = new int[n];
        for (int i = 0; i < n; i++) ref[i] = base[i];
        order(ref);

        int cntEven = (n + 1) / 2;
        int cntOdd = n / 2;
        int[] evenA = new int[cntEven];
        int[] oddA = new int[cntOdd];
        int[] evenB = new int[cntEven];
        int[] oddB = new int[cntOdd];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenA[i / 2] = base[i];
                evenB[i / 2] = ref[i];
            } else {
                oddA[i / 2] = base[i];
                oddB[i / 2] = ref[i];
            }
        }

        order(evenA);
        order(oddA);
        order(evenB);
        order(oddB);

        if (!equal(evenA, evenB) || !equal(oddA, oddB)) {
            out.println("NO");
            out.close();
            return;
        }

        int[] state = new int[n];
        for (int i = 0; i < n; i++) state[i] = base[i];

        int[][] records = new int[n * n][2];
        int used = 0;
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i <= n - 3; i++) {
                if (state[i] > state[i + 2]) {
                    int tmp = state[i];
                    state[i] = state[i + 2];
                    state[i + 2] = tmp;
                    records[used][0] = i + 1;
                    records[used][1] = i + 3;
                    used++;
                    changed = true;
                }
            }
        }
        boolean ok = true;
        for (int i = 1; i < n; i++) {
            if (state[i] < state[i - 1]) {
                ok = false;
                break;
            }
        }

        if (!ok) {
            out.println("NO");
        } else {
            out.println("YES");
            out.println(used);
            for (int i = 0; i < used; i++) {
                out.println(records[i][0] + " " + records[i][1]);
            }
        }

        out.close();
    }
    static void order(int[] seq) {
        int len = seq.length;
        for (int i = 0; i < len - 1; i++) {
            int low = i;
            for (int j = i + 1; j < len; j++) {
                if (seq[j] < seq[low]) low = j;
            }
            if (low != i) {
                int t = seq[i];
                seq[i] = seq[low];
                seq[low] = t;
            }
        }
    }

    static boolean equal(int[] x, int[] y) {
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i]) return false;
        }
        return true;
    }
}