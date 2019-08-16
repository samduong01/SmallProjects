import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 5/17/19.
 */
public class Board {
    String board[][] = new String[10][10];
    String user1 = "R";
    String user2 = "B";
    int col = 0;
    boolean turn = false;
    int redCount = 0;
    int blackCount = 0;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Board(){
        clearBoard();
    }

    public void clearBoard(){
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                board[i][j] = " ";
            }
        }
    }

    public void displayBoard(){
        System.out.println(" 0 1 2 3 4 5 6 7 8 9");
        System.out.println("---------------------");
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j].equals("R")){
                    System.out.print(ANSI_BLACK+"|"+ANSI_RED+board[i][j]+ANSI_RED+ANSI_BLACK);
                }else{
                    System.out.print(ANSI_BLACK+"|"+board[i][j]+ANSI_BLACK);
                }

            }
            System.out.println("|");
            System.out.println("---------------------");
        }
    }

    public void userUpdateBoard(){
        for(int i = 0;i<10;i++){
            if(board[i][col] != " "){
                board[i-1][col] = ANSI_RED+"R"+ANSI_RED;
                break;
            }
            if(i==9){
                board[9][col] = "R";
            }
        }
    }

    public void AIUpdateBoard(){
        for(int i = 0;i<10;i++){
            if(board[i][col] != " "){
                board[i-1][col] = ANSI_BLACK+"B"+ANSI_BLACK;
                break;
            }
            if(i==9){
                board[9][col] = ANSI_BLACK+"B"+ANSI_BLACK;
            }
        }
    }

    public void getUserInput(){
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        try{
            col = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("INVALID INPUT");
        }

        if(col >=0 && col<=9 && board[0][col].equals(" ")){
            isValid = true;
        }else{
            System.out.println("INVALID INPUT");
            isValid = false;
        }

        if(!isValid){
            getUserInput();
        }
    }

    public boolean foundConnect4(){
        redCount = 0;
        blackCount = 0;
        String pastCase = " ";

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){

                if(board[i][j] != " "){
                    if(board[i][j] == pastCase){
                        if(board[i][j] == "R"){
                            redCount++;
                        }else if(board[i][j] == "B"){
                            blackCount++;
                        }
                    }else{
                        pastCase = board[i][j];
                        if(board[i][j] == "R"){
                            redCount= 1;
                            blackCount =0;
                        }else if(board[i][j] == "B"){
                            blackCount =1 ;
                            redCount =0;
                        }
                    }
                }else{
                    pastCase = " ";
                    redCount = 0;
                    blackCount = 0;
                }


                if(redCount == 4|| blackCount == 4){
                    return true;
                }
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){

                if(board[j][i] != " "){
                    if(board[j][i] == pastCase){
                        if(board[j][i] == "R"){
                            redCount++;
                        }else if(board[j][i] == "B"){
                            blackCount++;
                        }
                    }else{
                        pastCase = board[j][i];
                        if(board[j][i] == "R"){
                            redCount= 1;
                            blackCount =0;
                        }else if(board[j][i] == "B"){
                            blackCount =1 ;
                            redCount =0;
                        }
                    }
                }else{
                    pastCase = " ";
                    redCount = 0;
                    blackCount = 0;
                }


                if(redCount == 4|| blackCount == 4){
                    return true;
                }
            }
        }
        int dim = 9;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){

                if(board[j][i] != " "){
                    if(board[j][i] == pastCase){
                        if(board[j][i] == "R"){
                            redCount++;
                        }else if(board[j][i] == "B"){
                            blackCount++;
                        }
                    }else{
                        pastCase = board[j][i];
                        if(board[j][i] == "R"){
                            redCount= 1;
                            blackCount =0;
                        }else if(board[j][i] == "B"){
                            blackCount =1 ;
                            redCount =0;
                        }
                    }
                }else{
                    pastCase = " ";
                    redCount = 0;
                    blackCount = 0;
                }


                if(redCount == 4|| blackCount == 4){
                    return true;
                }
            }
        }


        for( int k = 0 ; k < dim * 2 ; k++ ) {
            for( int j = 0 ; j <= k ; j++ ) {
                int i = k - j;
                if( i < dim && j < dim ) {
                    if(board[j][i] != " "){
                        if(board[j][i] == pastCase){
                            if(board[j][i] == "R"){
                                redCount++;
                            }else if(board[j][i] == "B"){
                                blackCount++;
                            }
                        }else{
                            pastCase = board[j][i];
                            if(board[j][i] == "R"){
                                redCount= 1;
                                blackCount =0;
                            }else if(board[j][i] == "B"){
                                blackCount =1 ;
                                redCount =0;
                            }
                        }
                    }else{
                        pastCase = " ";
                        redCount = 0;
                        blackCount = 0;
                    }


                    if(redCount == 4|| blackCount == 4){
                        return true;
                    }
                }
            }
        }
        int j = 3;
        for(int r = 3;r<10;r++) {
            j = r;
            String a = "";
            for (int i = 0; i <= r; i++) {
                a+=board[i][j];
                j--;
            }
            if(a.contains("BBBB")){
                blackCount = 4;
                return true;
            }else if(a.contains("RRRR")){
                redCount = 4;
                return true;
            }
        }
        for(int r = 1;r<7;r++) {
            j = 9;
            String a = "";
            for (int i = r; i < 10; i++) {
                a+=board[i][j];
                j--;
            }
            if(a.contains("BBBB")){
                blackCount = 4;
                return true;
            }else if(a.contains("RRRR")){
                redCount = 4;
                return true;
            }
        }


        for(int r = 6;r>=0;r--) {
            j = r;
            String a = "";
            for (int i = 0; i <= 9-r; i++) {
                a+=board[i][j];


                j++;
            }
            if(a.contains("BBBB")){
                blackCount = 4;
                return true;
            }else if(a.contains("RRRR")){
                redCount = 4;
                return true;
            }
        }

        for(int r = 6;r>=1;r--) {
            j = 0;
            String a = "";
            for (int i = r; i < 10; i++) {
                a+=board[i][j];

                j++;
            }
            if(a.contains("BBBB")){
                blackCount = 4;
                return true;
            }else if(a.contains("RRRR")){
                redCount = 4;
                return true;
            }
        }
        return false;
    }

    public void runGame(){
        clearBoard();
        displayBoard();

        while(!foundConnect4()){
            getUserInput();
            userUpdateBoard();
            displayBoard();
            if(foundConnect4()){
                break;
            }
            getUserInput();
            AIUpdateBoard();
            displayBoard();
        }
        if(redCount == 4){
            System.out.println("RED WON!");
        }else{
            System.out.println("BLACK WON!");
        }
    }


}
