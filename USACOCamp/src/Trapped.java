import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/26/19.
 */
public class Trapped {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<HayBaleTrap> hayBales = new Vector<>();

        for(int i = 0;i<n;i++){
            hayBales.add(new HayBaleTrap(sc.nextInt(),sc.nextInt()));
        }

        Collections.sort(hayBales, new Comparator<HayBaleTrap>() {
            @Override
            public int compare(HayBaleTrap o1, HayBaleTrap o2) {
                return o1.pos-o2.pos;
            }
        });

        int count = 0;

        for(int i = 0;i<hayBales.size()-1;i++){
            int left = i;
            int right = i+1;
            while(left>=0 && right<hayBales.size()){
                boolean isBreakout = false;
                int distance = hayBales.get(right).pos-hayBales.get(left).pos;
                if(distance>hayBales.get(left).height){
                    left--;
                    isBreakout = true;
                }

                if(distance>hayBales.get(right).height){
                    right++;
                    isBreakout = true;
                }

                if(!isBreakout){
                    break;
                }
            }
            if(left>=0 && right<hayBales.size()){
                count+= hayBales.get(i+1).pos-hayBales.get(i).pos;
            }
        }


        System.out.println(count);


    }
}

class HayBaleTrap{
    int pos;
    int height;
    HayBaleTrap(int height, int pos){
        this.pos = pos;
        this.height = height;
    }
}
