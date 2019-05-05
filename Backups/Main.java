/**
 * Created by sam on 7/21/17.
 */
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        double coin = Math.random();
        //boolean isHeads;
        String headsOrTails;
        if(coin<0.5){
            headsOrTails = "heads";
        }else{
           headsOrTails = "tails";
        }
        System.out.println(coin);
        System.out.println("the coin is " + headsOrTails);
        if(headsOrTails.equals("heads")){
            System.out.println("You go first");
        }else{
            System.out.println("AI goes first");

        }
        Board board = new Board();
        boolean restart = false;
        Scanner sc = new Scanner(System.in);
        int turn = 0;
        while (!board.threeInARow())
        {
            board.printBoard();
            if (turn % 2 == 0) {
                System.out.println("USER 1");
                System.out.println("enter a X coordinate");
                String X = sc.nextLine();
                System.out.println("enter a Y coordinate");
                String Y = sc.nextLine();
                Integer x = 0;
                Integer y = 0;
                if (X.matches("[0-2]") && Y.matches("[0-2]")) {
                    x = Integer.valueOf(X);
                    y = Integer.valueOf(Y);
                    if ((x < 0 || x > 2) || (y < 0 || y > 2)) {

                        System.out.println("THAT COORDINATE DOES NOT EXIST TRY AGAIN");
                        continue;
                    }


                    if (board.fillBoard(x, y, turn) == true) {
                        turn++;
                    }


                } else {
                    System.out.println("THAT COORDINATE DOES NOT EXIST TRY AGAIN");
                }
            } else {
                System.out.println("IN ELSE");
                board.AI();
                turn++;
                System.out.println("IN ELSE 2");
            }




            if (turn == 10) {
                break;
            }
        }
        board.printBoard();
        if (turn == 9)

        {
            System.out.println("TIE!");

        } else if (turn % 2 == 0)

        {
            System.out.println("AI WINS!");
        } else if (turn % 2 != 0)

        {
            System.out.println("USER 1 WINS!");
        }

    }
}

