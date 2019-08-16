import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/26/19.
 */
public class Quadratic {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Vector<String> terms = new Vector<>();
        try {
            int start = 0;
            if (s.charAt(0) == 'x') {
                s = 1 + s;
            }
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == 'x' && (s.charAt(i-1) == '-' || s.charAt(i-1) == '+')){
                    s = s.substring(0,i)+"1"+s.substring(i,s.length());
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+') {
                    terms.add(s.substring(start, i));
                    start = i + 1;
                }

                if (s.charAt(i) == '-') {
                    terms.add(s.substring(start, i));
                    start = i;
                }
            }
            terms.add(s.substring(start, s.length()));

            Vector<Integer> co = new Vector<>();
            try {
                for (int i = 0; i < terms.size(); i++) {
                    if (i == 0) {
                        co.add(Integer.parseInt(terms.get(i).substring(0, terms.get(i).length() - 3)));
                    } else if (i == 1) {
                        co.add(Integer.parseInt(terms.get(i).substring(0, terms.get(i).length() - 1)));
                    } else {
                        co.add(Integer.parseInt(terms.get(i)));
                    }
                }
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("ERROR: INVALID INPUT");
            }
            try {
                int a = co.get(0);
                int b = co.get(1);
                int c = co.get(2);
                double first = -1 * ((-1 * b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
                double second = -1 * ((-1 * b) - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
                if(Double.isNaN(first) && Double.isNaN(second)){
                    System.out.println("ERROR: NO SOLUTION");
                }else {
                    System.out.println("x = " + first + " or " + second);
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("ERROR: MAKE SURE TO ENTER ALL 3 TERMS");
            }

        }catch (NumberFormatException e){
            System.out.println("ERROR: INVALID INPUT");
        }
    }
}
