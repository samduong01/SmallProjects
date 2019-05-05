/*
ID: samduon1
LANG: JAVA
TASK: teleportation
*/
import java.io.*;
import java.util.*;

class test {
    public static void main (String [] args) throws IOException {
        ArrayList<Integer> cows = new ArrayList<>();
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("/Users/sam/Projects/test USACO/src/hoofball.in"));
        // input file name goes above
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
    
        
        // Get line, break into tokens
          // second integer
        StringTokenizer dt = new StringTokenizer(f.readLine());
        int countCows = Integer.parseInt(st.nextToken());
        ArrayList<Integer> originCow = new ArrayList<>();
        int totalCount = 0;
        for(int i = 0; i<countCows;i++){
            int currentIndex = Integer.parseInt(dt.nextToken());
            cows.add(currentIndex);
            originCow.add(currentIndex);
            if(cows.get(i).equals(originCow.get(i))){
                totalCount++;
            }
        }
        Collections.sort(cows);

        int count = 0;
        int currentDif = Integer.MAX_VALUE;
        boolean isPrechecked = false;

        if(originCow.equals(cows)){
            count = 1;
        }else if(countCows == 1 || countCows ==2){
            count = 1;
        }else {
            while (!cows.isEmpty() && cows.size() != 1) {

                if (cows.get(1) - cows.get(0) < currentDif) {
                    currentDif = cows.get(1) - cows.get(0);
                    cows.remove(0);
                    if(cows.size() == 1 && isPrechecked){
                        count++;
                        break;
                    }
                } else if (cows.get(1) - cows.get(0) == currentDif) {
                    if (originCow.indexOf(cows.get(0) - (cows.get(1) - cows.get(0))) < originCow.indexOf(cows.get(1))) {
                        currentDif = Integer.MAX_VALUE;
                        isPrechecked = true;
                        count++;
                    } else {
                        cows.remove(0);
                    }
                } else {
                    currentDif = Integer.MAX_VALUE;
                    isPrechecked = false;
                    count++;
                }
            }
        }
        if(count == 0 && cows.size() == 1){
            count=1;
        }
        System.out.println(count);
//        out.println(count);
//        out.close();
    }



    //input array
    //output array

    public int[] logicProblem(int[] array){

    }


}
