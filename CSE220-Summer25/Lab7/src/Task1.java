//Before starting to work on this design, the Tree in the Tester code
// Complete the lowestCommonAncestor method
public class Task1 {

    //======================TASK#1======================
    // This method takes only 3 parameters first one is root
    // and second & third parameter is as 2 integers
    // You'll need to find the lowest common ancestor of them and return it
    public static Integer lowestCommonAncestor( BSTNode root, Integer x, Integer y ){
        while (root!= null) {
            if (x < root.elem && y < root.elem) {
                root = root.left;
            }
            else if (x > root.elem && y > root.elem) {
                root = root.right;
            }
            // return root.elem;
            else {
                return root.elem;
            }
        }
        return null;
    }

    //==================================================

}
