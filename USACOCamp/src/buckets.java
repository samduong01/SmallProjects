import java.util.Scanner;

/**
 * Created by sam on 6/28/19.
 */
public class buckets {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Character[][] field = new Character[10][10];
        int lx = 0;
        int ly = 0;
        int bx = 0;
        int by = 0;
        int rx = 0;
        int ry = 0;
        for(int i = 0;i<10;i++){
            String s = sc.next();
            for(int j = 0;j<10;j++){

                field[i][j] = s.charAt(j);

                if(field[i][j] == 'R'){
                    rx = i;
                    ry = j;
                }

                if(field[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
                if(field[i][j] == 'L'){
                    lx = i;
                    ly = j;
                }
            }
        }
        if(ry == by || rx == bx || ry == ly || rx == lx){
            if (rx == lx && rx == bx || ry == ly && ry == by) {
                System.out.println(Math.abs(bx-lx)+Math.abs(by-ly)+1);
            }else {
                System.out.println(Math.abs(bx - lx) + Math.abs(by - ly) - 1);
            }
        }else{
            System.out.println((int)Math.sqrt(Math.pow(Math.abs(bx-lx)+1,2) + Math.pow(Math.abs(by-ly)+1,2)));

        }
    }
}
