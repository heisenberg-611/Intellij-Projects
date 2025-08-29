public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity + 1]; // 1-based index
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int[] getHeap() {
        return heap;
    }

    public void insert(int val) {
        if (size == heap.length - 1) {
            System.out.println("Heap full. Cannot insert " + val);
            return;
        }
        heap[++size] = val;
        swim(size);
    }

    public void swim(int k) {
        while (k > 1 && heap[k] > heap[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public int extractMax() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int max = heap[1];
        heap[1] = heap[size--];
        sink(1);
        return max;
    }

    public void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && heap[j + 1] > heap[j]) j++;
            if (heap[k] >= heap[j]) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    // Heap sort: returns sorted array in descending order (max to min)
    public int[] sort() {
        MaxHeap tempHeap = new MaxHeap(size);
        for (int i = 1; i <= size; i++) {
            tempHeap.heap[i] = heap[i];
        }
        tempHeap.size = size;

        int[] sorted = new int[size];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = tempHeap.extractMax();
        }
        return sorted;
    }

    // Main method for quick demo
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(10);

        System.out.print("Heap array after inserts: ");
        for (int i = 1; i <= maxHeap.getSize(); i++) {
            System.out.print(maxHeap.getHeap()[i] + " ");
        }
        System.out.println();

        System.out.println("Extracted max: " + maxHeap.extractMax());

        System.out.print("Heap after extractMax: ");
        for (int i = 1; i <= maxHeap.getSize(); i++) {
            System.out.print(maxHeap.getHeap()[i] + " ");
        }
        System.out.println();

        // HeapSort demo
        MaxHeap heapSortDemo = new MaxHeap(6);
        heapSortDemo.insert(40);
        heapSortDemo.insert(10);
        heapSortDemo.insert(30);
        heapSortDemo.insert(5);
        heapSortDemo.insert(20);

        int[] sorted = heapSortDemo.sort();
        System.out.print("Heap sorted array (desc): ");
        for (int v : sorted) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
