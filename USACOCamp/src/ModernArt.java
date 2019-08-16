import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/27/19.
 */
public class ModernArt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] paint = new int[n][n];
        Vector<PaintCords> cords = new Vector<>();

        for(int i = 0;i<n;i++){
            String s = sc.next();
            for(int j = 0;j<n;j++){
                paint[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }
        int count = 0;
        for(int r = 1;r<10;r++) {
            int tX = Integer.MAX_VALUE;
            int tY = Integer.MAX_VALUE;

            int bX = Integer.MIN_VALUE;
            int bY = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(paint[i][j]==r){
                        if(i<tX){
                            tX = i;
                        }
                        if(j<tY){
                            tY = j;
                        }
                        if(i>bX ){
                            bX = i;

                        }
                        if(j>bY){
                            bY = j;
                        }
                    }
                }
            }
            if(tX == Integer.MAX_VALUE || tY == Integer.MAX_VALUE || bX == Integer.MIN_VALUE || bY == Integer.MIN_VALUE ){

            }else {
                cords.add(new PaintCords(r, bX, bY, tX, tY));
                count++;
            }
        }

//        for(int i =0; i<cords.size();i++){
//            System.out.print("[ " + cords.get(i).id + " " +cords.get(i).x1 + " " +cords.get(i).y1 + " " +cords.get(i).x2 + " " +cords.get(i).y2 + " ]");
//        }
        HashSet<Integer> nonOverlaps = new HashSet<>();
        for(int r = 0;r<cords.size();r++){
            int x1 = cords.get(r).x1;
            int y1 = cords.get(r).y1;
            int x2 = cords.get(r).x2;
            int y2 = cords.get(r).y2;

            int id = cords.get(r).id;

            for(int i = x2;i<=x1;i++){
                for(int j = y2;j<=y1;j++){
                    if(paint[i][j]!=id){
//                        System.out.println(paint[i][j]+ " " + id);
                        nonOverlaps.add(paint[i][j]);
                    }
                }
            }
        }
        System.out.println(count-nonOverlaps.size());
//        System.out.println(nonOverlaps);
    }
}

class PaintCords{
    int id, x1, y1,x2, y2;
    PaintCords(int id, int x1, int y1, int x2, int y2){
        this.id = id;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
