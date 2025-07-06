public class LabTask1{

    //Complete this method so that it gives the Expected Output
    //NO NEED TO SUBMIT LAB TASKS
    public static Integer[] mergeSortedArray( Integer[] arr1, Integer[] arr2 ){

        //TO DO
        //DELETE the following return statement when you're ready to return the newly Created array
        Integer[] mergedArray = new Integer[arr1.length + arr2.length];
        int i = 0; // 0 -> 1
        int j = 0; // 0 -> 1
        for(int k = 0; k < mergedArray.length; k++){  // K = 0 -> 1 -> 2
            if(i == arr1.length){
                mergedArray[k] = arr2[j];
                j++;
            } else if(j == arr2.length){
                mergedArray[k] = arr1[i];
                i++;
            } else if(arr1[i] < arr2[j]){
                mergedArray[k] = arr1[i];
                i++;
            } else{
                mergedArray[k] = arr2[j];
                j++;
            }
        }
//        int p1 = 0;
//        for(int k = 0; k < arr1.length; k++){
//            mergedArray[k] = arr1[k];
//            p1=k+1;
//        }
//        for(int k = 0; k < arr2.length; k++){
//            mergedArray[p1] = arr2[k];
//            p1++;
//        }
//        for (int i = 0; i < mergedArray.length - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < mergedArray.length; j++) {
//                if (mergedArray[j] < mergedArray[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            Integer temp = mergedArray[minIndex];
//            mergedArray[minIndex] = mergedArray[i];
//            mergedArray[i] = temp;
//        }
        return mergedArray;
    }

    //DO NOT CHANGE ANY DRIVER CODES BELOW THIS LINE
    public static void main(String[] args){
        Integer[] a1 = {1, 2, 3};
        Integer[] a2 = {2, 5, 6};
        System.out.print("Array 1: ");
        Arr.print(a1);
        System.out.print("Array 2: ");
        Arr.print(a2);
        System.out.println("Expected Output: [ 1 2 2 3 5 6 ]");
        Integer[] returned_val_1 = mergeSortedArray(a1, a2);
        System.out.print("Your Output: ");
        Arr.print(returned_val_1);
        System.out.print("\n======================\n");
        Integer[] a3 = {1, 3, 5, 11};
        Integer[] a4 = {2, 7, 8};
        System.out.print("\nArray 3: ");
        Arr.print(a3);
        System.out.print("Array 4: ");
        Arr.print(a4);
        System.out.println("Expected Output: [ 1 2 3 5 7 8 11 ]");
        Integer[] returned_val_2 = mergeSortedArray( a3, a4);
        System.out.print("Your Output: ");
        Arr.print(returned_val_2);
    }
}

