import com.sun.tools.javac.util.ArrayUtils;

import java.awt.event.FocusListener;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by sam on 1/20/18.
 */
public class USACO {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        int[] array = {10,1,2,3,4,5};

        less();
    }

    public static int gift(int[] price, int[] shipping,int budget){
        int maximumGift = 0;

        for(int i = 0; i<price.length;i++){
            int amount = getMaximumGift(i,price,shipping,budget);
            maximumGift = Math.max(maximumGift,amount);
        }
    }

    public static int getMaximumGift(int index, int[] price, int[] shipping,int budget){
        int[] totalPrice = new int[price.length];
        for(int i = 0; i<price.length;i++){
            if (i == index)
            {
            totalPrice[i] = price[i]/2 + shipping[i];
        }
        Arrays.sort(totalPrice);
            int giftAmt = 0;
            int sumPrice = 0;
            while (sumPrice<= budget){
                sumPrice = sumPrice + totalPrice[giftAmt];
                giftAmt++;
            }
    }

    public static int binarySearch(int[] array, int numWanted){
        int beginning = 0;
        int end = array.length-1;

        while(beginning<=end){

            int middleIndex = (beginning+end)/2;

            if(numWanted==array[middleIndex]){
                return middleIndex;
            }

            if(numWanted < array[middleIndex]){
                end = middleIndex-1;
            }else{
                beginning = middleIndex+1;
            }


        }
        return -1;


    }

    public static void less(){
        HashMap<Integer,List> less = new HashMap<>();

        less.put(1,3);
        System.out.print(less.get(1));
    }

    public static int gift(){

    }



    public static void haybails(int one, int second){
        int[] array = {2,7,3,5};
        int secondCount = 0;
        int firstCount = 0;
        Arrays.sort(array);

        for(int i = 0; i<=second;i--) {

            if (binarySearch(array, i)!=-1 && array[binarySearch(array, i)] <= second) {
                secondCount = binarySearch(array, i);
                break;
            }
        }

        for(int i = 0; i<=one;i++) {
            if (binarySearch(array, i)!=-1 && array[binarySearch(array, i)] >= one) {
                firstCount = binarySearch(array, i);
                break;
            }
        }

        System.out.println(secondCount-firstCount);
    }

    public static String strings(String s, String t){
        while(s.contains(t)){
            s = s.replace(t,"");
            System.out.println(s);
        }
        return s;
    }

//    public static int areaCaluclator(int x1, int x2, int x3, int x4, int x5, int x6, int y1, int y2, int y3, int y4, int y5, int y6){
//        int areax1 = (x1 - x2) * (y1-y2);
//        int areax2 = (x)
//    }

//    public static int costPlaneRoute(){
//
//    }

    public static int shapeArea(int n){

            return (n*n) + ((n-1)*(n-1));

    }

    public static int largeArray(int[] array){
        int[] productArray = new int[array.length-1];

        for(int i = 0; i < array.length -1 ;i++){
            productArray[i] = array[i] * array[i+1];
        }

        int max = productArray[0];

        for (int i = 1; i < productArray.length; i++) {
            if (productArray[i] > max) {
                max = productArray[i];
            }
        }
        return max;
    }

    public static void combine(ArrayList<Integer> a, ArrayList<Integer> b){
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(i<a.size() && j< b.size()){

            if(a.get(i)<b.get(j)){
                result.add(a.get(i));
                i++;
            }else if(a.get(i)>b.get(j)){
                result.add(b.get(j));
                j++;
            }else{
                result.add(a.get(i));
                result.add(b.get(j));
                i++;
                j++;
            }
        }

        if(i<a.size()){
            for(int k = i; k<a.size();k++){
                result.add(a.get(k));
            }
        }

        if(j<b.size()){
            for(int k = j; k<b.size();k++){
                result.add(b.get(k));
            }
        }
        System.out.println(result);
    }























    public static void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }

        quickSort(input, 0, input.length - 1);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void quickSort(int[] array, int small, int high) {
        int i = small;
        int j = high;

        int pivot = array[small + (high - small) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (small < j) {
            quickSort(array, small, j);
        }
        if (i < high) {
            quickSort(array, i, high);
        }
    }


    public static boolean palidrome(String string) {
        int i1 = 0;
        int i2 = string.length() - 1;
        while (i2 > i1) {
            if (string.charAt(i1) != string.charAt(i2)) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;

    }

    public static int statues(Integer[] statues){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i<statues.length;i++){
            if(statues[i] > max){
                max = statues[i];
            }
            if(statues[i]<min){
                min = statues[i];
            }
        }


        return ((max-min)-1)-((statues.length)-2);
    }

    public static boolean increasing(int[] sequence){
        int count = 0;
        for(int i = 0; i < sequence.length-2; i++) {
            if(sequence[i+1]-sequence[i] >1){

            }else if(count <1){
                if(!(i == 0)) {
                    if (!(sequence[i + 2] - sequence[i] > 1)) {
                        return false;
                    }
                }else{
                    if(sequence[i] > sequence[i+1]) {
                        if (!(sequence[i + 2] - sequence[i + 1] > 1)) {
                            return false;
                        }
                    }else{
                        if (!(sequence[i + 2] - sequence[i] > 1)) {
                            return false;
                        }
                    }
                }
                i++;
                count++;
            }else{
                return false;
            }
        }
        return true;

    }

    public static void que(int[] array){
        Queue<Integer> myQueue = new LinkedList<Integer>();
        for(int i = 0; i<array.length;i++){
            if(myQueue.size() == 0){
                System.out.println(myQueue);
                return;
            }
            if(array[i] == 1){
                myQueue.add(array[1]);
            }else if(array[i] == 2){
                myQueue.remove();
            }else if(array[i] == 3){
                System.out.println(myQueue.peek());
            }
        }
    }

//    public static boolean stack(String string){
//        Stack<Character> stack = new Stack<>();
//        for(int i = 0; i<string.length();i++){
//            stack.add(string.charAt(i));
//        }
//        if(stack.pop().equals(){
//
//        }
//    }

//    public static int calculate(String[] array){
//        Stack<String> stack = new Stack<>();
//        int finalNum = 0;
//        for(int i = 0; i<array.length;i++){
//            try{
//                Integer.parseInt(array[i]);
//                stack.push(array[i]);
//            }catch (NumberFormatException e){
//                finalNum =
//            }
//        }
//    }

    public static int speed(ArrayList<Integer> distance, ArrayList<Integer> times){
        int totalDistance = 1;
        int speed =1;
        int time = 1;
        int factor = 1;
        int totalTime = 1;
        while(totalDistance <1000){
            if(distance.contains(totalDistance) || times.contains(totalTime)){
                factor ++;
                time = 1;
            }

            totalDistance = totalDistance + time *factor;
            time++;
            totalTime = totalTime +time;
        }
        return totalTime;
    }

//    public static int num(int one, int second){
//        int firstNum = Integer.MIN_VALUE;
//        for(int i = one; i <second;i++){
//            for(int j = 0; j< )
//        }
//    }

//    public static int input(int[] array){
//        Arrays.sort(array);
//        for(int i = 0; i< array.length-1;i++){)
//        }
//
//    }




//    public static void selectionSort(int[] array) {
//
//        for (int i = 0; i < array.length - 1; i++) {
//
//            int currIndex = i;
//
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] < array[currIndex]) {
//                    currIndex = j;
//
//                }
//
//                int temp = array[currIndex];
//                array[currIndex] = array[i];
//                array[i] = temp;
//
//            }
//            for (int j = 0; j < array.length; j++) {
//                System.out.println(array[j]);
//            }
//
//        }
//
//
//    public static int fibonacci(int n) {
//        if (n >= 0) {
//            if (n == 1 || n == 0) {
//                return 1;
//            }
//            return fibonacci(n - 1) + fibonacci(n - 2);
//        }
//        return -1;
//    }
//
//    public static int forFactorial(int n) {
//        int result = 1;
//        for (int i = 1; i < n + 1; i++) {
//            result = result * i;
//        }
//        return result;
//    }
//
////    public static int rightDistance(int start, int cow){
////        int currentPosition = start;
////        int count = 0;
////        while(currentPosition<cow){
////            if(count%2 == 0){
////                currentPosition++;
////            }else{
////                currentPosition = (currentPosition-start);
////            }
////        }
////    }
//
//
//    public static int factorial(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        return factorial(n - 1) * n;
//    }
//
//    public static String hanio(int n, Object x, Object y, Object z) {
//        StringBuffer str = new StringBuffer("");
//        if (n == 1)
//            str.append(move(x, n, z) + "\n");
//        else {
//            hanio(n - 1, x, z, y);
//            str.append(move(x, n, z) + "\n");
//            hanio(n - 1, y, x, z);
//        }
//        return str.toString();
//    }
//
//    private static String move(Object x, int n, Object y) {
//        return "Move " + n + " from " + x + " to " + y;
//    }
//
//
//    public static int sum(int n) {
//
//        return n == 0 ? 0 : n % 10 + sum(n / 10);
//    }
////    public static String block(String a,String b){
////        int[] outputA = new int[26];
////        int[] outputB = new int[26];
////
////            for (int i = 0; i < a.length(); i++) {
////                outputA[a.charAt(i) - 'a'] = outputA[a.charAt(i) - 'a']++;
////            }
////
////            for (int i = 0; i < b.length(); i++) {
////                outputB[b.charAt(i) - 'a'] = outputB[b.charAt(i) - 'a']++;
////            }
////
////            for(int i = 0;)
////
////
////        return ;
////    }
//
//
//    public static int haybales(int numberofPiles, int pile1, int pile2, int pile3, int pil4) {
//        int averageOfpiles = (pile1 + pile2 + pile3 + pil4) / numberofPiles;
//        int haybalesMoved = 0;
//
//        haybalesMoved = Math.abs(pile1 - averageOfpiles) + Math.abs(pile2 - averageOfpiles) + Math.abs(pile3 - averageOfpiles) + Math.abs(pil4 - averageOfpiles);
//        return haybalesMoved;
//    }
//
//    public static int timeManagment(int date, int hour, int minutes) {
//        //convert everyting to minutes and then compare
//        int totalMinutes = 0;
//        int difference = 0;
//        totalMinutes = date * 24 * 60 + hour * 60 + minutes;
//        return totalMinutes;
//    }
//
//
//    public static int[] rotate(int[] array, int rotateValue) {
//        int[] output = new int[array.length];
//        for (int i = 0; i < array.length - rotateValue; i++) {
//            output[i] = array[i];
//        }
//        for (int i = 0; i < rotateValue; i++) {
//            output[i] = array[i];
//        }
//        return output;
//    }
//
//
//    public static String calculate(int[] array) {
//
//        Integer[] output = new Integer[2];
//
//        int sum = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == -1) {
//                continue;
//            } else {
//                sum = array[i] + sum;
//            }
//        }
//
//        output[0] = sum;
//        output[1] = sum / (array.length - 1);
//        return "sum is " + output[0] + " average is " + output[1];
//    }
//
//    public static ArrayList<Integer> merge(int[] arrayA, int[] arrayB) {
//        ArrayList<Integer> output = new ArrayList<>();
//        int i = 0;
//        int j = 0;
//        while (i < arrayA.length && j < arrayB.length) {
//            if (arrayA[i] > arrayB[j]) {
//                output.add(arrayB[i]);
//            } else if (arrayA[i] < arrayB[i]) {
//                output.add(arrayA[i]);
//            } else {
//                output.add(arrayA[i]);
//                output.add(arrayB[i]);
//            }
//            i++;
//            j++;
//        }
//        if (i > j) {
//            for (int g = 0; g < arrayB.length; g++) {
//                output.add(arrayB[g]);
//            }
//        } else if (i < j) {
//            for (int g = 0; g < arrayA.length; g++) {
//                output.add(arrayA[g]);
//            }
//        }
//        return output;
//    }
}

