import java.util.*;

/**
 * Created by sam on 6/18/19.
 */
public class Song {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numNotes = sc.nextInt();
        int questions = sc.nextInt();

        ArrayList<Beat> song = new ArrayList<>();
        int pos = 0;
        for(int i = 0;i<numNotes;i++){
            int beats = sc.nextInt();
            song.add(new Beat(pos,pos+beats));
            pos+=beats;
        }

        Collections.sort(song, new Comparator<Beat>() {
            @Override
            public int compare(Beat o1, Beat o2) {
                return o1.start-o2.start;
            }
        });

        for(int i = 0;i<questions;i++){
            System.out.println(bSearch(song,sc.nextInt())+1);
        }

    }

    public static int bSearch(ArrayList<Beat> array,int data){
        int lower = 0;
        int upper = array.size()-1;
        while (lower <= upper) {

            int m = lower + (upper - lower) / 2;

            if (array.get(m).start <= data && array.get(m).end>data){
                return m;
            }

            if (array.get(m).start < data){
                lower = m + 1;
            }else {
                upper = m - 1;
            }
        }
        return -1;
    }


}

class Beat{
    int start;
    int end;

    Beat(int start, int end){
        this.start = start;
        this.end = end;
    }
}
