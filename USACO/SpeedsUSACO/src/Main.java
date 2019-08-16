/*
ID: samduon1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/Users/sam/Projects/SpeedsUSACO/src/asd.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/sam/Projects/SpeedsUSACO/src/asd.out")));
        int sum = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<10;i++){
            hashMap.put(Integer.parseInt(st.nextToken()),1);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<10;i++){
            hashMap.put(Integer.parseInt(st.nextToken()),1);
        }
        out.println((Math.fahashMap.size());
        out.close();
    }
}

