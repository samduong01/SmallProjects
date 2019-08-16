import java.util.*;

/**
 * Created by sam on 6/13/19.
 */
public class Pastures {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] pasture = new int[row][col];
        ArrayList<Pasture> pastureArrayList = new ArrayList<>();
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                pasture[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        for(int i = 0;i<row-3;i++){
            for(int j = 0; j<col-3;j++){
                for(int r = i;r<3+i;r++){
                    for(int s = j;s<3+j;s++){
                         sum+= pasture[r][s];
                    }
                }
                Pasture past = new Pasture(i+1,j+1,sum);
                pastureArrayList.add(past);
                sum = 0;
            }
        }

        Collections.sort(pastureArrayList, new Comparator<Pasture>() {
            @Override
            public int compare(Pasture o1, Pasture o2) {
                if(o1.area>o2.area){
                    return -1;
                }else if(o1.area<o2.area){
                    return 1;
                }else{
                    if(o1.x<o2.x){
                        return -1;
                    }else if(o1.x>o2.x){
                        return 1;
                    }else{
                        if(o1.y<o2.y){
                            return -1;
                        }else if( o1.y>o2.y){
                            return 1;
                        }else{
                            return 0;
                        }
                    }
                }
            }
        });

        System.out.println(pastureArrayList.get(0).area);
        System.out.println(pastureArrayList.get(0).x+ " "+pastureArrayList.get(0).y);
    }
}

class Pasture{
    int x;
    int y;
    int area;

    public Pasture(int x, int y, int area){
        this.x = x;
        this.y = y;
        this.area = area;
    }
}
