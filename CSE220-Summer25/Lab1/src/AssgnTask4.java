//Assignment Task 04: Game Arena
class AssgnTask4{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODES
    public static void playGame( Integer[][] arena ){

        //For this task you don't need to create any new 2D array
        //just print the result inside the function

        //TO DO
        int rows = arena.length;
        int count2 = 0;
        for(int i = 0; i < arena.length; i++){
            for(int j = 0; j < arena[0].length; j++){
                if(arena[i][j] % 50 == 0 && arena[i][j] != 0) {
                    if (i - 1 >= 0) if (arena[i - 1][j] == 2) count2++;
                    if (i + 1 < rows) if (arena[i + 1][j] == 2) count2++;
                    if (j - 1 >= 0) if (arena[i][j - 1] == 2) count2++;
                    if (j + 1 < arena[i].length) if (arena[i][j + 1] == 2) count2++;
                }
            }
        }
        if((count2*2)<10){System.out.println("Points Gained: "+(count2*2)+". Your team is out.");}
        else {System.out.println("Points Gained: "+(count2*2)+". Your team has survived the game.");}
    }

    //DO NOT CHANGE ANY DRIVER CODES BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] arena = {
                {0,2,2,0},
                {50,1,2,0},
                {2,2,2,0},
                {1,100,2,0}
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);

        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");

        System.out.print("\nYour Output:\n");
        playGame( arena );

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
                {0,2,2,0,2},
                {1,50,2,1,100},
                {2,2,2,0,2},
                {0,200,2,0,0}
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);

        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");

        System.out.print("\nYour Output:\n");
        playGame( arena1 );
    }
}
//                    int[][] directions = {
//                            {-1, 0},  // Top
//                            {1, 0},   // Down
//                            {0, -1},  // Left
//                            {0, 1}    // Right
//                    };
//                    for (int[] dir : directions) {
//                        int newRow = i + dir[0];
//                        int newCol = j + dir[1];
//
//                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < arena[newRow].length) {
//                            if (arena[newRow][newCol] == 2) {
//                                count2++;
//                            }
//                        }
//                    }