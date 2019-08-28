
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by sam on 6/24/19.
 */
public class AngryCows {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> hayBales = new ArrayList<>();

        for(int i = 0;i<n;i++){
            hayBales.add(sc.nextInt());
        }
        Collections.sort(hayBales);
        int max;
        int min;
        int maxCheck = 0;
        int blastRadius;
        int count;

        for(int i = 0;i<hayBales.size();i++){
            int startPos = hayBales.get(i);
            blastRadius = 1;
            min = startPos-blastRadius;
            max = startPos+blastRadius;

            int prevMax = hayBales.get(i);
            int prevMin = hayBales.get(i);
            boolean isMin = false;
            boolean isMax = false;

            while(true){
                for (int j = 0; j < hayBales.size(); j++) {
                    if (hayBales.get(j) >= min) {
                        min = hayBales.get(j);
                        break;
                    }
                }

                for (int j = hayBales.size() - 1; j >= 0; j--) {
                    if (hayBales.get(j) <= max) {
                        max = hayBales.get(j);
                        break;
                    }
                }

                if(prevMin == min && !isMin){
                    prevMin = min;
                    isMin = true;
                }
                if(isMin){
                    min = prevMin;
                }

                if(prevMax == max && !isMax){
                    isMax = true;
                    prevMax = max;
                }
                if(isMax ){
                    max = prevMax;
                }

                if(prevMin == min && prevMax == max){
                    break;
                }

                prevMax = max;
                prevMin = min;
                blastRadius++;
                min -= blastRadius;
                max += blastRadius;
            }
            count = 0;
            for (int j = 0; j < hayBales.size(); j++) {
                if (hayBales.get(j) >= min && hayBales.get(j) <= max) {
                    count++;
                }
            }

            if(count>maxCheck){
                maxCheck = count;
            }
        }
        System.out.println(maxCheck);
    }
}
