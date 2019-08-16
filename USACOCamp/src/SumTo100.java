/**
 * Created by sam on 6/24/19.
 */
public class SumTo100 {
    public static void main(String[] args) {
        int xPos = 0;
        int yPos = 5;
        int count = 0;
        for(int a = 1;a<4;a+=2){
            for(int b = 1;b<4;b+=2){
                for(int c = 1;c<4;c+=2){
                    for(int d = 1;d<4;d+=3){
                        for(int e = 1;e<4;e+=3){
                            for(int f = 1;f<4;f+=3){
                                for(int g = 1;g<4;g+=3){
                                   xPos =b+d+f;
                                   yPos =a+c+e+g;
                                   if(yPos>0 && yPos<9){
                                       count++;
                                   }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
