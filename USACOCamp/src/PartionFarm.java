import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/17/19.
 */
public class PartionFarm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = sc.nextInt();
        int a = 0;
        int b = 0;
        ArrayList<Integer[]> cords = new ArrayList<>();

        for(int i = 0;i<num;i++){
            Integer[] array = {sc.nextInt(),sc.nextInt()};

            cords.add(array);
        }
        int quad1 = 0;
        int quad2 = 0;
        int quad3 = 0;
        int quad4= 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        for(a = 0; a<num; a++) {
            for(b = 0; b<num;b++) {
                max = 0;
                quad1 = 0;
                quad2 = 0;
                quad3 = 0;
                quad4 = 0;
                int x = cords.get(a)[0]+1;
                int z = cords.get(b)[1]+1;
                for(int i = 0;i<cords.size();i++){
                    if(cords.get(i)[0]<x && cords.get(i)[1]<z){
                        quad1++;
                    }else if(cords.get(i)[0]<x && cords.get(i)[1]>z){
                        quad2++;
                    }else if(cords.get(i)[0]>x && cords.get(i)[1]<z){
                        quad3++;
                    }else if(cords.get(i)[0]>x && cords.get(i)[1]>z){
                        quad4++;
                    }
                }
                if(quad1>max){
                    max = quad1;
                }
                if(quad2>max){
                    max = quad2;
                }
                if(quad3>max){
                    max = quad3;
                }
                if(quad4>max){
                    max = quad4;
                }

                if(max<min){
                    min = max;
                }
            }
        }
        System.out.println(min);
    }
}
