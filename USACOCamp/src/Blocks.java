import java.util.*;

/**
 * Created by sam on 6/10/19.
 */
public class Blocks {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<Character,Integer> dict = new HashMap<>();
        ArrayList<String> input = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<n;i++){
            input.add(sc.nextLine());
        }

        for(int i = 97;i<123;i++){
            char c = (char) i;
            dict.put(c,0);
        }
        for(int i = 0;i<input.size();i++){
            String s = input.get(i);
            ArrayList<Character> word = new ArrayList<>();

            s= simplify(s);
            for(int j = 0;j<s.length();j++){
                word.add(s.charAt(j));
            }


            for(int j = 0;j<word.size();j++){
                dict.put(word.get(j), dict.get(word.get(j)) + 1);
            }

        }

        for(int i = 97;i<123;i++){
            char c = (char) i;
            System.out.println(dict.get(c));

        }

    }

    public static String simplify(String s){
        String out = "";
        String firstHalf = "";
        String second = "";
        boolean secondHalf = false;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' '){
                secondHalf = true;
                i++;
                firstHalf = out;
            }
            if(secondHalf){
                if(!contains(firstHalf,s.charAt(i))){
                    out = out+s.charAt(i);
                }else if(contains(second,s.charAt(i)) && contains(firstHalf,s.charAt(i)) && containsNum(firstHalf,s.charAt(i))==1){
                    out = out+s.charAt(i);
                }
                second = second+s.charAt(i);
            }else {
                out = out + s.charAt(i);
            }
        }
        return out;
    }

    public static boolean contains(String s,char c){
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==c){
                return true;
            }
        }
        return false;
    }

    public static int containsNum(String s, char c){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==c){
                count++;
            }
        }
        return count;
    }

}