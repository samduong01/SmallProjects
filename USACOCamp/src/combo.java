/*
ID: samduon1
LANG: JAVA
TASK: combo
*/

import java.io.*;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 8/6/19.
 */
class combo {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new FileWriter("combo.out"));
        int n = sc.nextInt();
        Vector<Integer> farmerJohn = new Vector<>();
        Vector<Integer> master = new Vector<>();
        Vector<Vector<Integer>> johnPos = new Vector<>();
        Vector<Vector<Integer>> masterPos = new Vector<>();


        farmerJohn.add(sc.nextInt());
        farmerJohn.add(sc.nextInt());
        farmerJohn.add(sc.nextInt());
        master.add(sc.nextInt());
        master.add(sc.nextInt());
        master.add(sc.nextInt());

        for(int i = 0;i<3;i++){
            Vector<Integer> pos = new Vector<>();
            pos.add(((farmerJohn.get(i) -2 +n)%n == 0) ? n : (farmerJohn.get(i) -2 +n)%n);
            pos.add(((farmerJohn.get(i) -1 +n)%n == 0) ? n : (farmerJohn.get(i) -1 +n)%n);
            pos.add(farmerJohn.get(i));
            pos.add(((farmerJohn.get(i) +1 +n)%n == 0) ? n : (farmerJohn.get(i) +1 +n)%n);
            pos.add(((farmerJohn.get(i) +2 +n)%n == 0) ? n : (farmerJohn.get(i) +2 +n)%n);
            System.out.println(pos);
            johnPos.add(pos);
        }


        for(int i = 0;i<3;i++){
            Vector<Integer> pos = new Vector<>();
            pos.add(((master.get(i) -2 +n)%n == 0) ? n : (master.get(i) -2 + n )%n);
            pos.add(((master.get(i) -1 +n)%n == 0) ? n : (master.get(i) -1 +n)%n);
            pos.add(master.get(i));
            pos.add(((master.get(i) +1 +n)%n == 0) ? n : (master.get(i) +1 +n)%n);
            pos.add(((master.get(i) +2 +n)%n == 0) ? n : (master.get(i) +2 +n)%n);
            System.out.println(pos);
            masterPos.add(pos);
        }

        Vector<Vector<Integer>> combinations = new Vector<>();
        for(int i = 1; i <= n;i++){
            for(int j = 1; j<=n;j++){
                for(int k = 1;k<=n;k++){
                    if((johnPos.get(0).contains(i) && johnPos.get(1).contains(j) && johnPos.get(2).contains(k)) || (masterPos.get(0).contains(i) && masterPos.get(1).contains(j) && masterPos.get(2).contains(k))){
                        Vector<Integer> comb = new Vector<>();
                        comb.add(i);
                        comb.add(j);
                        comb.add(k);
                        combinations.add(comb);
                    }
                }
            }
        }
        System.out.println(combinations.size());
        out.println(combinations.size());
        out.close();
    }
}
