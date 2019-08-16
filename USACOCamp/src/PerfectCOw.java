import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sam on 6/26/19.
 */
public class PerfectCOw {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] finalArr = new int[n];
        int[] row = new int[n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                row[j] = sc.nextInt();
            }
            Arrays.sort(row);
            finalArr[i] = row[n/2];
        }
        Arrays.sort(finalArr);
        System.out.println(finalArr[n/2]);
    }
}
