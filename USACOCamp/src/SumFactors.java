import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 6/12/19.
 */
public class SumFactors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next()+".0";
        System.out.println(Math.pow(2,62));
        System.out.println(Math.pow(2,62)%100);
        System.out.println(findDivisors(Double.parseDouble(s)));

    }

    public static double findDivisors(Double n) {
        int count = 0;
        for(double i = 1;i<Math.sqrt(n);i++){
            if(n%i==0){
                count++;
            }
        }
        return count;
    }
}
