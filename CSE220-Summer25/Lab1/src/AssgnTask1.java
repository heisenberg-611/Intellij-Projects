import javax.swing.*;

//Assignment Task 01: Container with Most Water
class AssgnTask1{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void mostWater( Integer[] height ){
//        int left = 0;
//        int right = height.length - 1;
//        int maxW = 0;
//        while(left<right){
//            int length = right - left;
//            int minH = Math.min(height[left], height[right]);
//            int area = length*minH;
//            maxW = Math.max(maxW, area);
//            if(height[left] < height[right]){
//                left++;
//            } else {
//                right--;
//            }
//        }
//        System.out.println(maxW);
        int L = 0, R = height.length - 1, W = 0;
        while (L < R) {
            int currentWidth = R - L;
            int boundary = height[L] < height[R] ? height[L] : height[R];
            int currentArea = currentWidth * boundary;
            W = W > currentArea ? W : currentArea;

            // Sneaky pointer movement using bitwise XOR trick
            int moveLeft = height[L] < height[R] ? 1 : 0;
            L += moveLeft;
            R -= (moveLeft ^ 1);
//            if(moveLeft == 1){
//                 R -= 0;
//            } else {
//                R -= 1;
//            }
        }
        System.out.println(W);
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println("Given Array: ");
        Arr.print(array);
        System.out.println("\nExpected Output:");
        System.out.print("49");
        System.out.print("\nYour Output:\n");
        mostWater( array );

    }
}
