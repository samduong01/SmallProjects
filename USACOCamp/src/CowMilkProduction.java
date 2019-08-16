import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/14/19.
 */
public class CowMilkProduction {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g = 7;

        ArrayList<CowMilk> days = new ArrayList<>();

        ArrayList<String> currentBoard = new ArrayList<>();
        CowI Bessie = new CowI("Bessie");
        CowI Elsie = new CowI("Elsie");
        CowI Mildred = new CowI("Mildred");

        for(int i = 0;i<n;i++){
            int day = sc.nextInt();
            String id = sc.next();
            int change = sc.nextInt();

            days.add(new CowMilk(id,day,change));

        }

        Collections.sort(days, new Comparator<CowMilk>() {
            @Override
            public int compare(CowMilk o1, CowMilk o2) {
                return o1.day - o2.day;
            }
        });

        int count = 0;
        for(int i = 0;i<days.size();i++){
            ArrayList<String> before = new ArrayList<>(currentBoard);
            currentBoard.clear();
            if(days.get(i).id.equals("Bessie")){
                Bessie.totalSum += days.get(i).change;
            }else if(days.get(i).id.equals("Elsie")){
                Elsie.totalSum +=days.get(i).change;;
            }else{
                Mildred.totalSum += days.get(i).change;
            }


            ArrayList<CowI> cows = new ArrayList<>();
            cows.add(Bessie);
            cows.add(Mildred);
            cows.add(Elsie);

            Collections.sort(cows, new Comparator<CowI>() {
                @Override
                public int compare(CowI o1, CowI o2) {
                    return o2.totalSum - o1.totalSum;
                }
            });

            for(int r = 0 ; r<3;r++){
                int max = cows.get(0).totalSum;
                if(cows.get(r).totalSum==max){
                    if(!currentBoard.contains(cows.get(r).name)) {
                        currentBoard.add(cows.get(r).name);
                    }
                }
            }

            if(!before.equals(currentBoard)){
                count++;
            }
        }

        System.out.println(count);
    }
}

class CowI{
    String name;
    int totalSum;

    public CowI(String name){
        this.name = name;
        totalSum = 7;
    }
}

class CowMilk{
    String id;
    int change;
    int day;

    public CowMilk(String id, int day, int change){
        this.id= id;
        this.day = day;
        this.change = change;
    }
}
