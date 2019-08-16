import java.util.Scanner;

/**
 * Created by sam on 6/19/19.
 */
public class BinarySearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] array = new int[n];
        for(int i = 0;i<n;i++){
            array[i] = sc.nextInt();
        }
        for(int i = 0;i<q;i++){
            System.out.println(bSearch(array,sc.nextInt()));
        }
    }
    public static int bSearch(int array[],int data){
        int lower = 0;
        int upper = array.length-1;
        while (lower <= upper) {

            int m = lower + (upper - lower) / 2;

            if (array[m] == data){
                if(array[0] ==data){
                    return 0;
                }
                for(int i = m-1;i>=0;i--){
                    if(array[i+1] != array[i]){
                        return i+1;
                    }
                }

                return m;
            }

            if (array[m] < data){
                lower = m + 1;

            }else {
                upper = m - 1;
            }
        }
        return -1;
    }
}
