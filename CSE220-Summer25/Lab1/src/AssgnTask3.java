//Assignment Task 03: Matrix Compression
class AssgnTask3{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODES
    public static Integer[][] compressMatrix( Integer[][] matrix ){

        //For this task you'll need to create a new 2D array

        //TO DO

        //remove the line below and return the newly created Compressed 2D matrix
        int sigma = matrix.length;
        int beta = matrix[0].length;
        Integer[][] gammaArray = new Integer[sigma/2][beta/2];

        for(int i = 0; i < sigma/2; i++){
            int hola1 = i*2;
            for(int j = 0; j < beta/2; j++){
                int hola2 = j*2;
                gammaArray[i][j] = matrix[hola1][hola2] +
                        matrix[hola1+1][hola2]+
                            matrix[hola1+1][hola2+1] +
                        matrix[hola1][hola2+1];
            }
        }
        return gammaArray;
    }
//    public static Integer[][] compressMatrix(Integer[][]matrix)
//    {
//        int new_row=matrix.length/2;
//        int new_col=matrix[0].length/2;
//        Integer [][]compressed_matrix=new Integer[new_row][new_col];
//        for(int i=0;i<matrix.length;i+=2)
//        {
//            for(int j=0;j<matrix[i].length;j+=2)
//            {
//                int add=matrix[i][j]+matrix[i+1][j]+matrix[i][j+1]+matrix[i+1][j+1];
//                compressed_matrix[i/2][j/2]=add;
//            }
//        }
//        return compressed_matrix;
//    }

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