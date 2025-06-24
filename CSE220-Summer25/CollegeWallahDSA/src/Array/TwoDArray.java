package Array;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArray {
    // Method to print a 2D array
    public static void printTwoDArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to add two matrices
    static void add(int[][] arr, int r1, int c1, int[][] arr2, int r2, int c2) {
        if(r1 != r2 || c1 != c2) {
            System.out.println("Wrong input - addition not possible");
            return;
        }
        int[][] sum = new int[r1][c1];

        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c1; j++) {
                sum[i][j] = arr[i][j] + arr2[i][j];
            }
        }
        printTwoDArray(sum); // Added to display the result
    }

    // Method to multiply two matrices
    static void mul(int[][] arr, int r1, int c1, int[][] arr2, int r2, int c2) {
        if(c1 != r2) {
            System.out.println("Wrong input - multiplication not possible");
            return;
        }
        int[][] mul = new int[r1][c2];
        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c2; j++) {
                for(int k = 0; k < c1; k++) {
                    mul[i][j] += arr[i][k] * arr2[k][j]; // Fixed the indices here
                }
            }
        }
        printTwoDArray(mul);
    }

    // Method to transpose a matrix
    static int[][] transpose(int[][] arr, int r, int c) {
        int[][] ans = new int[c][r];

        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                ans[i][j] = arr[j][i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First matrix input
        System.out.println("Enter the number of rows and columns for first matrix:");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] arr1 = new int[r1][c1];
        System.out.println("Enter the elements of the first matrix:");
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        // Second matrix input
//        System.out.println("Enter the number of rows and columns for second matrix:");
//        int r2 = sc.nextInt();
//        int c2 = sc.nextInt();
//        int[][] arr2 = new int[r2][c2];
//        System.out.println("Enter the elements of the second matrix:");
//        for(int i = 0; i < r2; i++) {
//            for(int j = 0; j < c2; j++) {
//                arr2[i][j] = sc.nextInt();
//            }
//        }

//        System.out.println("First matrix:");
//        printTwoDArray(arr1);
//        System.out.println("Second matrix:");
//        printTwoDArray(arr2);
//
//        System.out.println("Matrix Addition Result:");
//        add(arr1, r1, c1, arr2, r2, c2);
//
//        System.out.println("Matrix Multiplication Result:");
//        mul(arr1, r1, c1, arr2, r2, c2);
        printTwoDArray(transpose(arr1, r1, c1));
    }
}