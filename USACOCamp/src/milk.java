/*
ID: samduon1
LANG: JAVA
TASK: namenum
*/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 7/2/19.
 */
class milk {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new FileWriter("milk.out"));
        int amount = sc.nextInt();
        int n = sc.nextInt();
        Vector<Farmer> farmers = new Vector<>();
        for(int i = 0;i<n;i++){
            farmers.add(new Farmer(sc.nextInt(),sc.nextInt()));
        }

        Collections.sort(farmers, new Comparator<Farmer>() {
            @Override
            public int compare(Farmer o1, Farmer o2) {
                return o1.price - o2.price;
            }
        });

        int currAmount = 0;
        int currPrice = 0;
        int i = 0;
        while (currAmount!= amount && i<farmers.size()){
            System.out.println(farmers.get(i).price + " " + farmers.get(i).units);
            if(amount-currAmount>=farmers.get(i).units) {
//                System.out.println("here");
                currAmount += farmers.get(i).units;
                currPrice += farmers.get(i).units * farmers.get(i).price;
            }else{
//                System.out.println("here 2");

                currPrice += (amount - currAmount)*farmers.get(i).price;
                currAmount = amount;
            }
//            System.out.println("PRICES " + currPrice + " " + currAmount);
            i++;
        }
        out.println(currPrice);
        out.close();
    }
}

class Farmer{
    int price;
    int units;

    Farmer(int price, int units){
        this.price = price;
        this.units = units;
    }
}
