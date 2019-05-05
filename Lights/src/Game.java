import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 8/29/17.
 */
public class Game {
    Lights[][] board = new Lights[5][5];
    String[][] objective = {{"X","O","O","O","X"},{"O","X","X","X","O"},{"O","X","X","X","O"},{"O","X","X","X","O"},{"X","O","O","O","X"}};
    String firstRow = "";
    String secondRow = "";
    String thirdRow = "";
    String fourthRow = "";
    String fifthRow = "";
    Lights[] stripA = new Lights[5];
    Lights[] stripB = new Lights[5];
    Lights[] stripC = new Lights[5];
    Lights[] stripD = new Lights[5];
    Lights[] stripE = new Lights[5];
    Lights[] strip1 = new Lights[5];
    Lights[] strip2 = new Lights[5];
    Lights[] strip3 = new Lights[5];
    Lights[] strip4 = new Lights[5];
    Lights[] strip5 = new Lights[5];
    String[] objectiveRows = new String[6];
    private static ArrayList<Lights> rawLights = new ArrayList<>();
    ArrayList<String> moves = new ArrayList<>();
    String gameMode = "";
    int points = 0;
    public void gameType(){
        Scanner sc = new Scanner(System.in);
        System.out.println("USER 1");
        System.out.println("enter a mode: easy, medium or hard");
        gameMode = sc.nextLine();
        System.out.println("You selected " + gameMode + " mode");
        if(gameMode.equals("hard")){
            randomizeBoard();
        }else if(gameMode.equals("medium")){
            objective();
        }

    }

    public void randomizeBoard(){
        for(int i = 0; i<5;i++){
            for(int j = 0; j<5;j++){
                double random = Math.random();
                if(random<0.5){
                    board[i][j].changeImage();
                }
            }
        }
    }

    String[] arrayHolder = {firstRow,secondRow,thirdRow,fourthRow,fifthRow};
    public void intialize(){
        int count = 0;
            for (int k = 0; k < 5; k++) {
                for (int j = 0; j < 5; j++) {

                    Lights light = new Lights("light" + k);
                    rawLights.add(light);
                    rawLights.get(count).setImage("O");
                    board[k][j] = rawLights.get(count);
                    count++;
                }
            }
    }

    public void fillBoard() {

        //fill strips
        for(int i = 0; i<5;i++){
            strip1[i] = board[0][i];
            strip2[i] = board[1][i];
            strip3[i] = board[2][i];
            strip4[i] = board[3][i];
            strip5[i] = board[4][i];
            stripA[i] = board[i][0];
            stripB[i] = board[i][1];
            stripC[i] = board[i][2];
            stripD[i] = board[i][3];
            stripE[i] = board[i][4];
        }
    }

    public void render() {
        for(int i = 0; i<5;i++) {
            if(gameMode.equals("medium")){
                System.out.println(arrayHolder[i] + "              " + objectiveRows[i]);
            }else{
                System.out.println(arrayHolder[i]);
            }
        }
    }
    public void update(){

        if(gameMode.equals("easy") || gameMode.equals("hard")){
            System.out.println("    A      B      C      D      E");
        }else{
            System.out.println("              Your board                                    Objective");
            System.out.println("    A      B      C      D      E                     A      B      C      D      E");
        }

        for(int i = 0; i<5;i++){
            if(i == 0){
                arrayHolder[i] = "1";
            }
            if(i == 1){
                arrayHolder[i] = "2";
            }
            if(i == 2){
                arrayHolder[i] = "3";
            }
            if(i == 3){
                arrayHolder[i] = "4";
            }
            if(i == 4){
                arrayHolder[i] = "5";
            }
            for(int j = 0; j<5; j++) {
                arrayHolder[i] = arrayHolder[i] + " | " + board[i][j].image + " | ";
            }
        }

    }

    public void user(){

        Scanner sc = new Scanner(System.in);
        System.out.println("USER 1");
        System.out.println("enter a row or collumn");
        String X = sc.nextLine();

        //board[1][1].changeImage();


        if (X.matches("[1-5]") || X.matches("[A,a,B,b,C,c,D,d,E,e]")) {
            //test A
            strips(X);
            System.out.println("changing... row/collumn " + X);

        } else {
            System.out.println("Invalid input");
        }
    }



    int count = 0;
    public void strips(String X) {
        if(X.equals("1") || X.equals("2") || X.equals("3") || X.equals("4") || X.equals("5")){
            int x = Integer.valueOf(X);
            changeRow(x);
            moves.add(X);
            count++;
        }else{
            count++;
            changeCol(X);
            moves.add(X);
        }
    }

    public void printStats(){
        System.out.print("You scored the objective, you changed rows/cols ");
        for(int i = 0; i < moves.size(); i++){
            System.out.print(moves.get(i) + ", ");
        }
        System.out.print("and it took you " + count + " tries");
    }

    public void changeCol(String collumn){
        int realCol = 0;
        if(collumn.equals("A") || collumn.equals("a")){
            realCol=0;
        }else if(collumn.equals("B")|| collumn.equals("b")){
            realCol=1;
        }else if(collumn.equals("C")|| collumn.equals("c")){
            realCol=2;
        }else if(collumn.equals("D")|| collumn.equals("d")){
            realCol=3;
        }else if(collumn.equals("E")|| collumn.equals("e")){
            realCol=4;
        }
        for(int i = 0; i<5;i++){
            board[i][realCol].changeImage();
        }
    }

    public void changeRow(int row){
        row = row-1;
        for(int i = 0; i<5;i++){
            board[row][i].changeImage();
        }
    }

    public void objective(){
        objectiveRows[0] = "1 | X |  | O |  | O |  | O |  | X | ";
        objectiveRows[1] = "2 | O |  | X |  | X |  | X |  | O | ";
        objectiveRows[2] = "3 | O |  | X |  | X |  | X |  | O | ";
        objectiveRows[3] = "4 | O |  | X |  | X |  | X |  | O | ";
        objectiveRows[4] = "5 | X |  | O |  | O |  | O |  | X | ";
    }

    public boolean objectiveScored(){
        boolean isobjectiveScored = false;
        for(int i = 0; i<5;i++){
            for(int j = 0; j<5;j++){
                if(board[i][j].image.equals(objective[i][j])){
                    points++;
                }else{
                    points = 0;
                }
            }
        }
        if(points == 25){
            isobjectiveScored = true;
        }else{
            isobjectiveScored = false;
        }

        return isobjectiveScored;
    }
}


