import java.util.Scanner;

/**
 * Created by sam on 6/20/19.
 */
public class Echo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String one = sc.next();
        String two = sc.next();

        int max = Integer.MIN_VALUE;
        for(int i = 1;i<one.length()-1;i++){

            if(two.substring(1,two.length()).contains(one.substring(0,i)) && two.substring(1,two.length()).indexOf(one.substring(0,i))+1== two.length()-one.substring(0,i).length()){
                if(i>max){
                    max = i;
                }
            }
        }

        for(int i = 1;i<two.length()-1;i++){

            if(one.substring(1,one.length()).contains(two.substring(0,i)) && one.substring(1,one.length()).indexOf(two.substring(0,i))+1== one.length()-two.substring(0,i).length()){
                if(i>max){
                    max = i;
                }
            }
        }
        System.out.println(max);
    }
}
