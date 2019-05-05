/**
 * Created by sam on 7/14/17.
 */
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Board test = new Board();
        boolean restart = false;
        int turn = 0;
        while(test.threeInARow() == false || test.boardFull() == false){
            test.printBoard();
            if(turn % 2 == 0){
                System.out.println("USER 1");
            }else{
                System.out.println("USER 2");
            }

            System.out.println("enter a X coordinate");
            String X = sc.nextLine();
            System.out.println("enter a Y coordinate");
            String Y = sc.nextLine();
            Integer x = 0;
            Integer y = 0;
            if(X.matches("-?\\d+(\\.\\d+)?") && Y.matches("-?\\d+(\\.\\d+)?")){
                x = Integer.valueOf(X);
                y = Integer.valueOf(Y);
                if((x < 0 || x > 2) || (y < 0 || y > 2) ){

                    System.out.println("THAT COORDINATE DOES NOT EXIST TRY AGAIN");
                    continue;
                }

                if(test.fillBoard(x,y,turn) == true){
                    turn++;
                }



            }else{
                System.out.println("THAT COORDINATE DOES NOT EXIST TRY AGAIN");
            }


            if(turn == 9){
                break;
            }
        }
        test.printBoard();
        if(test.boardFull()){
            System.out.println("TIE!");
        }else {

            if (turn % 2 == 0) {
                System.out.println("USER 2 WINS!");
            } else if (turn % 2 != 0) {
                System.out.println("USER 1 WINS!");
            }
        }









    }
}
