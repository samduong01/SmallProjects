import java.util.Scanner;

/**
 * Created by sam on 8/14/19.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Character choice;
        CowFrame c;

        //gets user input and figures out if the user wants to change the cows default location
        System.out.println("Do you want to change the cow's default location? Enter Y (Yes) or N (No)");

        //takes user input and makes it uppercase so if the user enters a lower case it will still work
        choice = Character.toUpperCase(sc.next().charAt(0));

        if(choice == 'Y'){
            System.out.println("Enter X cordinate [space] Y cordinate");

            //initializes c using the constructor that takes in the users x and y
            c = new CowFrame(sc.nextInt(),sc.nextInt());
        }else{
            //initializes c using the constructor that uses the default x and y values
            c = new CowFrame();
        }

        c.setDefaultCloseOperation(CowFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
    }
}
