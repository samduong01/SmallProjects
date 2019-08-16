/*
ID: samduon1
LANG: JAVA
TASK: sleepy
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/Users/sam/Projects/Dec3rdProblem/src/asd.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/sam/Projects/Dec3rdProblem/src/asd.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer bt = new StringTokenizer(br.readLine());
        int totalBarn1 = 1000;
        int toalBarn2 = 1000;
        int[] barn1 = new int[10];
        int[] barn2 = new int[10];
        for(int i = 0;i<10;i++){
            barn1[i] = Integer.parseInt(st.nextToken());
            barn2[i] = Integer.parseInt(bt.nextToken());

        }
        out.println();
        out.close();
    }
}

class Tree{
    Tree left;
    Tree right;
    int value;

    public Tree(int value){
        this.value = value;

    }
}
