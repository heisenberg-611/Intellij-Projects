public class Assignment3 {

    //    public static int[] distributeTasks(int[] tasks, int m) {
//        // Initialize MinHeap with m machines, all with initial load 0
//        MinHeap machineLoads = new MinHeap(m);
//        for (int i = 0; i < m; i++) {
//            machineLoads.insert(0);
//        }
//
//        // Assign each task to the machine with the minimum current load
//        for (int task : tasks) {
//            // Get a machine with a minimum load
//            int minLoad = machineLoads.extractMin();
//
//            // Assign the current task to this machine
//            int newLoad = minLoad + task;
//
//            // Update the load in the heap
//            machineLoads.insert(newLoad);
//        }
//
//        // Extract the final loads from the heap
//        int[] result = new int[m];
//        for (int i = 0; i < m; i++) {
//            // We might have fewer tasks than machines
//            if (machineLoads.getSize() > 0) {
//                result[i] = machineLoads.extractMin();
//            } else {
//                result[i] = 0;
//            }
//        }
//
//        return result;
//    }
    public static int[] distributeTasks ( int[] tasks , int m ) {
        // Initialize MinHeap with m machines, all with initial load 0
        MinHeap machineLoads = new MinHeap ( m );
        for ( int i = 0 ; i < m ; i++ ) {
            machineLoads.insert ( 0 );
        }

        // Assign each task to the machine with the minimum current load
        for ( int task : tasks ) {
            // Get a machine with a minimum load
            int minLoad = machineLoads.extractMin ( );

            // Assign the current task to this machine
            int newLoad = minLoad + task;

            // Update the load in the heap
            machineLoads.insert ( newLoad );
        }

        // Extract the final loads from the heap
        int[] result = new int[ m ];
        for ( int i = 0 ; i < m ; i++ ) {
            try {
                // Try to extract the minimum element
                result[ i ] = machineLoads.extractMin ( );
            } catch ( RuntimeException e ) {
                // If the heap is empty, set the load to 0
                result[ i ] = 0;
            }
        }

        return result;
    }

    // Test with the sample input
    public static void main ( String[] args ) {
        // Test Case 1 (Original example)
        runTest ( new int[] { 2 , 4 , 7 , 1 , 6 } , 4 , "Test Case 1" );

        // Test Case 2: More tasks than machines
        runTest ( new int[] { 3 , 5 , 7 , 2 , 8 , 4 , 1 , 9 } , 3 , "Test Case 2" );

        // Test Case 3: Equal tasks and machines
        runTest ( new int[] { 4 , 3 , 7 , 5 } , 4 , "Test Case 3" );

        // Test Case 4: Fewer tasks than machines
        runTest ( new int[] { 6 , 8 , 4 } , 5 , "Test Case 4" );

        // Test Case 5: Identical tasks
        runTest ( new int[] { 5 , 5 , 5 , 5 , 5 , 5 } , 3 , "Test Case 5" );

        // Test Case 6: Very different task sizes
        runTest ( new int[] { 1 , 20 , 3 , 15 , 2 , 10 } , 4 , "Test Case 6" );

        // Test Case 7: One very large task
        runTest ( new int[] { 2 , 3 , 1 , 50 , 4 , 2 } , 3 , "Test Case 7" );

        // Test Case 8: Empty tasks array
        runTest ( new int[] { } , 3 , "Test Case 8" );

        // Test Case 9: Only one machine
        runTest ( new int[] { 5 , 3 , 8 , 2 , 7 } , 1 , "Test Case 9" );

        // Test Case 10: Only one task
        runTest ( new int[] { 4, 2, 7, 6, 5, 9, 3, 8 } , 3 , "Test Case 10" );
    }

    private static void runTest ( int[] tasks , int m , String testName ) {
        System.out.println ( "\n" + testName + ":" );
        System.out.print ( "Tasks: " );
        for ( int task : tasks ) {
            System.out.print ( task + " " );
        }
        System.out.println ( "\nMachines: " + m );

        int[] result = distributeTasks ( tasks , m );

        System.out.print ( "Machine loads: " );
        for ( int load : result ) {
            System.out.print ( load + " " );
        }
        System.out.println ( );
    }
}