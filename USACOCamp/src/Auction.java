import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/25/19.
 */
public class Auction {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] a = new Integer[m];

        for(int i = 0;i<m;i++){
            a[i] = sc.nextInt();
        }


        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int max = Integer.MIN_VALUE;
        int maxRev = 0;

        for(int i = 0;i<m;i++){
            int currSum = (i+1)*a[i];
            if(currSum>max && i<n){
                max = currSum;
                maxRev = a[i];
            }
        }
        System.out.println(maxRev + " "+max);
    }
}
