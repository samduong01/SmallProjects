/**
 * Created by sam on 7/14/17.
 */
public class Board {
    String user1 = "X";
    String user2 = "O";
    private String[][] board = {{" "," "," "},{" "," "," "},{" "," "," "}};
    boolean threeInARow = false;
    boolean boardFull = false;

    public Board(){
    }




    public int printBoard(){
        System.out.println("    X →  ");
        System.out.println("      0   1   2 ");
        System.out.println("Y 0 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | ");
        System.out.println("↓ 1 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | ");
        System.out.println("  2 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | ");
        return 0;

    }

    public boolean fillBoard(int xIn,int yIn,int turnIn){


        if(board[yIn][xIn] != " "){
            System.out.println("SPOT ALREADY TAKEN");
            return false;

        }
        if(turnIn % 2 ==  0){

            board[yIn][xIn] = user1;
        }else{
            board[yIn][xIn] = user2;
        }
        return true;
    }

    public boolean boardFull(){
        if(((board[0][0]!= " " &&board[0][1]!= " "&&board[0][2]!= " "&&board[1][0]!= " "&&board[1][1]!= " "&&board[1][2]!= " "&&board[2][0]!= " "&&board[2][1]!= " "&&board[2][2]!= " ")) && threeInARow() == false  ){
            boardFull = true;
        }
        return boardFull;
    }

    public boolean threeInARow(){
        //left to right
        if((board[0][0] == user1 && board[0][1] == user1 && board[0][2] == user1) || (board[0][0] == user2 && board[0][1] == user2 && board[0][2] == user2) ){
            threeInARow = true;
        }

        if((board[1][0] == user1 && board[1][1] == user1 && board[1][2] == user1) || (board[1][0] == user2 && board[1][1] == user2 && board[1][2] == user2) ){
            threeInARow = true;
        }

        if((board[2][0] == user1 && board[2][1] == user1 && board[2][2] == user1) || (board[2][0] == user2 && board[2][1] == user2 && board[2][2] == user2) ){
            threeInARow = true;
        }
        //vertical

        if((board[0][0] == user1 && board[1][0] == user1 && board[2][0] == user1) || (board[0][0] == user2 && board[1][0] == user2 && board[2][0] == user2) ){
            threeInARow = true;
        }

        if((board[0][1] == user1 && board[1][1] == user1 && board[2][1] == user1) || (board[0][1] == user2 && board[1][1] == user2 && board[2][1] == user2) ){
            threeInARow = true;
        }

        if((board[0][2] == user1 && board[1][2] == user1 && board[2][2] == user1) || (board[0][2] == user2 && board[1][2] == user2 && board[2][2] == user2) ){
            threeInARow = true;
        }

        //diagonals

        if((board[0][0] == user1 && board[1][1] == user1 && board[2][2] == user1) || (board[0][0] == user2 && board[1][1] == user2 && board[2][2] == user2) ){
            threeInARow = true;
        }

        if((board[0][2] == user1 && board[1][1] == user1 && board[2][0] == user1) || (board[0][2] == user2 && board[1][1] == user2 && board[2][0] == user2) ){
            threeInARow = true;
        }



        return threeInARow;

    }

}
