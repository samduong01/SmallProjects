import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by sam on 6/13/19.
 */
public class Diamonds {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        ArrayList<Integer> a= new ArrayList<>();
        for(int i = 0;i<n;i++){
            a.add(sc.nextInt());
        }

        Collections.sort(a);
        int max = -1;

            for (int i = 0; i < a.size() - 1; i++) {
                count = 0;
                for (int j = i + 1; j < a.size(); j++) {
                    if (a.get(j) - a.get(i) <= k && a.get(i+1)-a.get(i)<=k) {
                        count++;
                    }
                }
                if(count>max){
                    max=count;
                }
            }


        System.out.println(max+1);
    }
}
