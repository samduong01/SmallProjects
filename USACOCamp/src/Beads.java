import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sam on 6/10/19.
 */
public class Beads {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer s = new StringTokenizer(sc.nextLine());
        int l = Integer.parseInt(s.nextToken());
        int c = Integer.parseInt(s.nextToken());
        int n = Integer.parseInt(s.nextToken());

        for(int i = 0;i<c;i++){
            s = new StringTokenizer(sc.nextLine());
            int s_i = Integer.parseInt(s.nextToken());
            int p_i = Integer.parseInt(s.nextToken());
            System.out.println(Math.abs(n-p_i)+s_i);
        }
    }
}
