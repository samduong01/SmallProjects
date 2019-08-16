import java.util.Scanner;

/**
 * Created by sam on 6/27/19.
 */
public class MowingTheField {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int time = 1;
        int x = 10*n+1;
        int y = 10*n+1;
        int[][] field = new int[10*n*2+2][10*n*2+2];
        Direction[] moves = new Direction[n];
        for(int i = 0;i<n;i++){
            moves[i] = new Direction(sc.next(),sc.nextInt());
        }
        int max = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            String d = moves[i].direction;
            int dist = moves[i].distance;
            for(int j = 0;j<dist;j++){
                int pX = x;
                int pY = y;
                if(d.equals("N")){
                    x++;
                }else if(d.equals("S")){
                    x--;
                }else if(d.equals("W")){
                    y++;
                }else{
                    y--;
                }
                if(field[x][y] <= 0) {
                    field[x][y] = time;
                }else{
                    if(field[pX][pY]-field[x][y]<max && field[pX][pY]-field[x][y]>0){
                        max = field[pX][pY]-field[x][y];
                    }
                    field[x][y] = time;
                }
                time++;
            }
        }
        if(max == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(max + 1);
        }

    }
}
class Direction{
    String direction;
    int distance;
    Direction(String direction,int distance){
        this.direction = direction;
        this.distance = distance;
    }
}
