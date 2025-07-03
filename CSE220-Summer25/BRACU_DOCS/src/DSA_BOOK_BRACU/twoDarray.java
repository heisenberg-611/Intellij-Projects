package DSA_BOOK_BRACU;

import java.util.Arrays;
import java.util.Scanner;

public class twoDarray {

    public static void display2Darray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void display1Darray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void rowWise2Darray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void colWise2Darray(int[][] arr) {
        int maxCols = 0;
        for (int[] row : arr) {
            if (row != null && row.length > maxCols) {
                maxCols = row.length;
            }
        }

        for (int col = 0; col < maxCols; col++) {
            for (int row = 0; row < arr.length; row++) {
                if (arr[row] != null && col < arr[row].length) {
                    System.out.print(arr[row][col] + " ");
                }
            }
        }
    }

    public static void sumAllElements(int[][] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                sum += arr[i][j];
            }
        }
        System.out.println("Sum of all elements is "+sum);
    }

    public static void sumOfRowWiseElements(int[][] arr){
//        int row = arr.length;
//        int col = arr[0].length;
        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                result[i] = result[i]+arr[i][j];
            }
        }
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
            if(i != result.length-1){
                System.out.print(" ");
            }
            else{
                System.out.println();
            }
        }
    }

    public static int[] sumOfColWiseElements(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int[] result = new int[col];
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++){
//                result[j] = result[j]+arr[i][j];
//            }
//        }
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                result[i] = result[i]+arr[j][i];
            }
            System.out.print(result[i]+" ");
            if(i != col-1){
                System.out.print(" ");
            }
            else{
                System.out.println();
            }
        }
        return result;
    }

    public static int[][] SwappingMx2Array(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0;i<row;i++){
            int temp = arr[i][0];
            arr[i][0] = arr[i][1];
            arr[i][1] = temp;
        }
        return arr;
    }

    public static int[][] swappingColumnsByMxNArray(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col/2;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][col-1-j];
                arr[i][col-1-j] = temp;
            }
        }
        return arr;
    }

    public static int sumOfPrimaryDiagonal(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int sum = 0;
        for(int i=0;i<row;i++){
            sum += arr[i][i];
        }
        return sum;
    }

    public static int sumOfSecondaryDiagonal(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int sum = 0;
        for(int i=0;i<col;i++){
            sum += arr[i][col-1-i];
        }
        return sum;
    }

    public static int[][] addMatrix(int[][] arr1, int[][] arr2){
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int row2 = arr2.length;
        int col2 = arr2[0].length;
        if(row1 != row2 || col1 != col2){
            System.out.println("Wrong input - addition not possible");
            return null;
        } else {
            int[][] result = new int[row1][col1];
            for(int i=0;i<row1;i++){
                for(int j=0;j<col1;j++){
                    result[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            return result;
        }
    }

    public static int[][] multiplyMatrix(int[][] arr1, int[][] arr2){
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int row2 = arr2.length;
        int col2 = arr2[0].length;
        if(col1 != row2){
            System.out.println("Wrong input - multiplication not possible");
            return null;
        } else {
            int[][] result = new int[row1][col2];
            for(int i=0;i<row1;i++){
                for(int j=0;j<col2;j++){
                    for(int k=0;k<col1;k++){
                        result[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
            return result;
        }
    }

    public static int[][] transposeMatrix(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int[][] result = new int[col][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                result[j][i] = arr[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the dimensions of the array");
//        int r = sc.nextInt();
//        int c = sc.nextInt();
//        System.out.println("Enter the elements of the array");
//        int[][] arr = new int[r][c];
//        for(int i=0;i<r;i++){
//            for(int j = 0; j< c; j++){
//                arr[i][j] = sc.nextInt();
//            }
//            System.out.println();
//        }
        int[][] arr = {{4,3,8},
                        {2,5,1},
                        {7,-1,9},
                        {5,4,-2}};
        int[][] arr1 = {{4,3},{2,5},{7,6}};
        int[][] arr2 = {{4,3,8,-7},{2,5,-1,12},{-6,16,9,10},{4,13,11,18}};
        int[][] arr3 = {{4,3,8},{2,5,1},{7,6,9}};
        sumOfRowWiseElements(arr);
        sumOfColWiseElements(arr);
//        rowWise2Darray(arr);
//        System.out.println();
//        colWise2Darray(arr);
//        System.out.println();
//        sumAllElements(arr);
//        System.out.println();
//        int[] result = sumOfRowWiseElements(arr);
//        display1Darray(result);
//        System.out.println();
//        result = sumOfColWiseElements(arr);
//        display1Darray(result);
//        System.out.println();
//        int[][] result1 = SwappingMx2Array(arr1);
//        display2Darray(result1);
//        System.out.println();
//        int[][] result2 = swappingColumnsByMxNArray(arr2);
//        display2Darray(result2);
//        System.out.println();
//        int sum = sumOfPrimaryDiagonal(arr3);
//        System.out.println("Sum of primary diagonal elements is "+sum);
//        int sum1 = sumOfSecondaryDiagonal(arr2);
//        System.out.println("Sum of secondary diagonal elements is "+sum1);
//        System.out.println(Arrays.deepToString(transposeMatrix(arr)));
    }
}