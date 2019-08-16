/*
ID: samduon1
LANG: JAVA
TASK: transform
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class transform {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new FileWriter("transform.out"));
        int n = sc.nextInt();
        char[][] before = new char[n][n];
        char[][] after = new char[n][n];
        for(int i = 0;i<n;i++){
            String s = sc.next();
            for(int j = 0;j<n;j++){
                before[i][j] = s.charAt(j);
            }
        }

        for(int i = 0;i<n;i++){
            String s = sc.next();
            for(int j = 0;j<n;j++){
                after[i][j] = s.charAt(j);
            }
        }

        if(Arrays.deepEquals(after,rotate90(before))){
            out.println(1);
        }else if(Arrays.deepEquals(after,rotate90(rotate90(before)))){
            out.println(2);
        }else if(Arrays.deepEquals(after,rotate90(rotate90(rotate90(before))))){
            out.println(3);
        }else if(Arrays.deepEquals(after,relfect(before))){
            out.println(4);
        }else if(Arrays.deepEquals(after,rotate90(relfect(before))) || Arrays.deepEquals(after,rotate90(rotate90(relfect(before)))) || Arrays.deepEquals(after,rotate90(rotate90(rotate90(relfect(before)))))){
            out.println(5);
        }else if(Arrays.deepEquals(after,before)){
            out.println(6);
        }else{
            out.println(7);
        }
        out.close();
    }

    public static char[][] rotate90(char[][] arr){
        char[][] out = new char[arr.length][arr.length];

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                out[i][j] = arr[arr.length-j-1][i];
            }
        }
        return out;
    }

    public static char[][] relfect(char[][] arr){
        char[][] out = new char[arr.length][arr.length];

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                out[i][j] = arr[i][arr.length-j-1];
            }
        }
        return out;
    }
}
