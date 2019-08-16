import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sam on 6/20/19.
 */
public class GenomeCow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = sc.nextInt();
        String[] s = new String[n];

        ArrayList<ArrayList<Character>> positions = new ArrayList<>();

        for(int i = 0;i<n;i++){
            s[i] = sc.next();
        }

        String[] plain = new String[n];
        for(int i = 0;i<n;i++){
            plain[i] = sc.next();
        }
        int count = 0;
        for(int i = 0;i<s[0].length();i++){
            ArrayList<Character> spotted = new ArrayList<>();
            for(int j = 0;j<n;j++){
                spotted.add(s[j].charAt(i));
            }
            positions.add(spotted);
        }

        for(int i = 0;i<plain[0].length();i++){
            String sequence = "";
            for(int j = 0;j<n;j++){
                sequence+=plain[j].charAt(i);
            }
            boolean isFound = false;
            for(int r = 0;r<positions.get(0).size();r++) {
                if (sequence.contains(Character.toString(positions.get(i).get(r)))){
                    isFound = true;
                }
            }
            if(!isFound){
                count++;
            }
        }

        System.out.println(count);
    }
}
