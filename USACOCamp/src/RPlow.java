import java.util.Scanner;

/**
 * Created by sam on 6/25/19.
 */
public class RPlow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();
        int y = sc.nextInt();
        int[][] field = new int[y][x];
        int n = sc.nextInt();
        Cords[] cords = new Cords[n];

        for(int i = 0;i<n;i++){
            cords[i] = new Cords(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        for(int i = 0;i<n;i++){
            int x1 = cords[i].x1;
            int y1 = cords[i].y1;
            int x2 = cords[i].x2;
            int y2 = cords[i].y2;
            for(int r = y1;r<=y2;r++){
                for(int c = x1;c<=x2;c++){
                    field[r-1][c-1] = 1;
                }
            }
        }
//        for(int i = 0;i<field.length;i++){
//            for(int j = 0;j<field[0].length;j++){
//                System.out.print(field[i][j]+" ");
//            }
//            System.out.println();
//        }
        int count = 0;
        for(int i = 0;i<field.length;i++){
            for(int j = 0;j<field[0].length;j++){
                if(field[i][j]==1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

class Cords{
    int x1,y1,x2,y2;
    Cords(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
