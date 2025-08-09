### Overview
In Task5.java, I implemented three recursive operations on a singly linked list:
- Task 5A: Find the maximum value in the list.
- Task 5B: Sort the list using a recursive selection-sort approach (by swapping node values).
- Task 5C: For each node, print where duplicates of its value appear (indices), or say "No Duplicate".

Below is a breakdown of each task: what it does, how it works, and why it meets the requirements.

### Task 5A: findMax_recursive
Code essence:
- Base case: if the list is empty (head == null), return Integer.MIN_VALUE.
- Recursive step: compute the max of the rest of the list (maxRest = findMax_recursive(head.next)) and return the larger of head.elem and maxRest.

Why this works:
- The recursion reduces the problem to a smaller sublist each time.
- The base case provides a minimal sentinel value so that any real element will be larger.
- If the list is empty, returning Integer.MIN_VALUE is a standard choice to represent "no elements".

Edge cases:
- Empty list: returns Integer.MIN_VALUE.
- Single element: returns that element.

Complexity:
- Time: O(n) — visits each node exactly once.
- Space: O(n) recursion depth in the call stack.

### Task 5B: sortLL_recursive (selection sort by recursion)
Approach:
- If the list is empty or has one node, it’s already sorted — return head.
- Otherwise:
    1. Find the minimum node in the current (sub)list using a helper findMinNode.
    2. Swap the current head’s value with the minimum node’s value.
    3. Recursively sort the remainder of the list (head.next).

Key points:
- findMinNode is itself recursive: it returns the node with the smallest elem in the list starting at head.
- Sorting is done by swapping node values (not relinking nodes). This keeps the node structure intact and is simpler to implement recursively.

Why this meets the requirement:
- The task asks for a recursive sort; selection sort logic is implemented recursively: at each level, select min of the sublist, put it at the front, and recurse.

Edge cases:
- Empty or single-node list: returned as-is.
- Works for repeated values — stable order isn’t guaranteed since we swap values (value-based swap disregards original relative order), but stability is usually not required unless specified.

Complexity:
- Time: O(n^2) — each level finds a minimum in O(n) and there are O(n) levels.
- Space: O(n) recursion depth in the worst case.

Note on design choice:
- Swapping values vs. relinking nodes: swapping values is simpler and sufficient for typical lab tasks. If nodes carried more fields or identity mattered, a pointer-based swap (relinking nodes) would be preferable and a bit more involved.

### Task 5C: findDup_Recursive (print duplicates with indices)
Goal:
- For each node at index i, print all other indices j where node.elem equals the current value. If none exist, print "No Duplicate".
- Output format matches the driver’s expected output.

How it works:
- findDup_Recursive calls a recursive driver findDup_Helper(originalHead, current, idx):
    - Base case: if current == null, stop.
    - Otherwise, collect indices of duplicates for current.elem using collectIndices, excluding the current index (idx).
    - Print either "value: idx1, idx2, ..." or "value: No Duplicate".
    - Recurse to the next node with idx + 1.

- collectIndices(node, value, excludeIndex, currentIndex) recursively traverses the entire list and builds a comma-separated string of indices where node.elem == value and currentIndex != excludeIndex.
    - The recursion visits to the end first and builds the string while unwinding. Because of how it prepends currentIndex to the string built for the rest, indices appear in ascending order.

Why this meets the requirement:
- For each node, it prints exactly the positions of matching values elsewhere in the list.
- Matches the exact expected format in the sample (including "No Duplicate").

Edge cases:
- No duplicates for a value: prints "value: No Duplicate".
- Multiple duplicates: prints all in ascending order.
- The same value appears many times: each node’s line reflects all other positions except its own (excludeIndex ensures we don’t include the current node’s index).

Complexity:
- Time: O(n^2) — for each node (n), it scans the whole list (n) to collect indices.
- Space: O(n) recursion depth for collectIndices, plus O(n) for the outer traversal stack in the worst case.

### Driver code behavior and sample outputs
- Task 5A: For [23, 5, 3, 11, 27, 6], it prints 27 as the max.
- Task 5B: On the same list, it prints the sorted order: 3 -> 5 -> 6 -> 11 -> 23 -> 27 -> null (the list’s node values are rearranged in place).
- Task 5C: For [10, 22, 13, 20, 22, 23, 10, 22], it prints:
    - 10: 6
    - 22: 4, 7
    - 13: No Duplicate
    - 20: No Duplicate
    - 22: 1, 7
    - 23: No Duplicate
    - 10: 0
    - 22: 1, 4
      These lines match the expected output formatting.

### Summary
- Task 5A uses a straightforward max-of-head-and-rest recursion.
- Task 5B implements recursive selection sort via value swapping and a recursive min-node finder.
- Task 5C recursively traverses the list per node and collects duplicate positions, printing them in the exact required format.

If you’d like, I can also provide a pointer-swapping variant of Task 5B or an O(n) average-time duplicate indexer using a hashmap (non-recursive), but the current solutions follow the recursive spirit of the lab and match the expected outputs.