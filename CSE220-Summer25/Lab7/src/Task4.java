//Assignment Task (must Submit)
// Complete the rangeSum method
public class Task4 {

    //===================================TASK#4======================
    // This method takes only three parameters
    // first one is the root of the given tree
    // second one the low range, and third one is a high range
    // You can use extra helper private static methods as per need
    public static Integer rangeSum( BSTNode root, Integer low, Integer high ){
        //TO DO
        return rangeSumHelper ( root, low, high); // remove this line
    }

    private static Integer rangeSumHelper (BSTNode root, Integer low, Integer high){
        if(root == null) return 0;

        if(root.elem >= low && root.elem <= high){
            return root.elem + rangeSumHelper ( root.left, low, high )+rangeSumHelper ( root.right, low, high);
        } else {
            return rangeSumHelper ( root.left, low, high )+rangeSumHelper ( root.right, low, high);
        }
    }
    //===============================================================
}
//Using BST property
//public class Task4 {
//
//    // Optimized Range Sum in BST
//    public static Integer rangeSum(BSTNode root, Integer low, Integer high) {
//        return rangeSumHelper(root, low, high);
//    }
//
//    private static Integer rangeSumHelper(BSTNode root, Integer low, Integer high) {
//        if (root == null) return 0;
//
//        // Case 1: Node value is smaller than low → skip left subtree
//        if (root.elem < low) {
//            return rangeSumHelper(root.right, low, high);
//        }
//
//        // Case 2: Node value is larger than high → skip right subtree
//        if (root.elem > high) {
//            return rangeSumHelper(root.left, low, high);
//        }
//
//        // Case 3: Node is within range → include its value & check both subtrees
//        return root.elem
//                + rangeSumHelper(root.left, low, high)
//                + rangeSumHelper(root.right, low, high);
//    }
//}


//Using Stack
//public class Task4 {
//
//    //===================================TASK#4======================
//    public static Integer rangeSum(BSTNode root, Integer low, Integer high) {
//        if (root == null) return 0;
//
//        int sum = 0;
//        java.util.Stack<BSTNode> stack = new java.util.Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            BSTNode node = stack.pop();
//
//            if (node == null) continue;
//
//            // If within range, add it
//            if (node.elem >= low && node.elem <= high) {
//                sum += node.elem;
//            }
//
//            // BST property optimization:
//            // If node.elem > low, then left child may also be in range
//            if (node.elem > low) {
//                stack.push(node.left);
//            }
//
//            // If node.elem < high, then right child may also be in range
//            if (node.elem < high) {
//                stack.push(node.right);
//            }
//        }
//
//        return sum;
//    }
//    //===============================================================
//
//}