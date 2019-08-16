import java.util.Scanner;

/**
 * Created by sam on 6/17/19.
 */
public class BillboardOriginal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int lawnx1 = sc.nextInt();
        int lawny1 = sc.nextInt();

        int lawnx2 = sc.nextInt();
        int lawny2 = sc.nextInt();

        int cowx1 = sc.nextInt();
        int cowy1 = sc.nextInt();

        int cowx2 = sc.nextInt();
        int cowy2 = sc.nextInt();


        int truckx1 = sc.nextInt();
        int trucky1 = sc.nextInt();
        int count = 0;

        int truckx2 = sc.nextInt();
        int trucky2 = sc.nextInt();
        int[][] board = new int[2001][2001];

        for(int i = lawny1;i<lawny2;i++){
            for(int j = lawnx1; j<lawnx2;j++){
                board[1000-i][j+1000] = 1;
            }
        }
        for(int i = trucky1;i<trucky2;i++){
            for(int j = truckx1; j<truckx2;j++){
                board[1000-i][j+1000] = 0;
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 1){
                    count++;
                }
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                board[i][j] =0;
            }
        }

        for(int i = cowy1;i<cowy2;i++){
            for(int j = cowx1; j<cowx2;j++){
                board[1000-i][j+1000] = 1;
            }
        }
        for(int i = trucky1;i<trucky2;i++){
            for(int j = truckx1; j<truckx2;j++){
                board[1000-i][j+1000] = 0;
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
