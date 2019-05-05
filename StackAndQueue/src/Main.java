import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by sam on 3/26/19.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(6);
        linkedList.add(5);



        linkedList.remove(0);
        queue.add(5);

        queue.add(6);
        queue.add(7);
        queue.add(-100);

        queue.add(-4);

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i= 0;i<40;i++){
            hashSet.add((int)(Math.random()*i));
        }

        System.out.println(hashSet);

        Iterator<Integer> iterator = hashSet.iterator();
        hashSet.removeAll(hashSet);

        System.out.println(hashSet);

        while(iterator.hasNext()){
            int i = iterator.next();
            System.out.print(i+ " ");

        }

        System.out.println(hashSet);


        System.out.println(queue);
    }
}
