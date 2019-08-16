import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sam on 6/11/19.
 */
public class StartStop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cows = sc.nextInt();
        int length = sc.nextInt();
        ArrayList<Cow1> listOfCows = new ArrayList<>();
        for(int i = 0;i<cows;i++){
            listOfCows.add(new Cow1(i+1));
        }
        for(int i = 0;i<length;i++){
            int name = sc.nextInt();
            String s = sc.next();
            int hour = sc.nextInt();
            int min = sc.nextInt();
            Integer[] in = {hour,min};
            listOfCows.get(name-1).setInput(in,s);
        }

        for(int i = 0;i<listOfCows.size();i++){
            int minutes = 0;

            for(int j = 0;j<listOfCows.get(i).arrayListStart.size();j++){
                minutes += (listOfCows.get(i).arrayListEnd.get(j)[0]*60+listOfCows.get(i).arrayListEnd.get(j)[1])-(listOfCows.get(i).arrayListStart.get(j)[0]*60+listOfCows.get(i).arrayListStart.get(j)[1]);
            }

            System.out.println(minutes/60+" "+minutes%60);
        }
    }
}
class Cow1{
    ArrayList<Integer[]> arrayListStart = new ArrayList<>();
    ArrayList<Integer[]> arrayListEnd = new ArrayList<>();

    int name;
    public Cow1(Integer[] input, int name, String s){
        if(s=="START") {
            arrayListStart.add(input);
        }else{
            arrayListEnd.add(input);
        }

        this.name = name;
    }

    public void setInput(Integer[] input, String s){
        if(s.equals("START")) {
            this.arrayListStart.add(input);
        }else{
            arrayListEnd.add(input);
        }
    }

    public Cow1(int name){

    }

}
