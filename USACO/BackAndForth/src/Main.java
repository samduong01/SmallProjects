import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by sam on 1/29/19.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/Users/sam/Projects/BackAndForth/src/asd.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Vector<Integer> tank1 = new Vector();
        Vector<Integer> tank2 = new Vector();

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i = 0;i<10;i++){
            tank1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<10;i++){
            tank2.add(Integer.parseInt(st.nextToken()));
        }
        Tree tree = new Tree(tank1.get(0));

        for(int i = 0;i<tank1.size();i++){
            tree.setLeft(new Tree(tank1.get(i)));
            tree.setRight(new Tree(tank2.get(i)));
        }


    for(int y = 0;y<10000;y++) {
        for (int i = 0; i < 10; i++) {
            Vector<Integer> tank1test = new Vector(tank1);
            Vector<Integer> tank2test = new Vector(tank2);

            tank2test.add(tank1test.get(i));
            tank1test.remove(tank1test.get(i));
            //day 2
            tank1test.add(tank2test.get(i));
            tank2test.remove(tank2test.get(i));

            tank2test.add(tank1test.get(i));
            tank1test.remove(tank1test.get(i));

            int count = 1000;
            for (int x = 0; x < tank1test.size(); x++) {
                count += tank1test.get(x);
            }
            hashMap.put(count, 1);

        }
    }
        System.out.println(tank1);
        System.out.println(tank2);
        System.out.println(hashMap.keySet());
    }

    public void tuesday(){

    }

    public void wednesday(){

    }
}

class Tree{
    Tree left;
    Tree right;
    int root;
    public Tree(int root){
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public void setLeft(Tree left){
        this.left = left;
    }

    public void setRight(Tree right){
        this.right = right;
    }
}

