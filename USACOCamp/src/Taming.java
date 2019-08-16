import java.util.Scanner;

/**
 * Created by sam on 6/18/19.
 */
public class Taming {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];

        int min = 0;
        int max = 0;

        for(int i = 0;i <n;i++){
            array[i] = sc.nextInt();
        }

        for(int i = 0;i<array.length;i++){
            if(array[i]!=-1){
                int daysAgo = array[i];
                int daysCOunt = array[i];
                array[i-daysAgo] = 0;
                for(int j = i;j>=i-daysAgo;j--){
                    if(array[j] == daysCOunt || array[j] ==-1){

                    }else{
                        System.out.println(-1);
                        return;
                    }
                    array[j] = daysCOunt;
                    daysCOunt--;
                }
            }
        }

        for(int i = 1;i<array.length;i++){
            if(array[i]==0){
                min++;
            }
        }

        for(int i = 1;i<array.length;i++){
            if(array[i]== -1 || array[i] ==0){
                max++;
            }
        }

        System.out.println((min+1)+ " " + (max+1));
    }
}
