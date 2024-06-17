import java.util.Scanner;
public class KnightTourProblem {
    public static int fieldSize;

    //checks, if the spot on the field is valid and still on the board
    public static boolean isSafe(int x, int y, int[][] field){
        if(x>=0 && x< fieldSize && y>=0 && y< fieldSize && field[x][y]== -1) return true;
        else return false;
    }

    //function for printing the solution matrix. it will represent the moves in order
    static void printSolution(int field[][])
    {
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++)
                System.out.print(field[x][y] + " ");
            System.out.println();
        }
    }
     //function for better readability
    static void initField(int[][] arr){
        for (int x = 0; x < fieldSize; x++)
        for (int y = 0; y < fieldSize; y++)
            arr[x][y] = -1;

    }

    //algorithim for solving the Knight tour
    public static boolean solveKnightTour(){
        int[][] field = new int[fieldSize][fieldSize];
        initField(field);

        //xMove and yMove of the same index represent a posible move by the Knight. There are 8 possible moves
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        //the starting point is 0,0
        field[0][0]= 0;

        if(!solveing(0,0,1,field,xMove,yMove)){
            System.out.println("Solution not posible");
            return false;}
            else{
                printSolution(field);
                return true;
            }
    }
    //function to solve the problem via backtracking
    static boolean solveing(int x, int y, int movei,int field[][], int xMove[],int yMove[]){
                int next_y, next_x;
                
                //if field is 1x1
                if (movei == fieldSize * fieldSize)
            return true;

            for(int k=0;k<8;k++){

                //try a next move from Knight
                next_x = x + xMove[k];
                next_y = y + yMove[k];
                if (isSafe(next_x, next_y, field)) {

                    //if the point is valid the next index number for the moves gets in there
                    field[next_x][next_y] = movei;

                    //try to "add" a next move
                    if (solveing(next_x, next_y, movei + 1, field, xMove, yMove))
                        return true;
                        //no next move, so this path in invalid
                    else
                        field[next_x][next_y]= -1; // backtracking
                }

            }
            return false;
    }
    public static void main(String args[]){
      Scanner input = new Scanner(System.in);
      // setting the boardsize
      fieldSize = input.nextInt();
      input.close();

      solveKnightTour();
    }
}
