/**
 *    author:  kabir_singh
 *    created: 2025.11.04 21:00:35
 **/
import java.util.*;
import java.io.*;
public class A_Count_the_Inversion{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
 
        long inversionCount = countInversions(A);
 
        System.out.println(inversionCount);
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < N; i++) {
            if (i > 0) pw.print(' ');
            pw.print(A[i]);
        }
        pw.println();
        pw.flush();
    }
 
    static long countInversions(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }
 
    static long mergeSort(int[] arr, int[] temp, int left, int right) {
        long invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }
 
    static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
 
        int i = left, j = mid + 1, k = left;
        long invCount = 0;
 
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
                invCount += (mid - i + 1);
            }
        }
 
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= right) {
            arr[k++] = temp[j++];
        }
 
        return invCount;
    }
}