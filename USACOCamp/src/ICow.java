import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sam on 6/11/19.
 */
public class ICow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int outLength = sc.nextInt();
        Cow[] input = new Cow[n];
        for(int i = 0;i<n;i++){
            input[i] = new Cow(sc.nextInt(),i);
        }

        for(int i = 0;i<outLength;i++){
            Arrays.sort(input, new Comparator<Cow>() {
                @Override
                public int compare(Cow o1, Cow o2) {
                    if(o1.rating>o2.rating){
                        return 1;
                    }else if(o1.rating<o2.rating){
                        return -1;
                    }else{
                        if(o1.name<o2.name){
                            return 1;
                        }else {
                            return -1;
                        }
                    }
                }
            });

            System.out.println((input[n-1].name+1));
            int rating = input[n-1].rating;
            int remainder = rating%(n-1);

            int name = input[n-1].name;
            for(int r = 0;r<n-1;r++){
                input[r].rating += rating/(n-1);
            }
            input[n-1].rating=0;
            Arrays.sort(input, new Comparator<Cow>() {
                @Override
                public int compare(Cow o1, Cow o2) {
                    if(o1.name>o2.name){
                        return 1;
                    }else if(o1.name<o2.name){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            });
//            System.out.println("remainder:"+remainder);
            if(remainder !=0){
                int j = 0;
                while(remainder!=0){
                    if(input[j].name!=name){
                        input[j].rating ++;
                        remainder--;
                    }
                    j++;
                    if(j>=n){
                        j=0;
                    }
                }
            }

        }
    }
}

class Cow{
    int rating;
    int name;
    public Cow(int rating, int name){
        this.rating = rating;
        this.name = name;
    }
}
