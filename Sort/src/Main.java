/**
 * Created by sam on 1/30/19.
 */
public class Main {
    public static void main(String[] args){

    }

    public void quicksort(int[] array, int low_index,int high_index){
        if(low_index < high_index){
            // partion code

            int pivot = partion(array,low_index, high_index);
            quicksort(array, low_index,pivot);
            quicksort(array , pivot+1 , high_index);
        }
    }
    public int partion(int[] arr, int index1, int index2){
        int pivot = arr[index2];

        int i = (index1 - 1);

        for (int j = index1; j <= high- 1; j++)
        {
            if (arr[j] <= pivot)
            {
                swap arr[i] and arr[j]
            }
        }
        swap arr[i + 1] and arr[high])
        return (i + 1)
    }
}
