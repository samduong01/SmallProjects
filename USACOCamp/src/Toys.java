import java.util.*;

/**
 * Created by sam on 6/10/19.
 */
public class Toys {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<Double,Integer> dict = new HashMap<>();
        HashMap<Double,Integer> dict1 = new HashMap<>();
        ArrayList<Double> input = new ArrayList<>();
        ArrayList<Double> output = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<n;i++){
            StringTokenizer s = new StringTokenizer(sc.nextLine());
            input.add(Double.parseDouble(s.nextToken()));
            input.add(Double.parseDouble(s.nextToken()));
        }
        int k = 1;
        for(int i = 0; i<input.size()-1;i+=2){
            String s = Double.toString(input.get(i+1));
            String z = "";
            for(int j = 0;j<s.length()-2;j++){
                z= z+s.charAt(j);
            }
            output.add(input.get(i)/input.get(i+1));
            dict.put(input.get(i)/input.get(i+1)*1.0,k);
            dict1.put(input.get(i)/input.get(i+1)*1.0,Integer.parseInt(z));
            k++;
        }

        Collections.sort(output);

        System.out.println(dict1.get(output.get(output.size()-1))+dict1.get(output.get(output.size()-2))+dict1.get(output.get(output.size()-3)));
        System.out.println(dict.get(output.get(output.size()-1)));
        System.out.println(dict.get(output.get(output.size()-2)));
        System.out.println(dict.get(output.get(output.size()-3)));
    }
}


