//Assignment Task (must Submit)
// Completes the isBST method
public class Task6 {

    //===================================TASK#6======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
//    public static Boolean isBST( BSTNode root ){
//        //TO DO
//        if (root == null) return true;
//        if (root.left == null && root.right == null) return true;
//        if (root.left != null && root.right != null) {
//            if (root.left.elem < root.elem && root.right.elem > root.elem) return true;
//            else return false;
//        }
//        return isBST(root.left) && isBST(root.right);
//    }

//    public static Boolean isBST(BSTNode root) {
//        return isBSTHelper(root, null, null);
//    }
//
//    private static Boolean isBSTHelper(BSTNode node, Integer min, Integer max) {
//        if (node == null) return true;
//
//        if (min != null && node.elem <= min) return false;
//        if (max != null && node.elem >= max) return false;
//
//        return isBSTHelper(node.left, min, node.elem) && isBSTHelper(node.right, node.elem, max);
//    }

//    public static Boolean isBST ( BSTNode root) {
//        if (root == null) return true;
//
//        if (root.left != null) {
//            int leftMax = findMax(root.left);
//            if (leftMax >= root.elem) return false;
//        }
//
//        if (root.right != null) {
//            int rightMin = findMin(root.right);
//            if (rightMin <= root.elem) return false;
//        }
//
//        return true;
//    }
//
//    private static int findMax(BSTNode node) {
//        int max = node.elem;
//        if (node.left != null) max = Math.max(max, findMax(node.left));
//        if (node.right != null) max = Math.max(max, findMax(node.right));
//        return max;
//    }
//
//    private static int findMin(BSTNode node) {
//        int min = node.elem;
//        if (node.left != null) min = Math.min(min, findMin(node.left));
//        if (node.right != null) min = Math.min(min, findMin(node.right));
//        return min;
//    }

    public static Boolean isBST(BSTNode root) {
        return isBST(root, null, null);
    }

    private static Boolean isBST(BSTNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.elem <= min) || (max != null && node.elem >= max)) return false;

        if (node.left != null) {
            if (findMax(node.left) >= node.elem) return false;
        }
        if (node.right != null) {
            if (findMin(node.right) <= node.elem) return false;
        }
        return isBST(node.left, min, node.elem) && isBST(node.right, node.elem, max);
    }

    private static int findMax(BSTNode node) {
        int max = node.elem;
        if (node.left != null) max = Math.max(max, findMax(node.left));
        if (node.right != null) max = Math.max(max, findMax(node.right));
        return max;
    }

    private static int findMin(BSTNode node) {
        int min = node.elem;
        if (node.left != null) min = Math.min(min, findMin(node.left));
        if (node.right != null) min = Math.min(min, findMin(node.right));
        return min;
    }
    //===============================================================
}