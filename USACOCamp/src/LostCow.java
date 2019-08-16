import java.util.Scanner;

/**
 * Created by sam on 6/17/19.
 */
public class LostCow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int goTo = 1;
        int distance = 0;
        int farmer = 0;
        int farmer0 = sc.nextInt();
        int bessie = sc.nextInt()-farmer0;
        if(bessie <0){
            while (farmer >bessie) {
                distance += Math.abs(goTo - farmer);
                farmer = goTo;
                goTo *= -2;
            }
        }else {
            while (farmer < bessie) {
                distance += Math.abs(goTo - farmer);
                farmer = goTo;
                goTo *= -2;
            }
        }

        distance-= Math.abs(farmer-bessie);
        System.out.println(distance);
    }
}
