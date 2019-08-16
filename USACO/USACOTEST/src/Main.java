/*
ID: samduon1
LANG: JAVA
TASK: shell
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/Users/sam/Projects/USACOTEST/src/asd.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/sam/Projects/USACOTEST/src/asd.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<length;i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> sorted = new ArrayList<>(arrayList);
        Collections.sort(sorted);

        int count = 0;

        if(arrayList.equals(sorted)){
            out.println(0);
            out.close();
            return;
        }

        while(!arrayList.equals(sorted)){
            System.out.println(arrayList);
            if(arrayList.get(0) == 1){
                for(int j = length-1;j>=1;j--){
                    if(arrayList.get(j) >1 && arrayList.get(j-1)<1){
                        arrayList.add(j,arrayList.get(0));
                        arrayList.remove(0);
                        break;
                    }else{
                        if(j==1){
                            arrayList.add(arrayList.get(0));
                            arrayList.remove(0);
                        }
                    }
                }
            }else{
                int count2 = 0;

                for(int j = 0;j<length;j++){
                    if(arrayList.get(0)-1==count2){
                        if(arrayList.get(j) - 1 == arrayList.get(0)){
                            arrayList.add(j,arrayList.get(0));
                            arrayList.remove(0);
                            break;
                        }
                    }else if(arrayList.get(j)<arrayList.get(0)){
                        count2++;
                    }

                }
            }
            count++;
        }
        out.println(count);
        out.close();
    }
}
