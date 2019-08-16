import java.util.Scanner;

/**
 * Created by sam on 6/13/19.
 */
public class Untipped {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] a = new int[n][n];

        for(int i = 0;i<n;i++){
            String s = sc.next();
            for(int j = 0;j<n;j++){
                a[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }
        int count = 0;

        for (int i = a.length-1; i >=0; i--) {
            for (int j = a.length-1; j >=0; j--) {
                if (a[i][j] == 1) {
                    flipRectangle(j+1,i+1,a);
                    count++;
                    if(isUntipped(a)){
                        break;
                    }
                }
            }
        }

        System.out.println(count);

    }

    public static boolean isUntipped(int[][] a){
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                if(a[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void flipRectangle(int width, int height, int[][] a){
        for(int i = 0;i<height;i++){
            for(int j = 0;j<width;j++){
                a[i][j] = (a[i][j]==1) ? 0 : 1;
            }
        }
    }
}
