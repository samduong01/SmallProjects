/*
ID: samduon1
LANG: JAVA
TASK: barn1
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
/**
 * Created by sam on 7/2/19.
 */
class barn1 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new FileWriter("barn1.out"));

        int max = sc.nextInt();
        int n = sc.nextInt();
        int cows = sc.nextInt();

        Vector<Integer> gapSizes = new Vector<>();

        int[] stalls = new int[cows];

        for(int i = 0;i<cows;i++){
            stalls[i] = sc.nextInt();
        }
        Arrays.sort(stalls);

        int clusters = 0;
        int lengthOut = cows;
        for(int i = 0;i<stalls.length-1;i++){
            if(stalls[i+1] - stalls[i] > 1){
                clusters++;
                gapSizes.add(stalls[i+1]-stalls[i]-1);
            }
        }

        Collections.sort(gapSizes);
        clusters += 1;
        for(int i = 0;i<clusters-max;i++){
            lengthOut+= gapSizes.get(i);
        }
        out.println(lengthOut);
        out.close();
    }
}


