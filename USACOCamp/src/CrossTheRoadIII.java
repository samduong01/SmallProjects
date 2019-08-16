import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/24/19.
 */
public class CrossTheRoadIII {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<CowCrossing> cows = new Vector<>();
        for(int i = 0;i<n;i++){
            cows.add(new CowCrossing(sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(cows, new Comparator<CowCrossing>() {
            @Override
            public int compare(CowCrossing o1, CowCrossing o2) {
                return o1.time-o2.time;
            }
        });
        int time = 0;
        for(int i = 0;i<cows.size()-1;i++){
            if(cows.get(i+1).time<cows.get(i).duration){
                int diff = cows.get(i+1).duration-cows.get(i+1).time;
                cows.get(i+1).time = cows.get(i).duration;
                cows.get(i+1).duration = cows.get(i+1).time+diff;
            }
            time+=cows.get(i).time+cows.get(i).duration;
        }
        System.out.println(cows.get(cows.size()-1).duration);
    }
}

class CowCrossing{
    int time;
    int duration;
    CowCrossing(int time, int duration){
        this.time = time;
        this.duration = duration+time;
    }
}
