import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

/**
 * Created by sam on 6/20/19.
 */
public class WrongDirection {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0;i<input.length();i++){
            String s = input;

            for(int j = 0;j<3;j++){
                Character currChar = s.charAt(j);
                if(list.get(j) != currChar){

                }
            }
        }


    }
}
