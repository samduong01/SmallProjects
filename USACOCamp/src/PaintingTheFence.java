import javafx.geometry.Pos;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by sam on 6/19/19.
 */
public class PaintingTheFence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        ArrayList<Position> sorted = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int pos= 0;

        for(int i = 0;i<n;i++){
            int distance = sc.nextInt();
            String direction = sc.next();
            if(direction.equals("R")) {
                Integer[] cord = {pos,pos+distance};
                Arrays.sort(cord);
                start.add(cord[0]);
                end.add(cord[1]);
                pos+=distance;
            }else{
                Integer[] cord = {pos,pos-distance};
                Arrays.sort(cord);
                start.add(cord[0]);
                end.add(cord[1]);
                pos-=distance;
            }
        }


        Collections.sort(start);
        Collections.sort(end);
        for(int i = 0;i<start.size();i++){
            sorted.add(new Position("s",start.get(i)));
            sorted.add(new Position("e",end.get(i)));
        }

        Collections.sort(sorted, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.val<o2.val){
                    return -1;
                }else if(o1.val>o2.val){
                    return 1;
                }else{
                    if(o1.startOrEnd.equals(o2.startOrEnd)){
                        return 0;
                    }else if(o1.startOrEnd.equals("s")){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }
        });





        int prevLayers = 0;
        int currLayers = 0;

        int prevPos = 0;
        int currPos = 0;
        int answer = 0;
        for(int i = 0;i<sorted.size();i++ ){

            prevLayers = currLayers;

            prevPos = currPos;

            currPos = sorted.get(i).val;

            if(sorted.get(i).startOrEnd.equals("s")){
                currLayers++;
            }else{
                currLayers--;
            }

            if(prevLayers>=k){
                answer+=Math.abs(prevPos-currPos);
            }
        }

        System.out.println(answer);
    }
}

class Position{
    String startOrEnd;
    int val;
    Position(String startOrEnd, int val){
        this.startOrEnd = startOrEnd;
        this.val = val;
    }
}
