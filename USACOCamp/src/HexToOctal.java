import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sam on 6/21/19.
 */
public class HexToOctal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        System.out.println(binaryToOctal(hexToBinary(n)));
    }

    private static String hexToBinary(String n){
        StringBuilder out = new StringBuilder();

        String[] arr = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        for(int i = 0;i<n.length();i++){
            String base2= "";
            if(Character.isLetter(n.charAt(i))){
                base2 = arr[n.charAt(i)-'A'+10];
            }else {
                base2 = arr[Integer.parseInt(Character.toString(n.charAt(i)))];
            }
            out.append(base2);
        }
        return out.toString();
    }

    private static String binaryToOctal(String n){
        StringBuilder out = new StringBuilder();

        if(n.length()%3!=0){
            if(n.length()%3==1){
                n = "00"+n;
            }else{
                n = "0" + n;
            }
        }

        for(int i = 0;i<n.length()-2;i+=3){

            if(n.substring(i,i+3).equals("000") && i==0) {
                continue;
            }

            out.append(convertFromBaseToBase(n.substring(i, i + 3), 2,10));
        }

        return out.toString();
    }

    private static String convertFromBaseToBase(String string, int fromBase, int toBase){
        return Long.toString(Long.parseLong(string, fromBase), toBase);
    }
}
