### Assignment 3: Task Distribution System

Assignment 3 implements a task scheduling algorithm that distributes tasks among multiple machines to balance the workload efficiently. It's a classic load balancing problem that uses a min-heap data structure.

#### Problem Statement

Given:
- An array of `tasks`, where each element represents the time required to complete a task
- A number `m`, representing the number of available machines

The goal is to distribute all tasks among the machines so that the workload is balanced, minimizing the maximum time any machine spends processing tasks.

#### Algorithm Implementation

The `distributeTasks` method follows these steps:

1. **Initialization**:
    - Create a MinHeap of size `m` (number of machines)
    - Initialize each machine with a load of 0

2. **Task Assignment**:
    - For each task:
        - Extract the machine with the minimum current load (using `extractMin()`)
        - Add the current task's processing time to this machine's load
        - Insert the updated load back into the MinHeap

3. **Result Collection**:
    - Extract all loads from the MinHeap
    - Handle potential empty heap scenarios using a try-catch block instead of checking `getSize()`
    - Return an array containing the final load of each machine

#### Time and Space Complexity

- **Time Complexity**: O(n log m) where n is the number of tasks and m is the number of machines
    - Each extractMin and insert operation takes O(log m) time
    - We perform these operations n times (once for each task)

- **Space Complexity**: O(m) to store the machine loads in the heap

#### Example Execution

For input tasks `[2, 4, 7, 1, 6]` and 4 machines:

1. Initialize all machines with load 0: MinHeap = [0, 0, 0, 0]
2. Extract min (0), assign task 2: MinHeap = [0, 0, 0, 2]
3. Extract min (0), assign task 4: MinHeap = [0, 0, 2, 4]
4. Extract min (0), assign task 7: MinHeap = [0, 2, 4, 7]
5. Extract min (0), assign task 1: MinHeap = [1, 2, 4, 7]
6. Extract min (1), assign task 6: MinHeap = [2, 4, 7, 7]
7. Result: [2, 4, 7, 7]

This represents the final load on each machine after all tasks have been assigned.

#### Key Concepts

- **Greedy Algorithm**: The algorithm follows a greedy approach, always assigning the next task to the machine with the minimum current load.
- **Priority Queue Implementation**: The MinHeap serves as a priority queue, efficiently giving us the machine with the minimum load.
- **Load Balancing**: The algorithm naturally balances the load across machines, minimizing the maximum completion time.

### Assignment 4: Top K Elements Finder

Assignment 4 implements an algorithm to find the K largest elements in an array using a max-heap data structure.

#### Problem Statement

Given:
- An array of integers `nums`
- An integer `k`

The goal is to find the `k` largest elements in the array, in descending order of their values.

#### Algorithm Implementation

The `findTopKElements` method follows these steps:

1. **Heap Construction**:
    - Create a MaxHeap with capacity equal to the length of the input array
    - Insert all elements from the array into the MaxHeap

2. **Extract Top Elements**:
    - Create a result array of size `k`
    - Extract the maximum element from the MaxHeap `k` times
    - Handle potential empty heap scenarios using a try-catch block

3. **Edge Case Handling**:
    - If the heap becomes empty (when there are fewer than `k` elements in the original array), fill the remaining positions with `Integer.MIN_VALUE`

#### Time and Space Complexity

- **Time Complexity**: O(n + k log n)
    - Building the heap takes O(n) time
    - Extracting k elements takes O(k log n) time

- **Space Complexity**: O(n) for storing all elements in the heap

#### Example Execution

For input array `[4, 10, 2, 8, 6, 7]` and k = 3:

1. Build MaxHeap with all elements: [10, 8, 7, 4, 6, 2]
2. Extract max (10): result = [10]
3. Extract max (8): result = [10, 8]
4. Extract max (7): result = [10, 8, 7]
5. Return [10, 8, 7] as the top 3 elements

#### Key Concepts

- **Selection Algorithm**: This is a heap-based selection algorithm to find the k largest elements.
- **Priority Queue**: The MaxHeap acts as a priority queue that gives us elements in descending order.
- **Partial Sorting**: Unlike a full sort, this algorithm efficiently finds just the k largest elements.

### Modifications to Work Without getSize()

Both assignments were originally written to use the `getSize()` method to check if the heap still has elements before extracting. In our modified versions:

1. We use a try-catch approach to handle empty heap situations:
    - When the heap is empty, `extractMin()` or `extractMax()` throws a RuntimeException
    - We catch this exception and handle it appropriately

2. In Assignment 3, we set the machine load to 0 if the heap is empty
3. In Assignment 4, we set the result element to Integer.MIN_VALUE if the heap is empty

This demonstrates how to work with the heap data structures using only the allowed methods: `insert()`, `swim()`, `extractMin()`/`extractMax()`, `sink()`, and `sort()`.

### Conclusion

Both assignments demonstrate practical applications of heap data structures:

1. **Assignment 3** shows how a min-heap can be used for load balancing and scheduling
2. **Assignment 4** shows how a max-heap can be used for efficient selection of top elements

The implementations are efficient and handle edge cases appropriately, and they've been modified to work without relying on the `getSize()` and `getHeap()` methods.