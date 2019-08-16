import java.util.*;

/**
 * Created by sam on 6/14/19.
 */
public class Landmarks {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<Integer> landMarkPos = new ArrayList<>();
        for(int i = 0;i<n;i++){
            landMarkPos.add(sc.nextInt());
        }

        Collections.sort(landMarkPos, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int count = 1;
        int sum = landMarkPos.get(0);

        for(int i = 1;i<n;i++){
            sum += Math.abs(landMarkPos.get(i) - landMarkPos.get(i-1));
            if(sum>time){
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}
