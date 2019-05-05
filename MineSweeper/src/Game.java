/**
 * Created by sam on 6/26/18.
 */

import java.util.*;
public class Game {
    static Space[][] board = new Space[10][10];
    public static void main(String[] args){
        buildBoard();
        for(int i = 0;i<10;i++) {
            update();
            go();
        }
    }

    public static void update(){

        for(int i = 0;i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                System.out.print(board[i][j].label);
            }
            System.out.println("");
        }
    }

    public static void buildBoard(){
        for(int i = 0;i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                board[i][j] = new Space(i,j);
            }
        }
    }

    public static void go(){
        System.out.println("Enter Row");
        Scanner sc = new Scanner(System.in);
        int row = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Col");
        int col = Integer.parseInt(sc.nextLine());
        if(board[col][row].name !="BOMB"){
            board[col][row].name = "EMPTY";
        }
        board[col][row].update();
    }
}
