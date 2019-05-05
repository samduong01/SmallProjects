/*
ID: samduon1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main (String [] args) throws IOException {
        HashMap<String,Integer> alphbet = new HashMap<>();
        String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int commetValue = 1;
        int spaceShipValue = 1;
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        String st = f.readLine();
        // Get line, break into tokens

        for(int i = 0; i<26;i++){
            alphbet.put(letters[i],i+1);
        }

        String[] commet = st.split("(?!^)");

        st = f.readLine();
        // first integer
        String[] spaceShip = st.split("(?!^)");

        for(int i = 0; i<commet.length; i++){
            commetValue = alphbet.get(commet[i]) * commetValue;
        }

        for(int i = 0; i<spaceShip.length; i++){
            spaceShipValue = alphbet.get(spaceShip[i]) * spaceShipValue;
        }

        if((commetValue % 47) == (spaceShipValue % 47)){
            out.println("GO");
        }else{
            out.println("STAY");
        }
        // second integer
        // output result
        out.close();                                  // close the output file
    }
}

