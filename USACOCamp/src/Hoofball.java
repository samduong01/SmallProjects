import java.util.*;

/**
 * Created by sam on 6/25/19.
 */
public class Hoofball {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> cows = new ArrayList<>();

        cows.add(-100000);
        cows.add(-100000);
        for(int i = 0;i<n;i++){
            cows.add(sc.nextInt());
        }

        Vector<Integer> nonPassed = new Vector<>();

        Vector<Integer> passTo = new Vector<>();
        Collections.sort(cows);

        cows.add(100000);
        cows.add(100000);
        for(int i = 2;i<cows.size()-2;i++){
            if(cows.get(i+1)-cows.get(i)>=cows.get(i)-cows.get(i-1)){
                passTo.add(i-1);
            }else{
                passTo.add(i+1);
            }
        }
        for(int j = 2;j<cows.size()-2;j++) {
            if(!passTo.contains(j)){
                nonPassed.add(j);
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0;i<nonPassed.size();i++){
            int currentPos = nonPassed.get(i);
            for(int j = 0;j<cows.size();j++){
                hashSet.add(currentPos);
                if(cows.get(currentPos+1)-cows.get(currentPos)>=cows.get(currentPos)-cows.get(currentPos-1)){
                    currentPos--;
                }else{
                    currentPos++;

                }
            }
        }

        System.out.println(nonPassed.size() + ((cows.size()-4)-hashSet.size()) / 2);


    }
}
