import java.util.*;

public class F_An_Ancient_Sorting_Algorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int l = 0;
        while (l < n) {
            int r = l;
            while (r + 1 < n && (a[r] % 2 == a[r + 1] % 2))
                r++;

            for (int i = l; i <= r; i++) {
                for (int j = l; j < r - (i - l); j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
            }

            l = r + 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
