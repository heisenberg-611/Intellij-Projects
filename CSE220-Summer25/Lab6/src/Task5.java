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
        Integer sum_L = sum ( root .left, 0);
        Integer sum_R = sum ( root .right, 0);
        return sum_L-sum_R;
    }

    private static int sum ( BTNode root, int sum) {
        if (root == null) return sum;
        sum += (Integer) root.elem+sum (root.left, sum)+sum (root.right, sum);
        return sum;
    }

//    private static int sumL(BTNode root, int sum) {
//        if (root == null) return sum;
//        sum += (Integer) root.elem;
//        sum = sumL(root.left, sum);
//        sum = sumL(root.right, sum);
//        return sum;
//    }
//
//    private static int sumR(BTNode root, int sum) {
//        if (root == null) return sum;
//        sum += (Integer) root.elem;
//        sum = sumR(root.left, sum);
//        sum = sumR(root.right, sum);
//        return sum;
//    }
    //============================================================================
}