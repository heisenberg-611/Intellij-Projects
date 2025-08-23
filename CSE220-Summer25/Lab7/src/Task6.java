//Assignment Task (must Submit)
// Complete the isBST method
public class Task6 {

    //===================================TASK#6======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Boolean isBST( BSTNode root ){
        //TO DO
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null) {
            if (root.left.elem < root.elem && root.right.elem > root.elem) return true;
        }
        return false;
    }
    //===============================================================


}
