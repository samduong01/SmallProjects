import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by sam on 2/19/19.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/Users/sam/Projects/Crosswords/src/asd.in"));
        PrintWriter out = new PrintWriter(new FileWriter("/Users/sam/Projects/Crosswords/src/asd.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer[]> arrayList = new ArrayList<>();
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        String[][] array = new String[rows][cols];
        int count = 0;
        for(int i = 0;i<rows;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<cols;j++){
                String value = st.nextToken();
                array[i][j] = value;
            }
        }
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(array[i+1][j] != "#" && array[i+2][j] != "#"){
                    count++;
                    Integer[] cord = {i,j};
                    arrayList.add(cord);
                }else if(array[i][j+2] != "#" && array[i][j+1] != "#"){
                    count++;
                    Integer[] cord = {i,j};
                    arrayList.add(cord);
                }
            }
        }

        out.println(count);
        for(int i = 0;i<arrayList.size();i++){
            out.println(arrayList.get(0)[0] +  "," + arrayList.get(0)[1]);
        }
        out.close();
    }
}
