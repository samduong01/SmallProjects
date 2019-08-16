import java.util.Scanner;

/**
 * Created by sam on 6/28/19.
 */
public class RADAR {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(!isPalindrome(Integer.toString(n))){
            StringBuilder s = new StringBuilder();
            s.append(n);
            s = s.reverse();
            n= n + Integer.parseInt(s.toString());
            count++;
        }
        System.out.println(count + " " + n);
    }
    public static boolean isPalindrome(String n){
        StringBuilder s = new StringBuilder();
        s.append(n);
        if(s.reverse().toString().equals(n)){
            return true;
        }else{
            return false;
        }
    }
}
