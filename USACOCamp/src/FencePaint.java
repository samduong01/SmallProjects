import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 6/18/19.
 */
public class FencePaint {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = 0;
        int position = 0;
        int layers = 0;

        int[] leftInterval = new int[n];
        int[] rightInterval = new int[n];

        for(int i = 0;i<n;i++){
            int distance = sc.nextInt();
            String direction = sc.next();

            int intialPos = position;

            if(direction.equals("R")){
                position+=distance;
            }else{
                position-=distance;
            }
        }
    }
}

class CowMove{
    int distance;
    String direction;

    CowMove(int distance, String direction){
        this.distance = distance;
        this.direction = direction;
    }
}