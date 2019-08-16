import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/24/19.
 */
public class Speeding {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int lawLines = sc.nextInt();
        int bessieLines = sc.nextInt();

        Vector<Integer> law = new Vector<>();
        Vector<Integer> bessie = new Vector<>();
        for(int i = 0;i<lawLines;i++){
            int length = sc.nextInt();
            int speed = sc.nextInt();
            for(int j = 0;j<length;j++){
                law.add(speed);
            }
        }

        for(int i = 0;i<bessieLines;i++){
            int length = sc.nextInt();
            int speed = sc.nextInt();
            for(int j = 0;j<length;j++){
                bessie.add(speed);
            }
        }
        int max = 0;
        for(int i = 0;i<bessie.size();i++){
            int dif = bessie.get(i)-law.get(i);

            if(dif>max){
                max = dif;
            }
        }

        System.out.println(max);

    }
}
