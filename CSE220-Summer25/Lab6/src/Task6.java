// Complete the levelSum method
//ASSIGNMENT TASK MUST SUBMIT
public class Task6 {

    //===================================TASK#6===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum( BTNode root ){
        //TO DO
        int sum = 0;
        Integer sum_O = SumO ( root , 0);
        Integer sum_E = SumE ( root , 0);
        return (sum_O - sum_E);
    }

    private static int SumO(BTNode root, int lvl){
        if(root == null) return 0;
        int sum = 0;
        if(lvl%2==1){
            sum += (Integer) root.elem;
        }
        return (sum+SumO(root.left, lvl+1) + SumO(root.right, lvl+1));
    }

    private static int SumE(BTNode root, int lvl){
        if(root == null) return 0;
        int sum = 0;
        if(lvl%2==0){
            sum += (Integer) root.elem;
        }
        return sum+SumE(root.left, lvl+1) + SumE(root.right, lvl+1);
    }
    //============================================================================

}
