/*
ID: samduon1
LANG: JAVA
TASK: namenum
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/30/19.
 */
class namenum {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("namenum.in"));
        Scanner dict = new Scanner(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
        String num = sc.next();
        Vector<String> dictionary = new Vector<>();
        while(dict.hasNext()){
            dictionary.add(dict.next());
        }
        boolean isFound = false;
        for(int i = 0;i<dictionary.size();i++){
            boolean isF = false;
            if(dictionary.get(i).length() == num.length()) {
                System.out.println(dictionary.get(i));
                for (int j = 0; j < dictionary.get(i).length(); j++) {
                    int n = dictionary.get(i).charAt(j) - 'A';
                    char corr = '0';
                    if (n >= 0 && n <= 2) {
                        corr = '2';
                    } else if (n >= 3 && n <= 5) {
                        corr = '3';
                    } else if (n >= 6 && n <= 8) {
                        corr = '4';
                    } else if (n >= 9 && n <= 11) {
                        corr = '5';
                    } else if (n >= 12 && n <= 14) {
                        corr = '6';
                    } else if (n >= 15 && n <= 18) {
                        corr = '7';
                    } else if (n > 18 && n <= 21) {
                        corr = '8';
                    } else if (n >= 22 && n <= 24) {
                        corr = '9';
                    }
                    System.out.println(num.charAt(j) +  " "+ corr);

                    if (num.charAt(j) != corr) {
                        System.out.println("nope");

                        isF = true;
                    }

                }
                if(!isF){
                    System.out.println("printing");
                    out.println(dictionary.get(i));
                    isFound = true;
                }
            }
        }
        if(!isFound){
            out.println("NONE");
        }
        out.close();
    }
}
