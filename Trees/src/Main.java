import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by sam on 2/12/19.
 */
public class Main {
    public static void main(String[] args){
        int[] test = {-100,20,40,50,10,200,100};
        int[] test1 = {10,50,100,-20,500,1000,3};
        //check to see if comb of # from arrays can get 200
        //rule you can't use the same number twice
        Tree tree = new Tree(test,test1);

    }
}

class Tree{

    HashSet<Integer> poss = new HashSet<>();

    int[] data;
    int[] data1;

    LinkedList<Integer> list = new LinkedList<>();
    LinkedList<Integer> list1 = new LinkedList<>();

    public Tree(int[] data, int[] data1){
        this.data = data;
        this.data1 = data1;

        this.display(data);
        this.display(data1);

        for(int i = 0;i<data.length;i++){
            this.list.add(data[i]);
        }

        for(int i = 0;i<data1.length;i++){
            this.list1.add(data1[i]);
        }

        System.out.println("List: " + list);
        System.out.println("List 1: " + list1);
        Node nodeHead = new Node(list,list1,0);
    }

    public void display(int[] array){
        System.out.println("");
        System.out.print("{");
        for(int i = 0;i<array.length;i++){
            System.out.print(" " + array[i] + ", ");
        }
        System.out.print("}");
        System.out.println("");
    }

    public void determinePoss( ){

    }

    public class Node{
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();

        int depth;

        public Node( LinkedList<Integer> list, LinkedList<Integer> list1, int depth){
            this.list = list;
            this.list1 = list1;
            this.depth = depth;
            System.out.println("List: " + this.list);
            System.out.println("List 1:" + this.list1);
            System.out.println("Depth: " + this.depth);
            if(this.depth<7){
                System.out.println("List: " + this.list.pop());
                System.out.println("List1: " + this.list1.pop());

                new Node(this.list,this.list1,this.depth+1);
            }
        }
    }
}


