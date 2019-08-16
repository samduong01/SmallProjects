import java.util.Scanner;

/**
 * Created by sam on 6/12/19.
 */
public class DigitCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int starting = sc.nextInt();
        int ending = sc.nextInt();
        long[] digits = new long[10];
        for(long i = starting;i<ending+1;i++){
            for(long j = 1; j< Math.pow(10,Long.toString(i).length());j*=10){
//                System.out.println("num:"+i+" dividng:"+j+" digit:"+(i/j)%10);
                long digit = (i/j)%10;
//                System.out.println(digit);
//                System.out.println(digit1);
                digits[(int)digit]++;
            }
        }
        for(int i = 0;i<10;i++){
            System.out.print(digits[i]+" ");
        }
    }
}
