import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/27/19.
 */
public class ChinaShop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Vector<Integer> amountInEachRow = new Vector<>();

        Vector<Vector<Integer>> shattered = new Vector<>();
        Vector<Vector<Integer>> shatteredWithZeros = new Vector<>();

        for(int i = 0;i<n;i++){
            String s = sc.next();
            int count = 0;
            for(int j = 0;j<s.length();j++){
                if(s.charAt(j)=='#'){
                    count++;
                }
            }
            amountInEachRow.add(count);
        }

        for(int i = 0;i<amountInEachRow.size();i++) {
            if (amountInEachRow.get(0).equals(0)) {
                amountInEachRow.remove(0);
            }
            if (amountInEachRow.get(amountInEachRow.size() - 1).equals(0)) {
                amountInEachRow.remove(amountInEachRow.size() - 1);
            }
        }

        for(int i = 0;i<k;i++){
            Vector<Integer> v = new Vector<>();
            for(int r = 0;r<n;r++) {
                String s = sc.next();
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '#') {
                        count++;
                    }
                }
                v.add(count);
            }
            shatteredWithZeros.add(new Vector<>(v));
            for(int p = 0;p<v.size();p++) {
                if (v.get(0).equals(0)) {
                    v.remove(0);
                }
                if (v.get(v.size() - 1).equals(0)) {
                    v.remove(v.size() - 1);
                }
            }
            shattered.add(v);
        }
        for(int i = 0;i<k;i++){
            Vector<Integer> s = new Vector<>(shattered.get(i));

            for(int j = i+1;j<k;j++){
                Vector<Integer> compare = new Vector<>(shattered.get(j));
                boolean isFound = true;
                for(int r = 0;r<Math.min(Math.min(compare.size(),s.size()),amountInEachRow.size());r++){
                    if(s.get(r)+compare.get(r) != amountInEachRow.get(r)){
                        isFound = false;
                    }
                }

                if(isFound){
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
            }
        }

        for(int i = 0;i<k;i++){
            Vector<Integer> s = new Vector<>(shattered.get(i));
            for(int j = i+1;j<k;j++){
                Vector<Integer> compare = new Vector<>(shattered.get(j));

                boolean isFound = true;
                for(int in = 1;in<n;in++) {
                    for (int r = 0; r < s.size(); r++) {
                        try {
                            if (s.get(r+in) + compare.get(r) != amountInEachRow.get(r+in)) {
                                isFound = false;
                            }
                        }catch (ArrayIndexOutOfBoundsException e){

                        }
                    }
                    if(isFound){
                        System.out.println((i+1) + " " + (j+1));
                        return;
                    }
                }
            }
        }

        for(int i = 0;i<k;i++){
            Vector<Integer> s = new Vector<>(shatteredWithZeros.get(i));

            for(int j = i+1;j<k;j++){
                Vector<Integer> compare = new Vector<>(shatteredWithZeros.get(j));
                boolean isFound = true;
                for(int r = 0;r<Math.min(Math.min(compare.size(),s.size()),amountInEachRow.size());r++){
                    if(s.get(r)+compare.get(r) != amountInEachRow.get(r)){
                        isFound = false;
                    }
                }

                if(isFound){
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
            }
        }
    }
}
