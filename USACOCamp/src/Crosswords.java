import java.util.Scanner;

/**
 * Created by sam on 6/13/19.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Crosswords {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer[]> arrayList = new ArrayList<>();
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        String[][] array = new String[rows+4][cols+4];

        int count = 0;

        for(int i = 0;i<rows+4;i++){
            for(int j = 0;j<cols+4;j++){

                array[i][j] = " ";
            }
        }

        for(int i = 2;i<rows+2;i++){
            String s = sc.next();
            for(int j = 2;j<cols+2;j++){
                String value = Character.toString(s.charAt(j-2));
                array[i][j] = value;
//                System.out.print(array[i][j]);
            }
        }

        int clueCount = 0;

        for(int i = 2;i<rows+2;i++){
            for(int j = 2;j<cols+2;j++){
//                System.out.println(array[i][j]);
                if(!array[i][j].equals("#") && (array[i][j-1].equals("#") || array[i][j-1].equals(" ")) && array[i][j+1].equals(".") && array[i][j+2].equals(".") && clueCount<=3){
//                    System.out.println("horiztonal");

                    count++;
                    clueCount++;
                    Integer[] cord = {i-1,j-1};
                    arrayList.add(cord);
//                    System.out.println("clue:"+clueCount);
                }else if(array[i][j].equals(".") && (array[i-1][j].equals("#") || array[i-1][j].equals(" ")) && array[i+1][j].equals(".") && array[i+2][j].equals(".")){
//                    System.out.println("vertical");
                    count++;
                    Integer[] cord = {i-1,j-1};
                    arrayList.add(cord);
                    clueCount = 0;
                }else {
                    clueCount = 0;
                }
            }
        }

        System.out.println(count);
        for(int i = 0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i)[0] +  " " + arrayList.get(i)[1]);
        }
    }
}

