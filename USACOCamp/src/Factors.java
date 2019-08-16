/**
 * Created by sam on 6/20/19.
 */
public class Factors {
    public static void main(String[] args){
        long product = 1;
        System.out.println(Math.pow(2,62));

        String s = "12";
        String s2 = "14";

        for(int i = 0;i<s.length();i++){

        }
        System.out.println(findDivisorsSum(product));
    }

    public static double findDivisorsSum(long n) {
        int count = 0;
        for(double i = 1;i<Math.sqrt(n);i++){

            if(n%i==0){
                count++;
            }
        }

        return count;
    }
}
