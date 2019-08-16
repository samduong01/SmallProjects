import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/21/19.
 */
public class Belts {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int pulleys = sc.nextInt();

        ArrayList<Belt> beltArrayList = new ArrayList<>();
        for(int i = 0;i<pulleys-1;i++){
            beltArrayList.add(new Belt(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }

        boolean isClockwise = true;
        Collections.sort(beltArrayList, new Comparator<Belt>() {
            @Override
            public int compare(Belt o1, Belt o2) {
                return o1.source-o2.source;
            }
        });

        for(int i = 0;i<beltArrayList.size();i++){
            if(beltArrayList.get(i).direction == 1){
                isClockwise = !isClockwise;
            }
        }
        if(isClockwise){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }
}

class Belt{
    int source;
    int des;
    int direction;
    Belt(int source, int des, int direction){
        this.source = source;
        this.des = des;
        this.direction = direction;
    }
}
