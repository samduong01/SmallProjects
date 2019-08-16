import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sam on 6/19/19.
 */
public class CostumeParty {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0;i<n;i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int count = 0;

        for(int i = 0;i<n;i++){
            count+= bSearch(array,height-array[i],i+1);
        }

        System.out.println(count);
    }

    public static int bSearch(int array[],int data, int lower){
        int upper = array.length-1;
        int count = 0;
        int intialLower = lower;
        while (lower <= upper) {
            int m = lower + (upper - lower) / 2;

            if (array[m] >=data || data>array[array.length-1]){
                if(data>array[array.length-1]){
                    m = array.length-1;
                }

                for(int i = m;i>=intialLower;i--){

                    if(array[i]<=data){
                        m=i;
                        count = m-intialLower+1;
                        return count;
                    }

                }
                return 0;
            }

            if (array[m] < data){
                lower = m + 1;

            }else {
                upper = m - 1;
            }
        }
        return 0;
    }
}

