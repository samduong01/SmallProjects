
import java.util.*;

/**
 * Created by sam on 6/20/19.
 */
public class CrossTheRoad {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = 0;
        ArrayList<CowRoad> crossingPairs = new ArrayList<>();

        ArrayList<char[]> pairs = new ArrayList<>();
        for(int i = 0;i<26;i++){
            crossingPairs.add(new CowRoad((char)('A'+i)));
        }

        for(int i = 0;i<s.length();i++){
            crossingPairs.get(s.charAt(i)-'A').cords.add(i);
        }

        for(int i = 0;i<crossingPairs.size();i++){
            Collections.sort(crossingPairs.get(i).cords);
        }

        Collections.sort(crossingPairs, new Comparator<CowRoad>() {
            @Override
            public int compare(CowRoad o1, CowRoad o2) {
                return o1.cords.get(0)-o2.cords.get(0);
            }
        });

//        for(int i = 0;i<crossingPairs.size();i++){
//            System.out.println("Name: " + crossingPairs.get(i).name + " cords: " + crossingPairs.get(i).cords);
//        }
//        System.out.println("__________________________________");
        for(int i = 0;i<crossingPairs.size()-1;i++){
            for(int j = i+1;j<crossingPairs.size();j++){
                char[] buds = {crossingPairs.get(i).name,crossingPairs.get(j).name};
                Arrays.sort(buds);
                if(crossingPairs.get(i).cords.get(1)>=crossingPairs.get(j).cords.get(0) && ((crossingPairs.get(i).cords.get(1)>=crossingPairs.get(j).cords.get(1) && crossingPairs.get(i).cords.get(0)>=crossingPairs.get(j).cords.get(0)) || (crossingPairs.get(i).cords.get(1)<=crossingPairs.get(j).cords.get(1) && crossingPairs.get(i).cords.get(0)<=crossingPairs.get(j).cords.get(0))) && !pairs.contains(buds)){
//                    System.out.println("Name: " + crossingPairs.get(i).name + " cords: " + crossingPairs.get(i).cords);
//                    System.out.println("Name: " + crossingPairs.get(j).name + " cords: " + crossingPairs.get(j).cords);

                    count++;
                    pairs.add(buds);
                }
            }
        }

        System.out.println(count);
    }
}
class CowRoad{
    char name;
    ArrayList<Integer> cords = new ArrayList<>();

    CowRoad(char name){
        this.name = name;
    }
}
