import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("/Users/sam/Projects/BackAndForthUSACO/src/asd.in"));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/sam/Projects/BackAndForthUSACO/src/asd.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] barnAClean = new int[10];
        int[] barnBClean = new int[10];
        int incrementer = 0;

        while (st.hasMoreTokens() ){

            int n = Integer.parseInt(st.nextToken());
            barnAClean[incrementer] = n;

            incrementer++;
        }

        incrementer = 0;
        StringTokenizer st0 = new StringTokenizer(f.readLine());
        while (st0.hasMoreTokens() ){

            int n = Integer.parseInt(st0.nextToken());
            barnBClean[incrementer] = n;

            incrementer++;

        }

        Tree tree0 = new Tree(barnAClean, barnBClean);

        out.print(tree0.readings.size());
        out.println("");

        f.close();
        out.close();
    }
}

class Tree {

    HashSet <Integer> readings = new HashSet <Integer>();
    LinkedList< Integer> init_A = new LinkedList<>();
    LinkedList< Integer> init_B = new LinkedList<>();

    boolean debug = true;

    public Tree( int[] bucketArr0, int[] bucketArr1) {
        for (int i = 0; i < 10; i++){
            init_A.add( bucketArr0[i] );
            init_B.add( bucketArr1[i]  );
        }

        HashSet<Integer> options = this.reportUniqueOptions(init_A);

        for ( int key : options ){
            new Node(init_A, init_B, 1, key, 1000, 1000);
        }
    }

    public HashSet<Integer> reportUniqueOptions( LinkedList<Integer> targetList) {
        HashSet <Integer> unique = new HashSet<Integer>();

        for (int i = 0; i < targetList.size(); i++) {

            if (unique.contains(targetList.get(i))) {
                continue;
            }
            unique.add(targetList.get(i));
        }
        return unique;
    }

    class Node {
        LinkedList< Integer> sys_A = new LinkedList<>();
        LinkedList< Integer> sys_B = new LinkedList<>();

        int depth;

        int tankALevel;
        int tankBLevel;

        HashSet< Integer > unique = new HashSet<Integer>();

        String name;

        boolean debug = true;

        public Node ( LinkedList<Integer> inputSystemA, LinkedList<Integer> inputSystemB, int depth, int selection, int tankALevel, int tankBLevel ) {
            this.depth = depth;

            this.tankALevel = tankALevel;
            this.tankBLevel = tankBLevel;

            this.name = "0x" + Integer.toString(this.depth) + Integer.toString(selection);

            for (int i = 0; i < inputSystemA.size(); i++){
                sys_A.add(inputSystemA.get(i));
            }

            for (int i = 0; i < inputSystemB.size(); i++){
                sys_B.add(inputSystemB.get(i));
            }

            if (this.depth == 1){
                this.transferMilk(0, 1, selection);

                this.reportUniqueOptions(this.sys_B);


                for ( int key : this.unique){
                    new Node(sys_A, sys_B, 2, key, this.tankALevel, this.tankBLevel);
                }
            }

            if (this.depth == 2){
                this.transferMilk(1, 0, selection);

                this.reportUniqueOptions(this.sys_A);

                for ( int key : this.unique){
                    new Node(sys_A, sys_B, 3, key, this.tankALevel, this.tankBLevel);
                }
            }

            if (this.depth == 3){
                this.transferMilk(0, 1, selection);

                this.reportUniqueOptions(this.sys_B);

                for ( int key : this.unique){
                    new Node(sys_A, sys_B, 4, key, this.tankALevel, this.tankBLevel);
                }
            }


            if (this.depth == 4){
                this.transferMilk(1, 0, selection);

                if (!readings.contains(this.tankALevel)){
                    readings.add(this.tankALevel);
                }
            }
        }

        public void transferMilk (int tankFrom, int tankTo, int amount) {
            int element;
            long startTime = System.nanoTime();
            if ( tankFrom == 0){
                this.tankALevel -= amount;
                this.tankBLevel += amount;

                element = this.sys_A.indexOf(amount);
                this.sys_B.add(amount);
                this.sys_A.remove(element);

            } else {
                this.tankBLevel -= amount;
                this.tankALevel += amount;

                element = this.sys_B.indexOf(amount);
                this.sys_A.add(amount);
                this.sys_B.remove(element);
            }
            long endTime = System.nanoTime();
            System.out.println(endTime-startTime);
        }

        public HashSet<Integer> reportUniqueOptions(LinkedList<Integer> targetList) {
            for (int i = 0; i < targetList.size(); i++){
                if ( this.unique.contains(targetList.get(i))){
                    continue;
                }

                this.unique.add(targetList.get(i));
            }
            return unique;
        }
    }
}