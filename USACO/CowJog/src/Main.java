import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by sam on 2/12/19.
 */
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("/Users/sam/Projects/CowJog/src/asd.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/sam/Projects/CowJog/src/asd.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        ArrayList<Cow> arrayList = new ArrayList<>(size);
        int count = 1;

        for(int i = 0;i<size;i++){
            st = new StringTokenizer(br.readLine());
            Cow cow = new Cow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            arrayList.add(cow);
        }
        int currentCowSpeed = 0;
        int speedOfCowBehind = 0;
        int speed = arrayList.get(arrayList.size()-1).getVelocity();
        for(int i = arrayList.size()-1;i>0;i--){
            currentCowSpeed = arrayList.get(i).getVelocity();
            speedOfCowBehind = arrayList.get(i-1).getVelocity();

            if(currentCowSpeed>=speedOfCowBehind){
                speed = speedOfCowBehind;
                count++;
            }else if(currentCowSpeed<speedOfCowBehind){
                arrayList.get(i-1).setVelocity(speed);
            }
        }
        out.println(count);
        out.close();
    }
}

class Cow{
    int position;
    int velocity;

    public Cow(int position, int velocity){
        this.position = position;
        this.velocity = velocity;
    }

    public int getVelocity(){
        return velocity;
    }

    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
}


