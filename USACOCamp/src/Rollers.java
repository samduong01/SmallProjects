import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/26/19.
 */
public class Rollers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Vector<Roller> rollers = new Vector<>();
        for(int i = 0;i<n;i++){
            rollers.add(new Roller(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(rollers, new Comparator<Roller>() {
            @Override
            public int compare(Roller o1, Roller o2) {
                return (int)((Math.pow(o1.x,2)+Math.pow(o1.y,2))-(Math.pow(o2.x,2)+Math.pow(o2.y,2)));
            }
        });
        int i, j, min_idx;

        for (i = 0; i < n-1; i++)
        {
            min_idx = i;
            for (j = i+1; j < n; j++) {
                if(Math.sqrt(Math.pow(rollers.get(j).x-rollers.get(i).x,2)+Math.pow(rollers.get(j).y-rollers.get(i).y,2))==rollers.get(j).r+rollers.get(i).r){
                    min_idx =j;
                }
            }
            Roller temp = rollers.get(i+1);
            rollers.set(i+1,rollers.get(min_idx));
            rollers.set(min_idx,temp);
        }

        System.out.println(rollers.get(rollers.size()-1).x + " " + rollers.get(rollers.size()-1).y);

    }
}

class Roller{
    int x;
    int y;
    int r;
    Roller(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
