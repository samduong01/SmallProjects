import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.*;

/**
 * Created by sam on 12/4/18.
 */
public class Main {
    public static void main(String[] args){
        char[] array = {'x','y','z','x','a','z','z','t','d','q','c'};
        char[] noDupArray = removeDup(array);
        for(int i = 0;i<noDupArray.length;i++){
            System.out.print(noDupArray[i]+ " ");
        }
    }
    public static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

    public static char[] removeDup(char[] array){
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0;i<array.length;i++){
            hashSet.add(array[i]);
        }
        char[] newArray = new char[hashSet.size()];
        ArrayList<Character> arrayList = new ArrayList<>();

        for(char value:hashSet){
            arrayList.add(value);
        }
        for(int i = 0;i<newArray.length;i++){
            newArray[i] = arrayList.get(i);
            System.out.println(newArray[i]);
        }

        return newArray;
    }

    public static String reverseString(String string){
        char[] array = string.toCharArray();
        char[] arrayReverse = new char[array.length];
        for(int i = 0;i<array.length;i++){
            arrayReverse[i] = array[array.length-i-1];
        }
        return new String(arrayReverse);
    }

//    2 + 56+ 128 = 186    34596
//    272 8      74204         4+ 128+2048+28672
}
