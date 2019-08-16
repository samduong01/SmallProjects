import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by sam on 6/11/19.
 */
public class square {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("/Users/sam/Projects/USACOCamp/src/mixmilk.in"));
        PrintWriter out = new PrintWriter("/Users/sam/Projects/USACOCamp/src/mixmilk.out");

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();

        int xDiff = x4-x1;
        int yDiff = y4-y1;
        if(x1>x3){
            if(x2-x3>y2-y3){
                out.println((x2-x3)*(x2-x3));
            }else{
                out.println(((y2-y3)*(y2-y3)));
            }
        }else {
            if (yDiff > xDiff) {
                out.println(yDiff*yDiff);
            } else {
                out.println(xDiff*xDiff);
            }
        }

        out.close();
    }
}
