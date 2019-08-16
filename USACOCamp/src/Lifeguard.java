import java.util.*;

/**
 * Created by sam on 6/18/19.
 */
public class Lifeguard {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer[]> cords = new ArrayList<>();

        for(int i = 0;i<n;i++){
            Integer[] a = {sc.nextInt(),sc.nextInt()};
            cords.add(a);
        }

        Collections.sort(cords, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0]- o2[0];
            }
        });
        int maxTime = Integer.MIN_VALUE;
        int currTime = 0;
        ArrayList<Integer[]> oringial = new ArrayList<>(cords);

        for(int i = 0;i<cords.size();i++){
            cords.remove(i);
            int[] array = new int[1000];
            for(int j = 0;j<cords.size();j++){
                for(int r = cords.get(j)[0];r<cords.get(j)[1];r++){
                    array[r] = 1;
                }
            }
            for(int p = 0;p<1000;p++){
                if(array[p] == 1){
                    currTime++;
                }
            }
            if(currTime>maxTime){
                maxTime = currTime;
            }

            currTime = 0;
            cords = new ArrayList<>(oringial);
        }

        System.out.println(maxTime);
    }
}
