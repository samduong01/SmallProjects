/*
ID: samduon1
LANG: JAVA
TASK: skidesign
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class skidesign {
    public static void main(String[] args) throws IOException {
        Scanner sc;
        PrintWriter out;
        boolean debug = true;
        if(debug) {
            sc = new Scanner(new FileReader("/Users/samduong/Projects/MakerProjects/USACOCamp/src/skidesign.in"));
            out = new PrintWriter(new FileWriter("/Users/samduong/Projects/MakerProjects/USACOCamp/src/skidesign.out"));
        }else{
            sc = new Scanner(new FileReader("wormhole.in"));
            out = new PrintWriter(new FileWriter("wormhole.out"));
        }

        int n = sc.nextInt();
        Integer[] hills = new Integer[][n];
        for(int i = 0;i<n;i++){
            hills[i] = sc.nextInt();
        }

        Arrays.sort(hills);

        double lowCost = Double.MIN_VALUE;
        double highCost = Double.MAX_VALUE;

        LinkedList<Integer[]> linkedList = new LinkedList<>();
        linkedList.add(hills);
        Integer[] b = new Integer[linkedList.get(linkedList.size()-1).length];
        b[b.length-1]--;
        linkedList.add(b);
        while(highCost-lowCost>17){
            Integer[] a = new Integer[linkedList.get(linkedList.size()-1).length];

            a = Arrays.copyOf(linkedList.get(linkedList.size()-1), linkedList.get(linkedList.size()-1).length);

            for(int i = 0;i<linkedList.get(linkedList.size()-1).length;i++){
                if(linkedList.get(linkedList.size()-1)[i] != linkedList.get(linkedList.size()-2)[i]){

                    int lowCount = 0;
                    if(linkedList.get(linkedList.size()-1)[i] == linkedList.get(linkedList.size()-1)[0]){
                        for(int j = 0;j<=i;j++){
                            a[j]++;
                            lowCount+= Math.pow(linkedList.get(linkedList.size()-2)[j],2) - Math.pow(linkedList.get(linkedList.size()-1)[j],2);
                        }
                    }else{

                    }
                }
            }

            lowCost = Math.pow(hills[0],2) - (Math.pow(hills[0]-1,2));
            highCost = (Math.pow(hills[hills.length-1]+1,2)) - Math.pow(hills[hills.length-1],2);

            if(hills[0] == hills[1]){
                lowCost +=
            }

            if(hills[hills.length-1] == hills[hills.length-2]){

            }
        }
    }
}
