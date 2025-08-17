//Recursively find the path from the root to a node containing the given key
//public class Task2 {
//
//    //===================================TASK#2===================================
//    // This method takes 2 parameters:
//    // root - the root of the BST
//    // key - the destination node's value
//    // Returns the path from root to key as a string or "No Path Found"
//    public static String findPath(BSTNode root, Integer key) {
//        String path = pathHelper(root, key);
//        if (path == null) return "No Path Found";
//        return path;
//    }
//
//    private static String pathHelper(BSTNode root, Integer key) {
//        if (root == null) return null;
//
//        if ((int) root.elem == key) return root.elem.toString();
//
//        // Search left
//        String leftPath = pathHelper(root.left, key);
//        if (leftPath != null) return root.elem + " " + leftPath;
//
//        // Search right
//        String rightPath = pathHelper(root.right, key);
//        if (rightPath != null) return root.elem + " " + rightPath;
//
//        return null; // Not found
//    }
//
//}

import java.util.Objects;

//Without Recursion
//Before starting to work on this design the Tree in the Tester code
// Complete the sumOfLeaves method
public class Task2 {

    //===================================TASK#2===================================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is an Integer
    // You'll need to find the path from the root to a node containing the Integer
    // return the path as a String
    public static String findPath ( BSTNode root , Integer key ) {
        boolean found = search ( root , key );
        if ( ! found ) return "No Path Found";
        else {
            String path = "";
            while ( root != null ) {
                if ( path.equals ( "" ) ) {
                    path = path + root.elem;
                } else {
                    path = path + " " + root.elem;
                }
                if ( Objects.equals ( root.elem , key ) ) {
                    return path;
                } else if ( key < root.elem ) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return path;
            //remove this line
        }
    }

    private static boolean search ( BSTNode root , Integer key ) {
        if ( root == null ) return false;
        if ( root.elem == key ) return true;
        return search ( root.left , key ) || search ( root.right , key );
    }
    //============================================================================

}
