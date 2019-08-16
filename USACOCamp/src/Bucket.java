import java.util.*;

public class Bucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] start = new int[length];
        int[] end= new int[length];
        int[] bucket = new int[length];
        for(int i = 0;i<length;i++){
            int one = sc.nextInt();
            int two = sc.nextInt();
            int bucketVal = sc.nextInt();
            bucket[i] = bucketVal;
            start[i] = one;
            end[i] = two;
        }

        int[] end2 = Arrays.copyOf(end,end.length);
        Arrays.sort(end2);
        int[] array = new int[end2[end2.length-1]+1];

        for(int i = 0;i<length;i++){
            for(int j = start[i];j<=end[i] ;j++){
                array[j] = array[j]+bucket[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
        }

        System.out.println(max);
    }
}
