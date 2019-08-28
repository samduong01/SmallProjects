
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sam on 6/21/19.
 */
public class Times17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer s= new StringTokenizer(sc.nextLine());
        String n = s.nextToken();
        String n1 = "0000"+n;
        n = n+"0000";

        int[] out = new int[n1.length()];
        for(int i = n1.length()-1; i>=0;i--){
            out[i] = out[i]+Integer.parseInt(Character.toString(n.charAt(i)))+Integer.parseInt(Character.toString(n1.charAt(i)));
            if(out[i] >=2 && i!=0){
                out[i-1]+=1;
                out[i] =out[i]-2;
            }
        }

        for(int i = 0;i<out.length;i++){
            if(out[i]>=2){
                System.out.print("10");
                i++;
            }
            System.out.print(out[i]);
        }

    }

    private static String convertFromBaseToBase(String string, int fromBase, int toBase){
        return Integer.toString(Integer.parseInt(string, fromBase), toBase);
    }
}
