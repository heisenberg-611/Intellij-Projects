import java.util.*;

public class E_Reverse_Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        if (isSorted(a)) {
            System.out.println("YES\n0");
            return;
        }

        if (n < 3) {
            System.out.println("NO");
            return;
        }

        List<int[]> moves = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) minIdx = j;
            }

            while (minIdx - i >= 2) {
                reverse3(a, minIdx - 2);
                moves.add(new int[]{minIdx - 1, minIdx + 1});
                minIdx -= 2;
            }

            if (minIdx - i == 1 && i + 2 < n) {
                reverse3(a, i);
                moves.add(new int[]{i + 1, i + 3});
                reverse3(a, i);
                moves.add(new int[]{i + 1, i + 3});
            }
        }

        if (isSorted(a)) {
            System.out.println("YES");
            System.out.println(moves.size());
            for (int[] m : moves) System.out.println(m[0] + " " + m[1]);
        } else {
            System.out.println("NO");
        }
    }

    private static void reverse3(int[] a, int start) {
        int temp = a[start];
        a[start] = a[start + 2];
        a[start + 2] = temp;
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return false;
        }
        return true;
    }
}