import java.util.ArrayList;

/**
 * Created by sam on 7/16/17.
 */
import java.util.Scanner;
public class Factorial {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);



        double amount = 0;
        for(int i = 0; i<2; i++){
            System.out.println("enter amount");
            double money = sc.nextInt();
            //do long addition
            //take a  string and manually  do long division by 2


            amount = amount + money;
        }
        double nonRound = amount/2;
        System.out.println("your amount is $" + Math.round(nonRound * 100.0) / 100.0);







    }

}
