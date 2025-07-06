//Assignment Task 01: Container with Most Water
class AssgnTask1{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void mostWater( Integer[] height ){
        int head1 = 0;
        int tail1 = height.length - 1;
        int mostWater = 0;
        while(head1 < tail1){
            int minH = Math.min(height[head1], height[tail1]);
            int capacity = (tail1 - head1) * minH;
            if(capacity > mostWater) mostWater = capacity;
            if(height[head1] < height[tail1]) head1++;
            else if(height[head1] > height[tail1]) tail1--;
            else {
                head1++;
                tail1--;
            }
        }
        System.out.println(mostWater);
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
