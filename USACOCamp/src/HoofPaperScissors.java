import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 6/12/19.
 */
public class HoofPaperScissors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer[]> possibleComb = new ArrayList<>();
        ArrayList<Integer[]> games = new ArrayList<>();


        int numGames = sc.nextInt();

        for(int i = 0;i<numGames;i++){
            Integer[] a = {sc.nextInt(),sc.nextInt()};
            games.add(a);
        }
        //hoof //paper //scissors
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 1; k <= 3; k++) {
                    if (k == j || k == i) {
                        continue;
                    }else{
                        Integer[] a = {i,j,k};
                        possibleComb.add(a);
                    }
                }
            }
        }

        int hoof = -1;
        int paper = -1;
        int scissors = -1;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0;i<possibleComb.size();i++){
            hoof = possibleComb.get(i)[0];
            paper = possibleComb.get(i)[1];
            scissors = possibleComb.get(i)[2];

            for(int j = 0;j<games.size();j++){
                if(games.get(j)[0] == hoof && games.get(j)[1] == scissors){
                    count++;
                }else if((games.get(j)[0] == scissors && games.get(j)[1] == paper)){
                    count++;
                }else if((games.get(j)[0] == paper && games.get(j)[1] == hoof)){
                    count++;
                }
            }
            if(count>max){
                max= count;
            }
            count = 0;
        }
        System.out.println(max);
    }
}
