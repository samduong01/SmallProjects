import java.util.Scanner;

/**
 * Created by sam on 6/20/19.
 */
public class Ride {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        if(product(sc.next())%47==product(sc.next())%47){
            System.out.println("GO");
        }else{
            System.out.println("STAY");
        }
    }

    public static int product(String s){
        int out = 1;
        for(int i = 0;i<s.length();i++){
            out*= (s.charAt(i)-'A')+1;
        }
        return out;
    }

}
