import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

class EvenDigits {

    public static void main(String args[]) {
        int count = 0;
        int i = 1;
        int r = 1;

        while(Math.pow(5,r) <= 141292800000.0){
            r++;
        }

        System.out.println(4*2*Math.pow(10,15)+3*2*Math.pow(10,14)+3*2*Math.pow(10,12)+3*2*Math.pow(10,11)+3*2*Math.pow(10,10)+2*Math.pow(10,9)+4*2*Math.pow(10,8)+2*2*Math.pow(10,7)+4*2*Math.pow(10,6)+2*Math.pow(10,5));

//        while(count<626) {
//            boolean isEven = true;
//            for (int j = 1; j < Math.pow(10, Integer.toString(i).length()); j *= 10) {
//                if (((i / j) % 10) % 2 != 0) {
//                    isEven = false;
//                }
//            }
//
//            if (isEven) {
//                System.out.println(i);
//                count++;
//            }
//            i++;
//        }
//
//        System.out.println(141292800000.0/5*10);
    }
}
