import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sam on 6/21/19.
 */
public class ConvertToDecimal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        System.out.println(binaryToDecimal(n,10));
    }

    public static String decimalToBinary(int n, int base){
        StringBuilder s = new StringBuilder();
        String out = "";
        while(n > 0)
        {
            int rem = n % base;
            out = out + "" + rem;

            n = n / base;
        }
        s.append(out);
        return s.reverse().toString();
    }

    public static int binaryToDecimal(String n,int base){
        int out = 0;
        int i = 0;
        int l = n.length();
        do{
            int x = Integer.parseInt(n.substring(n.length()-1,n.length()));
            out += x* Math.pow(base,i);
            i++;
            n = n.substring(0,n.length()-1);

        }while(n.length()>=1);
        return out;
    }

    private static String convertFromBaseToBase(String string, int fromBase, int toBase){
        return Long.toString(Long.parseLong(string, fromBase), toBase);
    }
}
