import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 6/11/19.
 */
public class MinieMoe {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numCows = sc.nextInt();
        int n = sc.nextInt();
        int[] elimSequence = new int[n];
        ArrayList<Integer> circle = new ArrayList<>();
        for(int i = 0;i<n;i++){
            elimSequence[i] = sc.nextInt();
        }

        for(int i = 0;i<numCows;i++){
            circle.add(i+1);
        }

        int i = 0;
        int currIndex = 0;
        while(circle.size()!=1){
            currIndex=((elimSequence[i]+currIndex)-1)%(circle.size());

            circle.remove(((currIndex)));
            i=(i+1)%elimSequence.length;
        }
        System.out.println(circle.get(0));
    }
}
