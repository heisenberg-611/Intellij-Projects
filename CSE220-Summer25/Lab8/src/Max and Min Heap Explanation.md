### MaxHeap and MinHeap Classes Explained

Both MaxHeap and MinHeap are binary heap data structures implemented in Java. These heap structures are complete binary trees with additional ordering properties, represented efficiently using arrays. Let's explore each in detail.

### Common Heap Properties

Both implementations share these characteristics:

1. **Array Representation**: Both use 1-based indexing arrays (index 0 is not used)
2. **Complete Binary Tree**: Elements are arranged in a complete binary tree
3. **Parent-Child Relationship**:
    - For any element at index `i`:
    - Parent is at index `i/2`
    - Left child is at index `2i`
    - Right child is at index `2i+1`

### MaxHeap Class

A MaxHeap is a binary heap where the value of each node is greater than or equal to the values of its children. This means the largest element is always at the root.

#### Fields:
- `private int[] heap`: The array that stores heap elements
- `private int size`: Tracks the number of elements in the heap

#### Constructor:
- `MaxHeap(int capacity)`: Initializes the heap with a specified capacity

#### Key Methods:

1. **insert(int val)**:
    - Adds a new element to the heap
    - Places it at the end of the array
    - Calls `swim(size)` to restore heap property

2. **swim(int k)**:
    - Compares element with its parent (`heap[k/2]`)
    - If element > parent, swaps them
    - Continues upward until heap property is restored
    - Crucial comparison: `heap[k] > heap[k/2]` (ensures max at root)

3. **extractMax()**:
    - Returns and removes the maximum element (root)
    - Replaces root with the last element
    - Calls `sink(1)` to restore heap property
    - Returns the original maximum value

4. **sink(int k)**:
    - Compares element with its children
    - Finds larger child using: `if (j < size && heap[j + 1] > heap[j]) j++`
    - If element < larger child, swaps them
    - Continues downward until heap property is restored
    - Breaks when `heap[k] >= heap[j]` (element >= largest child)

5. **sort()**:
    - Creates a copy of the current heap
    - Repeatedly extracts max elements
    - Returns elements in descending order (largest to smallest)

### MinHeap Class

A MinHeap is a binary heap where the value of each node is less than or equal to the values of its children. This means the smallest element is always at the root.

#### Fields:
- `private final int[] heap`: The array that stores heap elements
- `private int size`: Tracks the number of elements in the heap

#### Constructor:
- `MinHeap(int capacity)`: Initializes the heap with a specified capacity

#### Key Methods:

1. **insert(int val)**:
    - Adds a new element to the heap
    - Places it at the end of the array
    - Calls `swim(size)` to restore heap property

2. **swim(int k)**:
    - Compares element with its parent (`heap[k/2]`)
    - If element < parent, swaps them
    - Continues upward until heap property is restored
    - Crucial comparison: `heap[k] < heap[k/2]` (ensures min at root)

3. **extractMin()**:
    - Returns and removes the minimum element (root)
    - Replaces root with the last element
    - Calls `sink(1)` to restore heap property
    - Returns the original minimum value

4. **sink(int k)**:
    - Compares element with its children
    - Finds smaller child using: `if (j < size && heap[j + 1] < heap[j]) j++`
    - If element > smaller child, swaps them
    - Continues downward until heap property is restored
    - Breaks when `heap[k] <= heap[j]` (element <= smallest child)

5. **sort()**:
    - Creates a copy of the current heap
    - Repeatedly extracts min elements
    - Returns elements in ascending order (smallest to largest)

### Key Differences Between MaxHeap and MinHeap

1. **Comparison Operators**:
    - MaxHeap: Uses `>` in swim and sink to maintain max at top
    - MinHeap: Uses `<` in swim and sink to maintain min at top

2. **Extraction Method**:
    - MaxHeap: `extractMax()` returns the largest element
    - MinHeap: `extractMin()` returns the smallest element

3. **Sort Order**:
    - MaxHeap: Sorts in descending order (largest to smallest)
    - MinHeap: Sorts in ascending order (smallest to largest)

4. **Usage in Assignment3**:
    - The `distributeTasks` method uses a MinHeap to efficiently find the machine with the minimum load each time a task needs to be assigned.

### Time Complexity

Both heap implementations have these performance characteristics:
- **insert()**: O(log n)
- **extractMax()/extractMin()**: O(log n)
- **sort()**: O(n log n)
- **getSize()/getHeap()**: O(1)

### Practical Application in Assignment3

The MinHeap is used in the task distribution problem to efficiently:
1. Find the machine with the minimum current load (extractMin)
2. Update machine loads when new tasks are assigned (insert)
3. This ensures tasks are always assigned to the least loaded machine, helping balance the workload effectively.

Both implementations demonstrate the elegant and efficient binary heap data structure, with the key difference being whether they prioritize maximum or minimum values at the root.