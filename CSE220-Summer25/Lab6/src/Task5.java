// Complete the subtractSummation method
//ASSIGNMENT TASK MUST SUBMIT
public class Task5 {

    //===================================TASK#5===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per a need
    public static Integer subtractSummation( BTNode root ){
        //TO DO
        int sum = 0;
        Integer sum_L = sumL ( root , 0, sum);
        Integer sum_R = sumR ( root , 0, sum);
        return sum_L-sum_R + ( Integer ) root.elem;
    }

    private static int sumL ( BTNode root, int lvl, int sum){
        if(root == null) return sum;
        sum += (Integer)root.elem;
        return sumL ( root.left , lvl+1, sum);
    }

    private static int sumR (BTNode root , int lvl, int sum){
        if(root == null) return sum;
        sum += (Integer)root.elem;
        return sumR ( root.right , lvl+1, sum);
    }
    //============================================================================
}