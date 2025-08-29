public class MinHeap {
    private final int[] heap;
    private int size;

    public MinHeap(int capacity) {
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
        while (k > 1 && heap[k] < heap[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int min = heap[1];
        heap[1] = heap[size--];
        sink(1);
        return min;
    }

    public void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && heap[j + 1] < heap[j]) j++;
            if (heap[k] <= heap[j]) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    // Heap sort: returns a sorted array from heap elements in ascending order
    public int[] sort() {
        // Make a copy of the heap to avoid destroying it
        MinHeap tempHeap = new MinHeap(size);
        for (int i = 1; i <= size; i++) {
            tempHeap.heap[i] = heap[i];
        }
        tempHeap.size = size;

        int[] sorted = new int[size];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = tempHeap.extractMin();
        }
        return sorted;
    }

    // Main method for quick demo
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(20);
        minHeap.insert(15);
        minHeap.insert(30);
        minHeap.insert(10);

        System.out.print("Heap array after inserts: ");
        for (int i = 1; i <= minHeap.getSize(); i++) {
            System.out.print(minHeap.getHeap()[i] + " ");
        }
        System.out.println();

        System.out.println("Extracted min: " + minHeap.extractMin());

        System.out.print("Heap after extractMin: ");
        for (int i = 1; i <= minHeap.getSize(); i++) {
            System.out.print(minHeap.getHeap()[i] + " ");
        }
        System.out.println();

        // HeapSort demo
        MinHeap heapSortDemo = new MinHeap(6);
        heapSortDemo.insert(40);
        heapSortDemo.insert(10);
        heapSortDemo.insert(30);
        heapSortDemo.insert(5);
        heapSortDemo.insert(20);

        int[] sorted = heapSortDemo.sort();
        System.out.print("Heap sorted array: ");
        for (int v : sorted) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
