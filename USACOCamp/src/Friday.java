import java.util.Scanner;

/**
 * Created by sam on 6/24/19.
 */
public class Friday {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] outDays = new int[7];
        int days = 0;

        for(int i = 1900; i<1900+n;i++){
            monthDays[1] = 28;
            for(int j = 0; j<12;j++){
                if(i%400 == 0 || (i%4 == 0 && i%100 != 0)){
                    monthDays[1] = 29;
                }
                outDays[(days+12)%7]++;
                days += monthDays[j];
            }
        }
        System.out.println(outDays[5]+ " " + +outDays[6]+ " " +outDays[0]+ " " +outDays[1]+ " " +outDays[2]+ " " +outDays[3]+ " " +outDays[4]);
    }


}
