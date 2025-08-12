### What Task 2 and Task 3 are asking you to do

Below is a clear breakdown of the requirements and how they’re tested in BinaryTreeTester.java so you know exactly what to implement and why your output is expected.

---

### Task 2: Level Wise Minimum (smallestLevel)

- Method signature: `public static void smallestLevel(BTNode root, Integer[] levelArray, int lvl)`
- Parameters:
    - `root`: the root of a binary tree (node type `BTNode` with fields like `elem`, `left`, `right`).
    - `levelArray`: an Integer array whose length equals the depth/height of the tree (as computed by `BinaryTreeTester.getDepth(root)`). You must fill this array so that each index i contains the minimum value found at level i of the tree.
    - `lvl`: the current level during traversal (start with 0 when you call it from outside; the tester calls it like `smallestLevel(root, lvlArray, 0)`).
- Return: nothing (you mutate `levelArray` in-place).
- Important notes/hints given in the file:
    - You may need to cast: `int value = (Integer) root.elem;`
    - Your goal is to update `levelArray` so that for every level, it holds the minimum node value at that level.

- What the tester expects (BinaryTreeTester.task2):
    - Tree: `new Object[]{ null, 4, 9, 2, 3, -5, null, 7 }`
    - Expected result array: `{ 4, 2, -5 }`
    - Explanation:
        - Level 0: [4] → min = 4
        - Level 1: [9, 2] → min = 2
        - Level 2: [3, -5, 7] → min = -5

- Typical approach/algorithm:
    - Perform a DFS (preorder/inorder/postorder doesn’t matter) keeping track of the current level.
    - For each non-null node at level `lvl`:
        - If `levelArray[lvl] == null` or current value < `levelArray[lvl]`, update it.
    - Recurse to children with `lvl + 1`.
    - Stop at null nodes.

- Edge considerations:
    - Don’t access `levelArray[lvl]` if `root` is null (base case: if root == null, return first).
    - The tester guarantees `levelArray.length == getDepth(root)`, so recursion to null children at the next level is safe as long as you check `root == null` before reading/writing the array.

- Your current implementation (in Task2.java) follows exactly this logic and matches the expected output in the tester.

---

### Task 3: Special Sum of Nodes (sumTree)

- Method signature: `public static Integer sumTree(BTNode root)`
- Parameter:
    - `root`: the root of the binary tree.
- Return: an `Integer` which is a “special sum” computed using the node’s value and its depth level in the tree.
- Hints in the file:
    - You may need to cast values: `(Integer) node.elem`
    - You can use helper methods.

- What “Special Sum” means here (deduced from the tester’s expected result):
    - Root contributes its value as-is (level 0).
    - Every other node at level L > 0 contributes `(node value) % L` (value modulo its level).
    - The final answer is the sum over all nodes.

- Why this is correct (checked against BinaryTreeTester.task3):
    - The tester builds a specific tree and expects 15.
    - If you sum: root 9 (as-is) + for other nodes use (value % level), you get 15 for the given tree.
    - Example breakdown for the given tree:
        - Level 0: 9 → contributes 9
        - Level 1: 4%1 = 0, 5%1 = 0 → contributes 0
        - Level 2: 18%2 = 0, 14%2 = 0, 3%2 = 1 → contributes 1
        - Level 3: 54%3 = 0, 12%3 = 0, 8%3 = 2 → contributes 2
        - Level 4: 91%4 = 3, 56%4 = 0 → contributes 3
        - Total = 9 + 0 + 1 + 2 + 3 = 15

- Typical approach/algorithm:
    - Write a recursive helper that takes a node and its level.
    - Base case: if node == null, return 0.
    - Let `val = (Integer) node.elem`.
    - If `level == 0`, contribute `val`; else contribute `val % level`.
    - Return contribution + recurse left with `level + 1` + recurse right with `level + 1`.

- Your current implementation (in Task3.java) already implements this logic correctly using `sumHelper(node, level)` and returns 15 for the tester’s tree.

---

### How the tester runs them
- Task 2:
    - Computes `Integer[] lvlArray = new Integer[getDepth(root)];`
    - Calls `Task2.smallestLevel(root, lvlArray, 0);`
    - Compares `lvlArray` with the expected array.

- Task 3:
    - Calls `Integer returnedInteger = Task3.sumTree(root);`
    - Compares the returned integer to `15`.

---

### Quick checklists
- Task 2 checklist:
    - Handle `null` nodes (return immediately).
    - Cast node.elem to Integer.
    - Initialize or update `levelArray[lvl]` with the minimum value.
    - Recurse to children with `lvl + 1`.

- Task 3 checklist:
    - Handle `null` nodes (return 0).
    - Cast node.elem to Integer.
    - Add `value` if level == 0; otherwise add `value % level`.
    - Sum contributions from both subtrees.

If you need, I can also walk you through the BinaryTreeTester’s tree construction format and how levels are determined from the array representation.