import java.sql.Array;
import java.util.Arrays;

/**
 * Created by sam on 3/19/19.
 */
public class Main {
    public static void main(String[] args){
        int[] arr = {-1,6,7,-2,4,6};
        sort(arr);
        display(arr);
    }

    public static void display(int[] array){
        System.out.println(Arrays.toString(array));
    }
    public static void sort(int arr[]){
        int n = arr.length;

        for(int i = n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }

        for(int i = n-1; i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,i,0);
        }
    }

    static void heapify(int arr[], int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;



        if(l<n && arr[l] > arr[largest]){
            largest = l;
        }

        if(r<n && arr[r]> arr[largest]){
            largest = r;
        }

        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr,n,largest);
        }

        System.out.println("l: "+ l);
        System.out.println("r: "+ r);
        System.out.println("n: "+ n);
        System.out.println("largest: "+ largest);
        System.out.println("i: "+ i);
    }
}
