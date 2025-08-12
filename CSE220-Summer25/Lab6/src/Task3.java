//LAB TASK NO NEED TO SUBMIT
// Complete the sumTree method
public class Task3 {

    // ===================================TASK#3===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods as per need
    public static Integer sumTree(BTNode root) {
        // TO DO
        return sumHelper(root, 0);
    }

    private static int sumHelper(BTNode node, int level) {
        int sum;
        if (node == null)
            return 0;
        int value = (Integer) node.elem;

        if (level == 0) {
            sum = value;
        } else {
            sum = value % level;
        }

        sum += sumHelper(node.left, level + 1);
        sum += sumHelper(node.right, level + 1);

        return sum;
    }
}
// ============================================================================