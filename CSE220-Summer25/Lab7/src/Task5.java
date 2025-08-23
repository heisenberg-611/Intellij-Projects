//Assignment Task (must Submit)
// Complete the sumOfLeaves method
public class Task5 {

    //===================================TASK#5======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Integer mirrorSum( BSTNode root ){
        //TO DO
        if (root == null) return 0;
        return mirror(root.left, root.right);
        //===============================================================
}
    private static int mirror(BSTNode a, BSTNode b) {
        if (a == null || b == null) return 0;

        int sum = 0;
        if (a.elem != null && b.elem != null) {
            sum += a.elem + b.elem;
        }
        sum += mirror(a.left, b.right) + mirror(a.right, b.left);
        return sum;
    }
}