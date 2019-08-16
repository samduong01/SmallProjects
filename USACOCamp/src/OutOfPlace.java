import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/26/19.
 */
public class OutOfPlace {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Vector<Integer> cows = new Vector<>();

        for(int i = 0;i<n;i++){
            cows.add(sc.nextInt());
        }
        Vector<Integer> original = new Vector<>(cows);
        int count = 0;
        Collections.sort(cows);

        for(int i = 0;i<original.size();i++){
            if(!original.get(i).equals(cows.get(i))){
                count++;
            }
        }

        System.out.println(count-1);
    }
}
