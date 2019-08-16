import java.util.*;

/**
 * Created by sam on 6/10/19.
 */
public class NotLast {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String,Integer> dict = new HashMap<>();
        ArrayList<Integer> vals = new ArrayList<>();
        for(int i = 0;i<n;i++){
            StringTokenizer s = new StringTokenizer(sc.nextLine());
            String name = s.nextToken();
            Integer value = Integer.parseInt(s.nextToken());
            if(dict.get(name)==null){
                dict.put(name,0);
            }
            dict.put(name,dict.get(name)+value);
            if(n==1){
                System.out.println(name);
                return;
            }
        }

        for(Integer i: dict.values()){
            vals.add(i);
        }
        Collections.sort(vals);
        int min = vals.get(0);
        int count= 0;
        boolean foundSecond = false;
        String finalName = "";
        for(int i = 0;i<vals.size();i++){
            if(vals.get(i)>min && !foundSecond){
                for(String s: dict.keySet()){
                    if(dict.get(s) == vals.get(i)){
                        finalName = s;
                        count++;
                        break;
                    }
                }
                foundSecond = true;
                min = vals.get(i);
                continue;
            }

            if(vals.get(i)==min && foundSecond){
                count++;
            }
        }
        if(count==1){
            System.out.println(finalName);
        }else{
            System.out.println("Tie");
        }
    }
}
