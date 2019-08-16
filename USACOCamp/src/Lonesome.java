import java.util.*;

/**
 * Created by sam on 6/10/19.
 */
public class Lonesome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<Integer,Integer[]> dict = new HashMap<>();
        HashMap<Double,Integer[]> dict1 = new HashMap<>();
        for(int i = 0;i<n;i++){
            StringTokenizer s = new StringTokenizer(sc.nextLine());
            Integer[] cord = {Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken())};
            dict.put(i+1,cord);
        }
        double distance = Double.MIN_VALUE;
        Integer[] out = new Integer[2];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(Math.sqrt(Math.pow((dict.get(i)[0] - dict.get(j)[0]),2)+Math.pow(dict.get(i)[1] - dict.get(j)[1],2))>distance && i!=j){
                    distance = Math.sqrt(Math.pow(dict.get(i)[0] - dict.get(j)[0],2)+Math.pow(dict.get(i)[1] - dict.get(j)[1],2));
                    Integer[] cordFinal = {i,j};
                    out=cordFinal;
                }
            }
        }

        System.out.println(out[0]+ " "+out[1]);


    }
}
