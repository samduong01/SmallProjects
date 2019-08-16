/*
ID: samduon1
LANG: JAVA
TASK: revegetate
*/

import java.io.*;
import java.util.*;

public class revegetate {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Cow> arrayLists = new ArrayList<>();

        int pastures = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        int[] arrayOfPastures = new int[pastures];

        for(int i = 0;i<pastures;i++){
            arrayOfPastures[i] = 1;
        }

        for(int i = 0;i<lines;i++){
            for (int p = 0; p < arrayOfPastures.length; p++) {
                System.out.println(arrayOfPastures[p]);
            }
            st = new StringTokenizer(br.readLine());
            int firstElement = Integer.parseInt(st.nextToken());
            int secondElement = Integer.parseInt(st.nextToken());
            Cow cow;
            if(firstElement<secondElement){
                cow = new Cow(firstElement,secondElement);
            }else{
                cow = new Cow(secondElement,firstElement);
            }
            arrayLists.add(cow);
        }

        Collections.sort(arrayLists, new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                if(o1.getFirst()<o2.getFirst()){
                    return -1;
                }else if(o1.getFirst()>o2.getFirst()){
                    return 1;
                }else {
                    return 0;
                }
            }
        });


        for(int j = 0;j<pastures;j++) {
            for (int i = 0; i < pastures; i++) {
                if (arrayOfPastures[arrayLists.get(i).getFirst() - 1] == arrayOfPastures[arrayLists.get(i).getSecond() - 1]) {
                    if (arrayOfPastures[arrayLists.get(i).getSecond() - 1] > 4) {
                        arrayOfPastures[arrayLists.get(i).getSecond() - 1] = arrayOfPastures[arrayLists.get(i).getSecond() - 1] - 1;
                    } else {
                        arrayOfPastures[arrayLists.get(i).getSecond() - 1] = arrayOfPastures[arrayLists.get(i).getFirst() - 1] + 1;
                    }
                }
            }
        }

        for(int i = 0;i<arrayOfPastures.length;i++){
            out.print(arrayOfPastures[i]);
        }
        out.close();
    }
}

class Cow{
    int first;
    int second;

    public Cow(int first, int second){
        this.first = first;
        this.second = second;
    }

    public int getFirst(){
        return first;
    }

    public int getSecond(){
        return second;
    }
}
