import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by sam on 2/17/19.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/Users/sam/Projects/CowJog/src/asd.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/sam/Projects/CowJog/src/asd.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        Integer.parseInt(st.nextToken());
        int numCows = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrayList = new ArrayList<>(numCows);
        for(int i = 0;i<size;i++){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("S")){
                arrayList.add(Integer.parseInt(st.nextToken()),1);
            }else{
                arrayList.add(Integer.parseInt(st.nextToken()),-1);
            }
        }
    }
}
