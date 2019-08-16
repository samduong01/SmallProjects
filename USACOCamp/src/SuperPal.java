import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 6/10/19.
 */
public class SuperPal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int min = Integer.parseInt(sc.nextLine());

        boolean found = false;
        int i = min;
        while(!found){
            if(findDivisorsSum((findDivisorsSum(i)))==i){
                if(i!=findDivisorsSum(i)){
                    System.out.println(i + " " + findDivisorsSum(i));
                    found = true;
                }
            }
            i++;
        }
    }
    public static int findDivisorsSum(int n){
        int sum=0;
        ArrayList<Integer> out = new ArrayList<>();
        for(int i = 1;i<n;i++){
            if(n%i==0){
                out.add(i);
            }
        }
        for(int i = 0;i<out.size();i++){
            sum+=out.get(i);
        }
        return sum;
    }
}
