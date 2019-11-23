import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        double coin = Math.random();
        String headsOrTails;
        if(coin<0.5){
            headsOrTails = "heads";
        }else{
            headsOrTails = "tails";
        }

        System.out.println("The coin is " + headsOrTails);
        if(headsOrTails.equals("heads")){
            System.out.print("You go first, ");
        }else{
            System.out.print("AI goes first, ");

        }
        Board board = new Board();
        Scanner sc = new Scanner(System.in);
        int turn = 0;
        //player 1 starts
        if(headsOrTails.equals("heads")) {
            System.out.println("you are X");
            while (!board.threeInARow()) {
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
                    board.AI();
                    turn++;
                }
                if (turn == 10) {
                    break;
                }
            }
        }else {
            //user
            turn = 0;
            System.out.println("you are X");
            while (!board.threeInARow()){
                board.printBoard();
                if (turn % 2 == 0) {
                    board.AI();
                    turn++;
                }else{
                    System.out.println("USER 1");
                    System.out.println("enter a X coordinate");
                    String X = sc.nextLine();
                    System.out.println("enter a Y coordinate");
                    String Y = sc.nextLine();
                    int x;
                    int y;
                    if (X.matches("[0-2]") && Y.matches("[0-2]")) {
                        x = Integer.valueOf(X);
                        y = Integer.valueOf(Y);
                        if ((x < 0 || x > 2) || (y < 0 || y > 2)){
                            System.out.println("THAT COORDINATE DOES NOT EXIST TRY AGAIN");
                            continue;
                        }

                        if (board.fillBoard(x, y, turn +1)) {
                            turn++;
                        }
                    }else{
                        System.out.println("THAT COORDINATE DOES NOT EXIST TRY AGAIN");
                    }
                }

                if (turn == 10) {
                    break;
                }
            }
        }
        board.printBoard();
        if (board.threeInWin("O")) {
            System.out.println("AI WINS!");
        }else if(board.threeInWin("X")){
            System.out.println("YOU WIN!");
        }else if (turn == 9){
            System.out.println("TIE!");
        }
    }
}

