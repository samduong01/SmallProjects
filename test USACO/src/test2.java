/**
 * Created by sam on 2/25/18.
 */
/*
ID: samduon1
LANG: JAVA
TASK: teleportation
*/
import java.io.*;
import java.util.*;

class test2 {
    public static void main (String [] args) throws IOException {
        ArrayList<Integer> cows = new ArrayList<>();
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("/Users/sam/Projects/test USACO/src/hoofball.in"));
        // input file name goes above
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        int countCows = Integer.parseInt(st.nextToken());

        // Get line, break into tokens
        // second integer
        StringTokenizer dt = new StringTokenizer(f.readLine());
        for(int i = 0; i<countCows;i++){
            int currentIndex = Integer.parseInt(dt.nextToken());
            cows.add(currentIndex);
        }
        int mostRecent =0;
        int countMin = 1;
        int countMax = 0;
        for(int i = 0; i< cows.size();i++){
            if(cows.get(i) != -1){
                mostRecent = cows.get(i);
                countMin++;
            }
            if(cows.get(i) == -1){
                countMax++;
            }
        }


        System.out.println(countMin + " " + countMax);
//        out.println(countMin + " " + countMax);
//        out.close();
    }
}

