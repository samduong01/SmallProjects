import java.util.*;

//1.1.39 Random matches. Write a BinarySearch client that takes an int value T as
//command-line argument and runs T trials of the following experiment for N = 103, 104,
//105, and 106: generate two arrays of N randomly generated positive six-digit int values,
//and find the number of values that appear in both arrays. Print a table giving the average
//value of this quantity over the T trials for each value of N.

public class GenerateRandom1_1_39 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double t = sc.nextInt();
        int[] n = {1000,10000,100000,1000000};

        for(int i = 0;i<n.length;i++){
            double sum = 0;
            for(int j = 0;j<t;j++){
                int[] list1 = new int[n[i]];
                int[] list2 = new int[n[i]];
                for(int r = 0;r<n[i];r++){
                    int one = (int)(Math.random()*899999+100000);
                    int two = (int)(Math.random()*899999+100000);

                    list1[r] = one;
                    list2[r] = two;
                }
                Arrays.sort(list1);
                for(int k = 0;k<list2.length;k++){
                    if(binarySearch(list1,list2[k],0,list1.length-1) != -1){
                        sum++;
                    }
                }
            }
            System.out.println(n[i] + " average through " + t + " trials is " + sum*1.0/t);
        }
    }

    public static int binarySearch(int[] a, int data, int low, int high){
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (a[mid] == data) {
                return mid; }
            else if (data < a[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
