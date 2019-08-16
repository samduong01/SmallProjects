import java.util.Scanner;

/**
 * Created by sam on 6/12/19.
 */
public class Barn {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int perim = sc.nextInt();
        int[] ri = new int[perim];
        for(int i = 0;i<perim;i++){
            ri[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = 0;i<perim;i++){
            for(int j = 0;j<perim;j++){
                if(j<i) {
                    curr += (j - i + perim)*ri[j];
                }else{
                    curr+=(j-i)*ri[j];
                }
            }
            if(curr<min){
                min = curr;

            }
            curr= 0;
        }
        System.out.println(min);
    }
}
