import java.util.*;

/**
 * Created by sam on 6/27/19.
 */
public class ChinaShopBruteShop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Vector<Character[][]> china = new Vector<>();

        Character[][] orginial = new Character[n][n];

        for(int i = 0;i<n;i++){
            String s = sc.next();
            for(int j = 0;j<n;j++){
                orginial[i][j] = s.charAt(j);
            }
        }

        for(int r = 0;r<k;r++){
            Character[][] temp = new Character[n][n];
            for(int i = 0;i<n;i++){
                String s = sc.next();
                for(int j = 0;j<n;j++){
                    temp[i][j] = s.charAt(j);
                }
            }
            china.add(temp);
        }

        for(int i = 0;i<china.size();i++){
            for(int j = i+1;j<china.size();j++){
                Vector<Integer> cords = new Vector<>();
                Character[][] v = china.get(i);
                int count = 0;
                int xO = 0;
                int yO = 0;
                for(int row = 0;row<n;row++){
                    for(int col = 0;col<n;col++){
                        if(china.get(j)[row][col]=='#' && count == 0){
                            xO = row;
                            yO = col;
                            count++;
                        }
                        if(china.get(j)[row][col]=='#'){
                            cords.add(row-xO);
                            cords.add(col-yO);
                        }
                    }
                }

                for(int oX = 0;oX<n;oX++){
                    for(int oY = 0;oY<n;oY++){
                        for(int l = 0;l<cords.size();l+=2){
                            try {
                                if (v[oX + cords.get(l)][oY + cords.get(l + 1)] == '.') {
                                    v[oX + cords.get(l)][oY + cords.get(l + 1)] = '#';
                                }
                            }catch (ArrayIndexOutOfBoundsException e){
                                break;
                            }
                        }
                    }
                }
//                for(int u = 0;u<n;u++){
//                    for(int q = 0;q<n;q++){
//                        System.out.print(v[u][q]+ " ");
//                    }
//                    System.out.println();
//                }
                if(trim(v).equals(trim(orginial))){
                    System.out.println((i+1)+ " " + (j+1));
                    return;
                }
            }
        }
    }

    public static ArrayList<ArrayList<Character>> trim(Character[][] c){
        ArrayList<ArrayList<Character>> out = new ArrayList<>();
        for(int i = 0;i<c.length;i++){
            out.add(new ArrayList<Character>());
        }

        int tX = Integer.MAX_VALUE;
        int tY = Integer.MAX_VALUE;

        int bX = Integer.MIN_VALUE;
        int bY = Integer.MIN_VALUE;

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if(c[i][j]=='#'){
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
        for(int i = tX;i<=bX;i++){
            for(int j = tY;j<=bY;j++){
                out.get(i).add(c[i][j]);
            }
        }

        for(int u = 0;u<out.size();u++){
            for(int q = 0;q<out.get(0).size();q++){
                System.out.print(out.get(u).get(q));
            }
            System.out.println();
        }
        return out;
    }
}
