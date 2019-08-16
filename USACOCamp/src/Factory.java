import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by sam on 6/28/19.
 */
public class Factory {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("factory.in"));
        PrintWriter out = new PrintWriter(new FileWriter("factory.out"));

        int n = sc.nextInt();
        Vector<Integer[]> paths = new Vector<>();
        Vector<Path> stations = new Vector<>();
        for(int i = 0;i<n-1;i++){
            Integer[] p = {sc.nextInt(),sc.nextInt()};
            paths.add(p);
        }
//        System.out.println("done");
        for(int i = 1;i<=n;i++){
            Path p = new Path(i);
            int currentStation = i;
            int prevS = -1;
            while(prevS != currentStation) {
                prevS = currentStation;
                for (int j = 0; j < paths.size(); j++) {
                    if (paths.get(j)[0] == currentStation) {
                        currentStation = paths.get(j)[1];
                        p.stationsVisit.add(currentStation);
//                        System.out.println("i " + i + " station " + currentStation);
//                        System.out.println(p.stationsVisit);
                        break;
                    }
                }
            }
            stations.add(p);
        }

        for(int i = 1;i<=n;i++){
            boolean isFound = true;
            for(int j = 0;j<stations.size();j++){
                if(stations.get(j).start == i){
                    continue;
                }
                if(!stations.get(j).stationsVisit.contains(i)){
                    isFound = false;
                }
            }
            if(isFound){
                out.println(i);
                out.close();
                return;
            }
        }
        out.println(-1);
        out.close();
    }
}

class Path{
    int start;
    Vector<Integer> stationsVisit = new Vector<>();
    Path(int start){
        this.start = start;
    }
}
