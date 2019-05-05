/*
ID: samduon1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

public class beads {
    static int usacoLength;

    public static void main(String[] args) throws IOException{
        int largestBlue = 0;
        int largestRed = 0;
        int largestWhite = 0;
        int sum = 0;
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        usacoLength = Integer.parseInt(f.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        String orginalString = f.readLine();
        int count = 0;
        String usacoTest = dupString(orginalString);
        usacoLength = usacoTest.length();
        String workWith = "";

        for(int i = 0; i<usacoTest.length();i++){

            String rightString = rightScan(i,usacoTest);
            String leftString = leftScan(i,usacoTest);

            if(rightString.length()>orginalString.length()){
                rightString = rightString.substring(0,orginalString.length()-1);
            }
            if(leftString.length()>orginalString.length()){
                leftString = leftString.substring(0,orginalString.length()-1);
            }

            if(leftString.length() + rightString.length() > largestBlue+largestRed ){
                if(findStringType(leftString) == 'r'){
                    largestRed = leftString.length();
                    if(findStringType(rightString) != 'b'){
                        largestBlue = 0;
                    }else {
                        largestBlue = rightString.length();
                    }
                }else if(findStringType(leftString) == 'b'){
                    largestBlue = leftString.length();
                    if(findStringType(rightString) !='r'){
                        largestRed = 0;
                    }else{
                        largestRed = rightString.length();
                    }
                }
            }

            if(usacoTest.charAt(i) == 'w'){
                count++;
            }
            if(count == usacoTest.length()){
                largestRed = usacoTest.length()/2;
            }

        }
        sum = largestBlue+largestRed;
        if(sum>orginalString.length()){
            sum = orginalString.length();
        }
        out.println(sum);
        out.close();
    }



    public static char findStringType(String string){
        char type = ' ';
        for(int i = 0; i<string.length();i++){
            if(string.charAt(i) != 'w'){
                type = string.charAt(i);
                return string.charAt(i);
            }
        }
        return type;
    }

    public static String leftScan(int target, String string){
        char nonW = 'w';
        String stringFinal ="";
        int oneTimeCheck = 0;
        int count = 0;
        for(int i = target; i>=0; i--){
            if(Math.abs(target-(i-1)) > string.length()/2){
                break;
            }
            if(string.charAt(i) != 'w' && oneTimeCheck == 0){
                nonW = string.charAt(i);
                oneTimeCheck++;
            }
            if(string.charAt(i) == nonW || string.charAt(i) == 'w'){
                stringFinal = stringFinal+string.charAt(i);
                count++;
            }else{
                System.out.println(stringFinal);
                break;
            }

        }
        return stringFinal;
    }

    public static String rightScan(int target, String string){
        String stringFinal = "";
        char nonW = 'w';
        int oneTimeCheck = 0;
        int count = 0;
        for(int i = target+1; i<string.length(); i++){
            if(Math.abs(target-i) > string.length()/2){
                break;
            }
            if(string.charAt(i) != 'w' && oneTimeCheck == 0){
                nonW = string.charAt(i);
                oneTimeCheck++;
            }
            if(string.charAt(i) == nonW || string.charAt(i) == 'w'){
                stringFinal = stringFinal+string.charAt(i);
                count++;
            }else{
                System.out.println(stringFinal);
                break;
            }

        }
        return stringFinal;
    }

    public static String dupString(String string){
        String result;
        result = string+string;
        return result;
    }
}
