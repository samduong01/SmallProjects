import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sam on 6/10/19.
 */
public class CowSignal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer s = new StringTokenizer(sc.nextLine());

        int m = Integer.parseInt(s.nextToken());
        int n = Integer.parseInt(s.nextToken());
        int k = Integer.parseInt(s.nextToken());
        String newLine = "";
        char curr = ' ';
        for (int i = 0;i<m;i++){
            String line = sc.nextLine();
            newLine="";
            int count = 0;
            for(int j = 0;j<n-1;j++){
                if(line.charAt(j)==line.charAt(j+1)){
                    count++;
                }else{
                    count++;
                    curr = line.charAt(j);
                    for(int r = 0;r<count*k;r++){
                        newLine= newLine+curr;
                    }
                    count = 0;
                }
            }
            if(count==line.length()-1){
                curr = line.charAt(n-1);
                for(int r = 0;r<(count+1)*k;r++){
                    newLine= newLine+curr;
                }
                count = 0;
            }

            if(line.charAt(n-1)!=curr){
                count++;
                curr = line.charAt(n-1);
                for(int r = 0;r<count*k;r++){
                    newLine= newLine+curr;
                }
            }

            for(int r = 0;r<k;r++) {
                System.out.println(newLine);
            }
        }
    }
}
