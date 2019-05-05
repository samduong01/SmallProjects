/*
ID: samduon1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        HashMap<Integer,Integer> days = new HashMap<>();
        int currentYear = 1900;
        int yearRange = Integer.parseInt(f.readLine());
        int fridayDay = 1;
        for(int i = 0; i<7;i++){
            days.put(i,0);
        }
        for(int i = 0; i<yearRange;i++) {
            if(currentYear!=1900){
                fridayDay = (fridayDay + 3)%7;
            }
            for (int j = 1; j < 13; j++){
                if(j==2||j == 4||j == 6||j == 9||j == 11||j == 8){
                    fridayDay = (fridayDay+3)%7;
                }else if(j == 5||j == 7||j == 10||j == 12){
                    fridayDay = (fridayDay+2)%7;
                }else if(j == 3){
                    if(currentYear%100 == 0){
                        if(currentYear%400 == 0){
                            fridayDay = (fridayDay+1)%7;
                        }else{
                            days.put(fridayDay,days.get(fridayDay)+1);
                            continue;
                        }
                    }else if(currentYear%4 == 0){
                        fridayDay = (fridayDay+1)%7;
                    }
                }else if(j ==1&&currentYear == 1900){
                    fridayDay = 0;
                }
                days.put(fridayDay,days.get(fridayDay)+1);
            }
            currentYear++;
        }
        out.print(days.get(0) + " " + days.get(1) + " " + days.get(2) + " " + days.get(3) + " " + days.get(4) + " " + days.get(5) + " " + days.get(6));
        out.println("");
        out.close();
    }
}


