import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/11/19.
 */
public class Suffle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        Co[] cows = new Co[n];
        for(int i = 0;i<n;i++){
            input[i] = sc.nextInt();
        }

        for(int i = 0;i<n;i++){
            cows[i] = new Co(sc.nextInt(),i);
        }
        for(int r = 0;r<3;r++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
//                    System.out.println(input[i]);
//                    System.out.println(cows[j].pos+1+" "+cows[j].id);
                    if (input[i] == (cows[j].pos + 1)) {
                        cows[j].pos = i;
                        break;
                    }
                }
            }
        }
        Arrays.sort(cows, new Comparator<Co>() {
            @Override
            public int compare(Co o1, Co o2) {
                if(o1.pos>o2.pos){
                    return 1;
                }else if(o1.pos<o2.pos){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        for(int i = 0;i<cows.length;i++){
            System.out.println(cows[i].id);
        }
    }
}

class Co{
    int id;
    int pos;
    public Co(int id,int pos){
        this.id = id;
        this.pos = pos;
    }

    public void setPos(int pos){
        this.pos = pos;
    }
}
