import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sam on 6/10/19.
 */
public class Symmetry {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer s = new StringTokenizer(sc.nextLine());

        int n = Integer.parseInt(s.nextToken());
        int m = Integer.parseInt(s.nextToken());

        int sum = 0;
        int count = 1;
        while(n!=2 && n%2!=0 && m!=2 && m%2!=0){
            sum+=count;
            n = (n-1)/2;
            m = (m-1)/2;
            count*=4;
        }

        System.out.println(sum);
    }
}
