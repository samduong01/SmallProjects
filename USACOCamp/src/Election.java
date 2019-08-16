import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/14/19.
 */
public class Election {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<ElectionCow> results = new ArrayList<>();
        for(int i = 0;i<n;i++){
            results.add(new ElectionCow(sc.nextInt(),sc.nextInt(),i+1));
        }

        Collections.sort(results, new Comparator<ElectionCow>() {
            @Override
            public int compare(ElectionCow o1, ElectionCow o2) {
                return o2.a-o1.a;
            }
        });


        results.subList(k,results.size()).clear();
        Collections.sort(results, new Comparator<ElectionCow>() {
            @Override
            public int compare(ElectionCow o1, ElectionCow o2) {
                return o2.b-o1.b;
            }
        });
        System.out.println(results.get(0).id);
    }
}

class ElectionCow{
    int a;
    int b;
    int id;

    public ElectionCow(int a, int b, int id){
        this.a = a;
        this.b = b;
        this.id = id;
    }
}
