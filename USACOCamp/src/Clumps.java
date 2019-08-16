
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 6/12/19.
 */
public class Clumps {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();


        int count = 0;
        String curr = ".";
        String[][] board = new String[row][col];

        for(int i = 0;i<row;i++){
            String s = sc.next();
            for(int j = 0;j<col;j++){
                board[i][j] = Character.toString(s.charAt(j));
            }
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                String x = board[i][j];
                if(x.equals("#")) {
                    if(x.equals(curr)){
                        curr = "#";
                    }else if(i!=0 && board[i - 1][j].equals("#")) {
                        curr="#";
                    }else {
                        count++;
                    }
                    curr="#";
                }else{
                    curr = ".";
                }

            }
        }
        System.out.println(count);
    }
}
