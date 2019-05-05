import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by sam on 2/26/19.
 */
public class Main {
    public static void main(String[] args){
        calc();
    }


    static void calc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hex");
        String num = sc.nextLine();
        try {
            String s = convertFromBaseToBase(num, 2, 16);
        }catch (){

        }
        System.out.println();
    }

    private static String convertFromBaseToBase(String string, int fromBase, int toBase){
        return Integer.toString(Integer.parseInt(string, fromBase), toBase);
    }


    static void print(int[] a){
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }

    static int search(int[] a,int target){
        int l = 0;
        int u = a.length;
        int mid = 0;
        while(u-l!=1){
            mid = (u+l)/2;
            if(a[mid]>target){
                u = mid;
            }else if(a[mid]<target){
                l = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }

    static void sort(int[] a){

        for(int i = 0;i<a.length-1;i++){
            int minIndex = i;
            for(int k = i+1;k<a.length;k++){
                if(a[k]<a[minIndex]){
                    minIndex = k;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    private static int factorialSum(int n){
        if(n == 1){
            return 1;
        }
        return n+factorialSum(n-1);
    }

    static int factorial(int n){
        if(n>1){
            n*=factorial(n-1);
        }
        return n;
    }

    private static String string(String s){
        if(s.length() == 1){
            return s;
        }
        return s + string(s.substring(0,s.length()-1));
    }

    private static int sumOfArray(int[] array, int i){
        if(i==array.length){
            return 0;
        }
        return array[i] + sumOfArray(array,i+1);
    }

    private static void display(char[] A,int n){
        for(int i = 0;i<n;i++){
            System.out.println(A[i] + " ");
        }
    }

    private static void flag(char[] a, int n){
        int start = 0;
        for(int i = 0; i<3;i++){
            for(int j = start+1;j<n;j++){
                if(a[j] == 'R' && i == 0){
                    char temp = 'R';
                    a[j] = a[start];
                    a[start] = temp;
                    start++;
                }else if(a[j] == 'W' && i == 1){
                    char temp = 'W';
                    a[j] = a[start];
                    a[start] = temp;
                    start++;
                }else if(a[j] == 'B' && i == 2){
                    char temp = 'B';
                    a[j] = a[start];
                    a[start] = temp;
                    start++;
                }
            }
        }
    }

    private static String wrap(String s, String s2, int n){
        String string = "";
        if(n == 0){
            return "";
        }
        for(int i = 0;i<n;i++){
            string += s;
        }
        string +=s2;
        return string+wrap(string,s2,n-1);
    }

    private static String triangle(String s){
        System.out.println(s);
        if(s.length() == 3){
            return s;
        }
        return s+triangle(s.substring(0,s.length()-3));
    }


}

abstract class Cow{

}

class Super{
    String high = "hi";
    String lol = "bruh";
    Super(int x){

    }

    public String equals(){
        return high+lol;
    }
}

class TestSuper extends Super{
    TestSuper(int x){
        super(x);
    }

    public String equals(){

        return super.equals() + "huh";
    }
}

class testAb extends Cow{

}
