import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/28/19.
 */
public class SleepyCow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<Integer> cowsSorted = new Vector<>();
        Vector<Integer> cows = new Vector<>();
        for(int i = 0;i<n;i++){
            int in = sc.nextInt();
            cows.add(in);
            cowsSorted.add(in);
        }
        Collections.sort(cowsSorted);

        if(cowsSorted.equals(cows)){
            System.out.println(0);
            return;
        }

        for(int i = n-1;i>0;i--){
            if(cows.get(i)<cows.get(i-1)){
                System.out.println(i);
                break;
            }
        }
    }
}
