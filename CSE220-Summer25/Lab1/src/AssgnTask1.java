//Assignment Task 01: Container with Most Water
class AssgnTask1{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void mostWater( Integer[] height ){
        int left = 0;
        int right = height.length - 1;
        int maxW = 0;
        while(left<right){
            int minH = Math.min(height[left], height[right]);
            int capacity = (right - left) * minH;
            if(capacity > maxW) maxW = capacity;
            if(height[left] < height[right]) left++;
            else if(height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        System.out.println(maxW);
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
