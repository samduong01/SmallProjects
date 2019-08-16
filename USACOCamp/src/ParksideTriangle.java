import java.util.Scanner;

/**
 * Created by sam on 6/26/19.
 */
public class ParksideTriangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[][] arr = new int[n][n];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<i+1;j++){
                arr[j][i] = s;
                s++;
                if(s==10){
                    s = 1;
                }
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
               if(arr[i][j]==0){
                   System.out.print("  ");
               }else{
                   if(i==j){
                       System.out.print(arr[i][j]);
                   }else {
                       System.out.print(" " + arr[i][j]);
                   }
               }
            }
            System.out.println();

        }
    }
}
