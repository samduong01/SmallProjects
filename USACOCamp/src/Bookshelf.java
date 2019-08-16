import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/14/19.
 */
public class Bookshelf {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height = sc.nextInt();

        Integer[] array = new Integer[n];
        for(int i = 0;i<n;i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });


        int sum = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
            sum+= array[i];
            count++;
            if(sum>=height){
                break;
            }

        }

        System.out.println(count);
    }
}
