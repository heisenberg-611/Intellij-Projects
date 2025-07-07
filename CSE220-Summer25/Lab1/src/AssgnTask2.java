//Assignment Task 02: Row Rotation Policy
class AssgnTask2{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODES
    public static Integer rowRotation( Integer examWeek, String[][] matrix ){

        //For this task you don't need to create new arrays
        //After rotation the Matrix should be printed inside the method
        //Only the integer row number is to be returned

        //TO DO
        int sigmaLogic = examWeek % matrix.length;

        for(int count = 0; count < sigmaLogic -1; count++){
            String[] judgmentRow = matrix[matrix.length-1];
            int k = matrix.length-1;
            while(k > 0){matrix[k] = matrix[k-1];k--;}
            matrix[0] = judgmentRow;
        }
        Arr.print2D(matrix);

        int seatStat = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(examWeek == 0)return seatStat;
                if(matrix[i][j].equals("AA")) {if (i == matrix.length - 1) seatStat = i + 1;
                else if (i < matrix.length - 1) seatStat = i + 1;
                else seatStat = 0;break;
                }
            }
        }
        return seatStat;
    }

    //DO NOT CHANGE ANY DRIVER CODES BELOW THIS LINE
    public static void main(String[] args){
        String[][] seatStatus = {
                {"A" , "B"  , "C"  , "D"  , "E"},
                {"F" , "G"  , "H"  , "I"  , "J"},
                {"K" , "L"  , "M"  , "N"  , "O"},
                {"P" , "Q"  , "R"  , "S"  , "T"},
                {"U" , "V"  , "W"  , "X"  , "Y"},
                {"Z" , "AA" , "BB" , "CC" , "DD"}
        };

        System.out.println("Given Seat Status: ");
        Arr.print2D(seatStatus);

        System.out.println("\nExpected Output:");
        System.out.println("| U  | V  | W  | X  | Y  | ");
        System.out.println("| Z  | AA | BB | CC | DD | ");
        System.out.println("| A  | B  | C  | D  | E  | ");
        System.out.println("| F  | G  | H  | I  | J  | ");
        System.out.println("| K  | L  | M  | N  | O  | ");
        System.out.println("| P  | Q  | R  | S  | T  | ");
        System.out.println("Your friend AA will be on row 2");

        System.out.print("\nYour Output:\n");
        Integer examWeek = 3;
        //This following should print modified seat status after rotation and return the current exam week
        Integer rowNumber = rowRotation( examWeek, seatStatus );
        //The following should print Your friend AA will be on row 2
        System.out.println("Your friend AA will be on row "+rowNumber);
    }
}