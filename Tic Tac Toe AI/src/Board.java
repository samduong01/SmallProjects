/**
 * Created by sam on 7/21/17.
 */
public class Board {
    String user1 = "X";
    String user2 = "O";

    private String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    boolean threeInARow = false;
    boolean threeInWin = false;

    public Board() {

    }

    public int printBoard() {
        System.out.println("    X →  ");
        System.out.println("      0   1   2 ");
        System.out.println("Y 0 | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | ");
        System.out.println("↓ 1 | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | ");
        System.out.println("  2 | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | ");
        return 0;
    }

    public boolean fillBoard(int xIn, int yIn, int turnIn) {
        if (board[yIn][xIn] != " ") {
            System.out.println("SPOT ALREADY TAKEN");
            return false;
        }
        if (turnIn % 2 == 0) {

            board[yIn][xIn] = user1;
        } else {

            board[yIn][xIn] = user2;
        }
        return true;
    }

    public boolean threeInARow() {
        //left to right
        if ((board[0][0] == user1 && board[0][1] == user1 && board[0][2] == user1) || (board[0][0] == user2 && board[0][1] == user2 && board[0][2] == user2)) {
            threeInARow = true;
        }

        if ((board[1][0] == user1 && board[1][1] == user1 && board[1][2] == user1) || (board[1][0] == user2 && board[1][1] == user2 && board[1][2] == user2)) {
            threeInARow = true;
        }

        if ((board[2][0] == user1 && board[2][1] == user1 && board[2][2] == user1) || (board[2][0] == user2 && board[2][1] == user2 && board[2][2] == user2)) {
            threeInARow = true;
        }
        //vertical

        if ((board[0][0] == user1 && board[1][0] == user1 && board[2][0] == user1) || (board[0][0] == user2 && board[1][0] == user2 && board[2][0] == user2)) {
            threeInARow = true;
        }

        if ((board[0][1] == user1 && board[1][1] == user1 && board[2][1] == user1) || (board[0][1] == user2 && board[1][1] == user2 && board[2][1] == user2)) {
            threeInARow = true;
        }

        if ((board[0][2] == user1 && board[1][2] == user1 && board[2][2] == user1) || (board[0][2] == user2 && board[1][2] == user2 && board[2][2] == user2)) {
            threeInARow = true;
        }

        //diagonals

        if ((board[0][0] == user1 && board[1][1] == user1 && board[2][2] == user1) || (board[0][0] == user2 && board[1][1] == user2 && board[2][2] == user2)) {
            threeInARow = true;
        }

        if ((board[0][2] == user1 && board[1][1] == user1 && board[2][0] == user1) || (board[0][2] == user2 && board[1][1] == user2 && board[2][0] == user2)) {
            threeInARow = true;
        }

        if ((board[0][0] != " " && board[0][1] != " " && board[0][2] != " " && board[1][0] != " " && board[1][1] != " " && board[1][2] != " " && board[2][0] != " " && board[2][1] != " " && board[2][2] != " ")) {
            threeInARow = true;
        }

        return threeInARow;
    }
    public boolean threeInWin(String type) {
        //left to right
        if ((board[0][0] == type && board[0][1] == type && board[0][2] == type)) {
            threeInWin = true;
        }

        if ((board[1][0] == type && board[1][1] == type && board[1][2] == type)) {
            threeInWin = true;
        }

        if ((board[2][0] == type && board[2][1] == type && board[2][2] == type)) {
            threeInWin = true;
        }
        //vertical

        if ((board[0][0] == type && board[1][0] == type && board[2][0] == type)) {
            threeInWin = true;
        }

        if ((board[0][1] == type && board[1][1] == type && board[2][1] == type)) {
            threeInWin = true;
        }

        if ((board[0][2] == type && board[1][2] == type && board[2][2] == type)) {
            threeInWin = true;
        }

        //diagonals

        if ((board[0][0] == type && board[1][1] == type && board[2][2] == type)) {
            threeInWin = true;
        }

        if ((board[0][2] == type && board[1][1] == type && board[2][0] == type)) {
            threeInWin = true;
        }

        return threeInWin;
    }
    int[][] cords = {{10,10},{10,10}};
    int[][] fillCords = {{10,10}};
    //figures out if there is 2 in a row
    public boolean horizontal(String type){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (count == 0 && board[i][j].equals(type)) {
                    cords[0][0] = i;
                    cords[0][1] = j;

                    count++;
                }else if (count == 1 && board[i][j].equals(type)) {


                    cords[1][0] = i;
                    cords[1][1] = j;
                    if(cords[1][1] - cords[0][1] == 2){
                        fillCords[0][0] = cords[0][0];
                        fillCords[0][1] = cords[0][1] +1;
                    }else if(cords[1][1] == 2){
                        fillCords[0][0] = cords[0][0];
                        fillCords[0][1] = 0;
                    }else{
                        fillCords[0][0] = cords[1][0];
                        fillCords[0][1] = cords[1][1] +1;
                    }
                    if(board[fillCords[0][0]][fillCords[0][1]].equals(" ")) {

                        return true;
                    }else{
                        fillCords[0][0] = 10;
                        fillCords[0][1] = 10;
                        return false;
                    }
                }
                if (j == 2) {
                    count = 0;
                }
            }
        }
        return false;
    }
    public boolean vertical(String type) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (count == 0 && board[j][i].equals(type)) {
                    cords[0][0] = i;
                    cords[0][1] = j;
                    count++;
                } else if (count == 1 && board[j][i].equals(type)) {

                    cords[1][0] = i;
                    cords[1][1] = j;
                    if (cords[1][1] - cords[0][1] == 2) {

                        fillCords[0][1] = cords[1][0];
                        fillCords[0][0] = 1;
                    } else if (cords[1][1] == 2 && cords[0][1] == 1) {

                        fillCords[0][1] = cords[0][0];
                        fillCords[0][0] = 0;
                    } else {
                        fillCords[0][1] = cords[1][0];
                        fillCords[0][0] = 2;

                    }

                    if(board[fillCords[0][0]][fillCords[0][1]].equals(" ")) {
                        System.out.println(" " + fillCords[0][0] + " " + fillCords[0][1]);

                        return true;
                    }else{

                        fillCords[0][0] = 10;
                        fillCords[0][1] = 10;
                        return false;
                    }
                }
                if (j == 2) {
                    count = 0;
                }
            }
        }
        return false;
    }
    public boolean diagonals(String type) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (count == 0 && board[i][j].equals(type)&& i == j) {
                    cords[0][0] = i;
                    cords[0][1] = j;
                    count++;
                } else if (count == 1 && board[i][j].equals(type)&& i == j) {

                    cords[1][0] = i;
                    cords[1][1] = j;
                    if (cords[1][1] - cords[0][1] == 2 && cords[1][0] - cords[0][0] == 2) {
                        fillCords[0][0] = 1;
                        fillCords[0][1] = 1;
                    } else if (cords[1][1] == 2) {
                        fillCords[0][0] = 0;
                        fillCords[0][1] = 0;
                    } else {
                        fillCords[0][0] = 2;
                        fillCords[0][1] = 2;
                    }

                    if(board[fillCords[0][0]][fillCords[0][1]].equals(" ")) {

                        return true;
                    }else{
                        fillCords[0][0] = 10;
                        fillCords[0][1] = 10;
                        return false;
                    }
                }
            }
        }
        //diagonal going from right to left
        return false;
    }

    public boolean diagonalLeftRight(String type){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (count == 0 && board[i][j].equals(type)&& ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0))) {
                    cords[0][0] = i;
                    cords[0][1] = j;
                    count++;
                } else if (count == 1 && board[i][j].equals(type)&& ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0))) {

                    cords[1][0] = i;
                    cords[1][1] = j;
                    if (cords[1][1] - cords[0][1] == 2 && cords[1][0] - cords[0][0] == 2) {
                        fillCords[0][1] = 1;
                        fillCords[0][0] = 1;
                    } else if (cords[1][1] == 2) {
                        fillCords[0][1] = 2;
                        fillCords[0][0] = 0;
                    } else {
                        fillCords[0][1] = 0;
                        fillCords[0][0] = 2;
                    }

                    if(board[fillCords[0][0]][fillCords[0][1]].equals(" ")) {

                        return true;
                    }else{
                        fillCords[0][0] = 10;
                        fillCords[0][1] = 10;
                        return false;
                    }

                }
            }
        }
        return false;
    }
    public boolean twoInARow(String type){

        horizontal(type);
        if(!horizontal(type)) {
            vertical(type);
            if(!vertical(type)) {
                diagonals(type);
                if(!diagonals(type)){
                    diagonalLeftRight(type);
                    return false;
                }
            }
        }
        return true;
    }
    public void block(){
        twoInARow("X");
    }

    public boolean single(){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length;j++){
                if(((i == 0 && j == 0)||(i == 0 && j == 2)||(i == 2 && j == 0)||(i == 2 && j == 2)) && board[i][j].equals(" ") ){
                    fillCords[0][0] = i;
                    fillCords[0][1] =j;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cornerCase(){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length;j++){
                if(((i == 0 && j == 0)||(i == 0 && j == 2)||(i == 2 && j == 0)||(i == 2 && j == 2)) && board[i][j].equals("X") ){
                    fillCords[0][0] = 1;
                    fillCords[0][1] = 1;

                    if(board[fillCords[0][0]][fillCords[0][1]].equals(" ")){
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean leftSingle(){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length;j++){
                if(((i == 0 && j == 1)||(i == 1 && j == 0)||(i == 2 && j == 1)||(i == 1 && j == 2)) && board[i][j].equals(" ") ){
                    fillCords[0][0] = i;
                    fillCords[0][1] =j;

                    return true;
                }
            }
        }
        return false;
    }
    public void middle(){
        if(board[1][1].equals(" ")){
            fillCords[0][0] = 1;
            fillCords[0][1] = 1;
        }
    }
    public boolean doubleProng(){
        if((board[0][0].equals("X") && board[2][2].equals("X")) || (board[0][2].equals("X") && board[2][0].equals("X"))){
            leftSingle();
            return true;
        }
        return false;
    }
    public void AI() {
        if(twoInARow("O")){
            twoInARow("O");
        }else {
            block();
        }

        if(fillCords[0][0] == 10 || fillCords[0][1] == 10 || cords[0][0] == 10 || cords[1][0] == 10){

            if(doubleProng()){
                doubleProng();
            }else if(cornerCase()){
                cornerCase();
            }else if(!single()){
                middle();
            }else {
                single();
            }
            if(fillCords[0][0] == 10){
                leftSingle();
            }
            fillBoard(fillCords[0][1],fillCords[0][0], 1);
            return;
        }

        fillBoard(fillCords[0][1],fillCords[0][0], 1);
    }
}












