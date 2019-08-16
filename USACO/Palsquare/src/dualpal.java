/*
ID: samduon1
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

class dualpal {
    public static void main(String[] args) throws IOException{
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());


        String finalNum ="";
        int count = 0;
        int num = s+1;
        for(int i = 0;i<n;i++){

            for(int j = 2;j<=10;j++){
                finalNum = convertFromBaseToBase(Integer.toString(num), 10, j);
                System.out.println(finalNum+ " " + j);

                if(isPal(finalNum)){
                    count++;
                }
            }
            if(count>=2){
                out.println(finalNum);
            }else{
                i--;
            }
            count = 0;
            num++;
        }
        out.close();
    }
    private static boolean isPal(String num){
        return num.equals(new StringBuilder(num).reverse().toString());
    }

    private static String convertFromBaseToBase(String string, int fromBase, int toBase){
        return Integer.toString(Integer.parseInt(string, fromBase), toBase);
    }
}