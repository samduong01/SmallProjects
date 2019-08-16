import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/14/19.
 */
public class Marathon {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CowRun[] cows = new CowRun[n];

        for(int i = 0;i<n;i++){
            CowRun cow = new CowRun(sc.nextInt(),sc.nextInt(),sc.nextInt());
            cows[i] = cow;
        }

        Arrays.sort(cows, new Comparator<CowRun>() {
            @Override
            public int compare(CowRun o1, CowRun o2) {
                if(o1.hour>o2.hour){
                    return 1;
                }else if(o1.hour<o2.hour){
                    return -1;
                }else{
                    if(o1.min>o2.min){
                        return 1;
                    }else if(o1.min<o2.min){
                        return -1;
                    }else{
                        if(o1.sec>o2.sec){
                            return 1;
                        }else if(o1.sec <o2.sec){
                            return -1;
                        }else{
                            return 0;
                        }
                    }
                }
            }
        });

        for(int i = 0;i<n;i++) {
            System.out.println(cows[i].hour + " " + cows[i].min+ " "+ cows[i].sec);
        }
    }
}

class CowRun{
    int hour, min, sec;
    public CowRun(int hour, int min, int sec){
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
}
