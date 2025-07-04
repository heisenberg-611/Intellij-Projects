//Assignment Task 03: Matrix Compression
class AssgnTask3{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODES
    public static Integer[][] compressMatrix( Integer[][] matrix ){

        //For this task you'll need to create a new 2D array

        //TO DO

        //remove the line below and return the newly created Compressed 2D matrix
        int sigma = matrix.length/2;
        int beta = matrix[0].length/2;
        Integer[][] gammaArray = new Integer[sigma][beta];

        for(int i = 0; i < sigma; i++){
            for(int j = 0; j < beta; j++){
                gammaArray[i][j] = matrix[i*2][j*2] + matrix[i*2+1][j*2]+ matrix[i*2+1][j*2+1] + matrix[i*2][j*2+1];
            }
        }
        return gammaArray;
    }

    //DO NOT CHANGE ANY DRIVER CODES BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
                { 1 , 2 , 3 , 4 },
                { 5 , 6 , 7 , 8 },
                { 1 , 3 , 5 , 2 },
                {-2 , 0 , 6 ,-3 }
        };
//        Integer[][] matrix = {
//                { 1 , 2 , 3 , 4 , 5, 9},
//                { 5 , 6 , 7 , 8 , 9 , 1},
//                { 1 , 3 , 5 , 2 , 10 , 4},
//                {-2 , 0 , 6 ,-3 , 11, 9},
//                {-2 , 0 , 6 ,-3 , 12, 3},
//                {-2 , 0 , 6 ,-3 , 13, 2}
//        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);

        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");

        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}