import java.util.*;

/**
 * Created by sam on 6/17/19.
 */
public class CowReduction {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Vector<CowCord> cows = new Vector<>();

        for(int i = 0;i<n;i++){
            cows.add(new CowCord(sc.nextInt(),sc.nextInt()));
        }
        int yDiff;
        int xDiff;
        ArrayList<CowCord> original = new ArrayList<>(cows);
        int min = Integer.MAX_VALUE;

        for(int i = 0;i<2;i++){
            cows = new Vector<>(original);

            Collections.sort(cows, new Comparator<CowCord>() {
                @Override
                public int compare(CowCord o1, CowCord o2) {
                    return o1.x-o2.x;
                }
            });
            cows.remove(i);
            xDiff = cows.get(cows.size()-1).x - cows.get(0).x;
            Collections.sort(cows, new Comparator<CowCord>() {
                @Override
                public int compare(CowCord o1, CowCord o2) {
                    return o1.y-o2.y;
                }
            });

            yDiff = cows.get(cows.size()-1).y-cows.get(0).y;

            if(xDiff*yDiff<min){
                min = xDiff*yDiff;
            }
        }

        for(int i = 1;i<3;i++){
            cows = new Vector<>(original);

            Collections.sort(cows, new Comparator<CowCord>() {
                @Override
                public int compare(CowCord o1, CowCord o2) {
                    return o1.x-o2.x;
                }
            });
            cows.remove(cows.size()-i);

            xDiff = cows.get(cows.size()-1).x - cows.get(0).x;
            Collections.sort(cows, new Comparator<CowCord>() {
                @Override
                public int compare(CowCord o1, CowCord o2) {
                    return o1.y-o2.y;
                }
            });

            yDiff = cows.get(cows.size()-1).y-cows.get(0).y;
            if(xDiff*yDiff<min){
                min = xDiff*yDiff;
            }
        }

        for(int i = 0;i<2;i++){
            cows = new Vector<>(original);

            Collections.sort(cows, new Comparator<CowCord>() {
                @Override
                public int compare(CowCord o1, CowCord o2) {
                    return o1.y-o2.y;
                }
            });
            cows.remove(i);
            yDiff = cows.get(cows.size()-1).y - cows.get(0).y;
            Collections.sort(cows, new Comparator<CowCord>() {
                @Override
                public int compare(CowCord o1, CowCord o2) {
                    return o1.x-o2.x;
                }
            });

            xDiff = cows.get(cows.size()-1).x-cows.get(0).x;
            if(xDiff*yDiff<min){
                min = xDiff*yDiff;
            }
        }

        for(int i = 1;i<3;i++){
            cows = new Vector<>(original);

            Collections.sort(cows, new Comparator<CowCord>() {
                @Override
                public int compare(CowCord o1, CowCord o2) {
                    return o1.y-o2.y;
                }
            });
            cows.remove(cows.size()-i);
            yDiff = cows.get(cows.size()-1).y - cows.get(0).y;
            Collections.sort(cows, new Comparator<CowCord>() {
                @Override
                public int compare(CowCord o1, CowCord o2) {
                    return o1.x-o2.x;
                }
            });

            xDiff = cows.get(cows.size()-1).x-cows.get(0).x;
            if(xDiff*yDiff<min){
                min = xDiff*yDiff;
            }
        }

        System.out.println(min);
    }
}

class CowCord {
    int x,y;

    CowCord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class TestX implements Comparator<CowCord>{
    @Override
    public int compare(CowCord o1, CowCord o2) {
        return o2.x - o1.x;
    }

}

class TestY implements Comparator<CowCord>{
    @Override
    public int compare(CowCord o1, CowCord o2) {
        return o2.y - o1.y;
    }
}

