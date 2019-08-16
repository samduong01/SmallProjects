import java.util.Scanner;

/**
 * Created by sam on 6/18/19.
 */
public class FlowerGarden {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int flowers = sc.nextInt();
        int[] garden = new int[size+1];

        for(int i = 0;i<flowers;i++){
            int starting = sc.nextInt();
            int interval = sc.nextInt();
            for(int j = starting; j<garden.length;j+=interval){
                if(garden[j] <=0){
                    garden[j]  = i+1;
                }
            }
        }
        int count = 0;
        for(int i = 0;i<garden.length;i++){
            if(garden[i] == 0){
                count++;
            }
        }
        System.out.println(count-1);

    }
}
