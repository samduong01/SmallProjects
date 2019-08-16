import java.util.*;

/**
 * Created by sam on 6/18/19.
 */
public class FencePainting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer[] firstCord = {sc.nextInt(),sc.nextInt()};
        Integer[] secondCord = {sc.nextInt(),sc.nextInt()};
        ArrayList<Integer[]> a = new ArrayList<>();
        a.add(firstCord);
        a.add(secondCord);

        Collections.sort(a, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0]-o2[0];
            }
        });

        if(a.get(0)[1]>a.get(1)[1] && a.get(0)[0]<a.get(1)[0]){
            System.out.println(a.get(0)[1]-a.get(0)[0]);
        }else if(a.get(1)[0]>a.get(0)[1]){
            System.out.println(firstCord[1]-firstCord[0]+secondCord[1]-secondCord[0]);
        }else{
            System.out.println(a.get(1)[1]-a.get(0)[0]);
        }

    }
}
