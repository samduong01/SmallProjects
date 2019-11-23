/*
ID: samduon1
LANG: JAVA
TASK: skidesign
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class skidesign {
    public static void main(String[] args) throws IOException {
        Scanner sc;
        PrintWriter out;
        boolean debug = false;
        if(debug){
            sc = new Scanner(new FileReader("/Users/samduong/Projects/MakerProjects/USACOCamp/src/skidesign.in"));
            out = new PrintWriter(new FileWriter("/Users/samduong/Projects/MakerProjects/USACOCamp/src/skidesign.out"));
        }else{
            sc = new Scanner(new FileReader("skidesign.in"));
            out = new PrintWriter(new FileWriter("skidesign.out"));
        }

        int n = sc.nextInt();
        int[] hills = new int[n];
        for (int i=0; i<n; i++){
            hills[i] = sc.nextInt();
        }
        int mincost=Integer.MAX_VALUE;
        for (int i=0; i<=83; i++){
            int cost=0,x;
            for (int j=0; j<n; j++)
            {
                if (hills[j]<i) {
                    x = i - hills[j];
                }else if (hills[j]>i+17) {
                    x = hills[j] - (i + 17);
                }else {
                    x = 0;
                }
                cost+=x*x;
            }
            mincost=Math.min(mincost,cost);
        }

        out.println(mincost);
        out.close();
    }
}
