import java.util.Scanner;

/**
 * Created by sam on 6/24/19.
 */
public class Knight {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n+4][m+4];

        for(int j = 2;j<m+2;j++){
            for(int i= 2;i<n+2;i++){
                if(j==2){
                    board[i][j] = 1;
                }else{
                    board[i][j] = board[i+1][j-2]+board[i+2][j-1]+board[i-1][j-2]+board[i-2][j-1];
                }
            }
        }

        for(int i = 2;i<n+2;i++){
            for(int j = 2;j<m+2;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        int sum = 0;
        for(int i = 2;i<n+2;i++){
            sum+= board[i][n+1];
        }
        System.out.println(sum);
    }
}
