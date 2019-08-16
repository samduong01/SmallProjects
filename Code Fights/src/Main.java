import com.sun.deploy.util.StringUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

import java.util.*;
/**
 * Created by sam on 3/27/18.
 */
public class Main {


    public static void main(String[] args){

        int[] arrayofNumbers = {-1, 150, 160, 170, -1, -1, 180, 190};
        String[] test0 = {"z","a","z","z","b"};
        String test1 = "a(bc)de";
        String test2 = "(a(bc)(((s)c)))))";
        ArrayList<Integer> cool = new ArrayList<>();
        cool.add(1);
        cool.add(4);
        cool.add(5);
        int[] one = {2, 3, 5, 1, 6
        };
        String[] two = {"abc",
                "abx",
                "axx",
                "abx",
                "abc"};
        int[] three = {1,1,1};
        int[] four = {-15,2,5,1};
        int[] five = {2, 3, 5, 1, 6};
        System.out.println(buildPalindrome("abcdc"));

        String string = "3";
        System.out.println(Integer.parseInt(string));


    }


    public static void printArray(int[][] array){
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[0].length;j++){
                if(i==0){
                    System.out.println("");
                }
                System.out.println(array[i][j]);
            }
        }
    }
    public static int commonString(String s1, String s2){
        int count = 0;
        for(int i = 0; i<s2.length();i++){
            if(s1.contains(String.valueOf(s2.charAt(i)))){
                count++;
                s1 = s1.replaceFirst(String.valueOf(s2.charAt(i)),"");
            }
        }
        return count;
    }

    public static boolean isBeautifulString(String inputString) {
        int oldCount = inputString.length()-inputString.replaceAll(String.valueOf('a'),"").length();
        for(int i = 1;i<27;i++){
            String inputStringA = inputString;
            int count = inputStringA.length() - inputStringA.replace(String.valueOf((char)(i + 96)), "").length();
            System.out.println(count);
            System.out.println(oldCount);
            System.out.println((char)(i+96));
            System.out.println("");
            if(!(count<=oldCount)){
                return false;
            }
            oldCount = count;
        }
        return true;
    }

    public static String findEmailDomain(String address) {
        int indexOfAt = address.lastIndexOf('@');
        return address.substring(indexOfAt+1,address.length());
    }

    public static String buildPalindrome(String st) {
        String string1 = new StringBuilder(st.substring(0,st.length()-1)).reverse().toString();
        String stringCase1 = st;
        String stringCase2 = st;
        for(int i = 0;i<stringCase1.length()-1;i++){;
            String newString = new StringBuilder(stringCase1).reverse().toString();
            if(newString.equals(stringCase1)){
                break;
            }
            stringCase1 = stringCase1+string1.charAt(i);
        }
//        for(int i = 0;i<stringCase2.length()-1;i++){
//            System.out.println(stringCase2 + " 2");
//            String newString = new StringBuilder(stringCase2).reverse().toString();
//            if(newString.equals(stringCase2)){
//                break;
//            }
//        }
        System.out.println(stringCase2 +"2");

        if(stringCase1.length()>stringCase2.length()){
            return stringCase2;
        }else{
            return stringCase1;
        }
    }

    public static boolean isLucky(int n){
        double sumFirstHalf = 0;
        double sumSecondHalf = 0;
        for(int i = 0;i<String.valueOf(n).length();i++){

            if(i<(String.valueOf(n).length()/2)){
                sumFirstHalf = sumFirstHalf+ Character.getNumericValue(String.valueOf(n).charAt(i));
            }else{
                sumSecondHalf = sumSecondHalf+ Character.getNumericValue(String.valueOf(n).charAt(i));
            }
        }
        return sumFirstHalf==sumSecondHalf;
    }

    public static ArrayList<Integer> height(int[] a){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int current = Integer.MAX_VALUE;
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();

        for(int i = 0;i<a.length;i++){
            if(a[i] != -1){
                arrayList.add(a[i]);
            }else{
                arrayList2.add(i);
            }
        }
        Collections.sort(arrayList);
        for (int i = 0;i<arrayList2.size();i++){
            arrayList.add(arrayList2.get(i),-1);
        }
        return arrayList;
    }


    public static String stringReverse(String s){
        int start = 0;
        int end = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                start = i;
            }else if(s.charAt(i)==')'){
                String string = s.substring(start+1,i);
                System.out.println("string going to be reversed " + string);
                string = new StringBuffer(string).reverse().toString();
                System.out.println("string after reversed " + string);

                s = s.substring(0,start) + string + s.substring(i+1,s.length());
                System.out.println("final string " + s);

                if(s.contains("(") || s.contains(")")) {
                    start = 0;
                    i = 0;
                }else{
                    break;
                }
            }
        }
        return s;

    }

    public static String[] addBorder(String[] picture){
        String[] result = new String[picture.length+2];
        int topRowlength = picture[0].length() +2;
        String topandBottom = "";
        for(int i = 0; i<topRowlength;i++){
            topandBottom += "*";
        }
        result[0] =topandBottom;
        result[picture.length+1] = topandBottom;
        for(int i = 0;i<picture.length;i++){
            String temp = "";
            temp = "*" + picture[i] + "*";
            result[i+1] = temp;
        }
        return result;
    }

    public static int arrayChange(int[] inputArray){
        int currentNumMoves = 0;
        for(int i = 1; i<inputArray.length;i++){
            if(inputArray[i] <= inputArray[i-1]){
                currentNumMoves = currentNumMoves+((inputArray[i-1]-inputArray[i])+1);
                inputArray[i] = inputArray[i]+((inputArray[i-1]-inputArray[i])+1);
            }
        }
        return currentNumMoves;
    }

    public static int[] extractEachKth(int[] inputArray, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        for(int i = 0; i<inputArray.length;i++){
            output.add(inputArray[i]);
        }
        int count = 0;
        for(int i = 0;i<inputArray.length;i++){
            if((i+1)%k == 0){
                output.remove(i-count);
                count++;
            }
        }
        int[] ouput1 = new int[output.size()];
        for(int i = 0;i<ouput1.length;i++){
            ouput1[i] = output.get(i);
        }


        return ouput1;
    }

    public static char firstDigit(String inputString) {
        String newString = inputString.replaceAll("[^0-9]", "");
        System.out.println(newString);
        return newString.charAt(0);

    }

    public static int differentSymbolsNaive(String s) {
        char[] input = s.toCharArray();
        Arrays.sort(input);
        int count = 1;
        for(int i = 0;i<input.length-1;i++){
            if(input[i] != input[i+1]){
                count++;
            }
        }
        return count;
    }

    public static int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        int max = Integer.MIN_VALUE;
        int currentMax = 0;
        int count = 0;
        for(int i = 0;i<inputArray.length;i++){
            if(count==k-1){
                if(currentMax>max){
                    max = currentMax;
                    currentMax = 0;
                    count = 0;
                }
            }else{
                currentMax += inputArray[i];
                count++;
            }
        }
        return max;
    }
    public static int arrayMaxConsecutive(int[] inputArray, int k) {
        int max = 0;
        int current = 0;
        for(int i = 0;i<inputArray.length-k+1;i++){
            for(int j = 0; j<k;j++){
                current = inputArray[i+j]+current;
            }
            if(current>max){
                max = current;
            }
            current = 0;
        }
        return max;
    }

    public static int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        if(((desiredHeight-upSpeed)/(upSpeed-downSpeed))==0){
            return ((desiredHeight-upSpeed)/(upSpeed-downSpeed))+2;
        }
        return ((desiredHeight-upSpeed)/(upSpeed-downSpeed))+1;
    }

    public static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        boolean weightof1 = weight1<=maxW;
        boolean weightof2 = weight2<=maxW;
        boolean value1bigger = value1>value2;
        boolean value2bigger = value2>value1;
        boolean weightofboth = (weight1+weight2)<=maxW;

        if(weightofboth){
            return value1+value2;
        }else if(value1bigger && weightof1){
            return value1;
        }else if(value2bigger && weightof2){
            return value2;
        }else if(weightof1){
            return value1;
        }else if(weightof2){
            return value2;
        }else{
            return 0;
        }
    }

    public static String longestDigitsPrefix(String inputString) {
        if(Character.isLetter(inputString.charAt(0))){
            return "";
        }
        for(int i = 0;i<inputString.length();i++){
            if(Character.isLetter(inputString.charAt(i))){
                return inputString.substring(0,i-1);
            }
        }
        return inputString;

    }

    public static int digitDegree(int n) {
        int currentNum = n;
        int count = 0;
        while(currentNum>9){
            String number = String.valueOf(currentNum);
            char[] digits1 = number.toCharArray();
            currentNum = 0;
            for(int i = 0;i<digits1.length;i++){
                currentNum = currentNum+Character.getNumericValue(digits1[i]);
            }
            count++;
        }
        return count;
    }

    public static boolean bishopAndPawn(String bishop, String pawn) {
        return Math.abs(('a'-bishop.charAt(0))-('a'-pawn.charAt(0)))==Math.abs(('a'-bishop.charAt(1))-('a'-pawn.charAt(1)));
    }



    public static boolean palindromeRearranging(String inputString){
        char[] temp = inputString.toCharArray();
        Arrays.sort(temp);
        System.out.println(temp);

        int count = 0;
        int numsOfSingles = 0;
        char temps = temp[0];
        for(int i = 0;i<temp.length;i++){
            if(temp[i] ==temps){
                count++;
            }else{
                if(count%2!=0 && numsOfSingles == 0 && inputString.length()%2!=0){
                    numsOfSingles = 1;
                    count = 1;
                    temps = temp[i];
                }else if(count%2 == 0){
                    count = 1;
                    temps = temp[i];
                }else{
                    return false;
                }
            }
        }
        return true;

    }
    public static int arrayMaximalAdjacentDifference(int[] inputArray) {
        int max = 0;
        int currentDif = 0;
        for(int i = 0;i<inputArray.length-1;i++){
            currentDif = Math.abs(inputArray[i]-inputArray[i+1]);
            if(currentDif>max){
                max = currentDif;
            }
        }
        return max;
    }

    public static int avoidObstacles(int[] inputArray) {
        Arrays.sort(inputArray);
        int jumpDistance = 1;


        boolean jumpDistanceWorks = false;
        int currentNum = jumpDistance;
        while(!jumpDistanceWorks){
            if(!contains(inputArray,currentNum)){
                if(currentNum>inputArray[inputArray.length-1]){
                    return jumpDistance;
                }
                currentNum = currentNum+jumpDistance;
            }else{
                jumpDistance++;
                currentNum = jumpDistance;
            }
        }
        return jumpDistance;
    }

    public static boolean evenDigitsOnly(int n){
        String number = String.valueOf(n);
        char[] digits = number.toCharArray();
        for(int i = 0;i<digits.length;i++){
            if(digits[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }


    public static String alphabeticShift(String inputString) {
        System.out.println('b'-'a');
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] sliced = inputString.toCharArray();

        for(int i = 0;i<inputString.length();i++){
            if(sliced[i] == 'z'){
                sliced[i] = 'a';
            }else {
                Character askii = sliced[i];
                sliced[i] = alphabet[(askii - 'a') + 1];
            }
        }

        String b = new String(sliced);
        return b;
    }

    public static boolean chessBoardCellColor(String cell1, String cell2) {
        Character letter1 = cell1.charAt(0);
        int num1 = Character.getNumericValue(cell1.charAt(1));
        Character letter2 = cell2.charAt(0);
        int num2 = Character.getNumericValue(cell2.charAt(1));
        int one = letter1-'A';
        if((letter1-'A') % 2 == 0){
            if(num1%2 == 0){
                cell1 = "white";
            }else{
                cell1 = "brown";
            }
        }else{
            if(num1%2 == 0){
                cell1 = "brown";
            }else{
                cell1 = "white";
            }
        }

        if((letter2-'A') %2==0){
            if(num2%2 == 0){
                cell2 = "white";
            }else{
                cell2 = "brown";
            }
        }else{
            if(num2%2 == 0){
                cell2 = "brown";
            }else{
                cell2 = "white";
            }
        }

        return cell1==cell2;
    }

    public static boolean variableName(String name) {
        char[] digits = name.toCharArray();
        if(Character.isDigit(name.charAt(0))){
            return false;
        }
        for(int i = 0;i<digits.length;i++){
            if(!Character.isLetter(name.charAt(i)) && !Character.isDigit(name.charAt(i)) && digits[i] != '_'){
                return false;
            }
        }
        return true;

    }

    public static boolean contains(int[] arr, int targetValue){
        for(int i = 0; i<arr.length;i++){
            if(targetValue == arr[i]){
                return true;
            }
        }
        return false;
    }

    public static boolean isIPv4Address(String inputString) {
        String[] array = inputString.split("\\.", -1);
        int length = array.length;
        for(int i = 0; i<array.length;i++){
            if(array[i].equals("")){
                length--;
            }
        }

        System.out.println(array.length);

        int count = inputString.length() - inputString.replace(".", "").length();
        if(inputString.charAt(inputString.length()-1) == '.' ||inputString.charAt(0) == '.'){
            return false;
        }
        if(inputString.matches(".*[a-z].*")){
            return false;
        }

        if(length -1 !=count){
            return false;
        }

        if(length!=4){
            return false;
        }

        for(int i = 0;i<array.length;i++){
            if(array[i].length()>3){
                return false;
            }
            if(Integer.parseInt(array[i]) >= 0 && Integer.parseInt(array[i]) <=255){

            }else{
                return false;
            }
        }

        return true;
    }


    public static boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        int friendsMax = 0;
        int yourMax = 0;
        int yourMin = 0;
        int friendsMin = 0;
        if(yourLeft > yourRight){
            yourMax = yourLeft;
            yourMin = yourRight;
        }else{
            yourMax = yourRight;
            yourMin = yourLeft;
        }

        if(friendsLeft > friendsRight){
            friendsMax = friendsLeft;
            friendsMin = friendsRight;
        }else{
            friendsMax = friendsRight;
            friendsMin = friendsLeft;
        }

        if(yourMax == friendsMax && yourMin == friendsMin){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isSimilar(int[] a, int[] b){
        int numDif = 0;
        int firstDif = 0;
        int secondDif = 0;
        for(int i = 0;i<a.length;i++){
            if(a[i] != b[i] && firstDif == 0){
                numDif++;
                firstDif = i;
            }else if(a[i] != b[i]){
                numDif++;
                secondDif = i;
            }

        }
        if(Arrays.equals(a,b)){
            return true;
        }

        int temp = a[firstDif];
        a[firstDif] = a[secondDif];
        a[secondDif] = temp;

        if(numDif != 2){
            return false;
        }else if(Arrays.equals(a,b)){


                return true;

        }else{
            return false;
        }


    }

    public static int[] alternatingSums(int[] a){
        int[] result = new int[2];
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i<a.length;i++){
            if(i%2 == 0){
                sum1 = sum1 + a[i];

            }else{
                sum2 = sum2 + a[i];
            }
        }
        result[0] =sum1;
        result[1] =sum2;
        return result;
    }

    public static String trimandReverse(String s){
        int start = 0;
        int end = 0;
        StringBuilder input1 = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                start = i;
            }else if(s.charAt(i)==')'){
                end = i;
                input1.append(s.substring(start+1,end));
                input1 = input1.reverse();
                System.out.println("current reverse string " + input1);
                s = s.replace(s.substring(start,end+1),input1.toString());
                System.out.println("current string " + s);
                if(s.contains("(") ||s.contains(")") ){
                    i=0;
                }else{
                    return s;
                }


            }else if(!s.contains("(") ||!s.contains(")") ){
                return s;
            }
        }
        return s;
    }












    public static boolean almostIncreasingSequence(int[] sequence) {
        int numErr = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            if(sequence[i] - sequence[i+1] >= 0) {
                numErr += 1;
                if (i - 1 >= 0 && i + 2 <= sequence.length - 1
                        && sequence[i] - sequence[i+2] >= 0
                        && sequence[i-1] - sequence[i+1] >= 0) {
                    return false;
                }
            }
        }

        return numErr <= 1;
    }

    public static int matrixElementsSum(int[][] matrix) {
        int runningTotal = 0;
        for(int i = 0; i<matrix[0].length;i++){
            for(int j = 0; j<matrix.length;j++){
                if(matrix[j][i]==0){
                    break;
                }else{
                    runningTotal = runningTotal + matrix[j][i];
                }
            }
        }
        return runningTotal;
    }

    public static int absoluteValuesSumMinimization(int[] a) {
//        int sum = 0;
//        int smallest = 0;
//        int temp = 0;
//        int smallestJ = 0;
//        for(int j = 0;j<a.length;j++){
//            for(int i = 0;i<a.length;i++){
//                sum = sum + Math.abs(a[i]-j);
//            }
//            System.out.println(sum + " current j is " +j);
//
//            if(sum== 0){
//                return j;
//            }
//            if(sum<smallest){
//                smallest = sum;
//                smallestJ = j;
//            }
//            sum = 0;
//        }
        int firstCase = 0;
        int secondCase = 0;
        if(a.length%2 !=0){
            return a[a.length/2];
        }else{
            for(int i = 0;i<a.length;i++){
                secondCase = secondCase + Math.abs(a[i]-a[(a.length/2)]);
            }
            for(int i = 0;i<a.length;i++){
                firstCase = firstCase + Math.abs(a[i]-a[(a.length/2)-1]);
            }
            if(firstCase>secondCase){
                return a[(a.length/2)-1];
            }else{
                return a[a.length/2-1];
            }

        }

    }

    public static String[] interlace(String[] inputArray){
        ArrayList<String> input = new ArrayList<>();
        Collections.sort(input);
        int max = 0;
        String[] output = new String[inputArray.length];
        int totalInBewtween = inputArray.length-max;

        int beginning = 0;
        int end = 0;
        String dup = "";
        for(int i = 0;i<inputArray.length;i++){
            beginning = i;
            end = input.lastIndexOf(inputArray[i]);
            int total = end-beginning+1;
            if(total>max){
                max= total;
                dup = inputArray[i];
            }
        }

        for(int i = beginning;i==end;i++) {
            input.remove(i);
        }

        int numOfInBewtweenConsecutive = totalInBewtween/2;
        int newCount = 0;
        for(int i = 0;i<inputArray.length;i++){
            if(i ==0 || i==inputArray.length-1){
                output[i] = dup;
            }else if(newCount < numOfInBewtweenConsecutive){
                output[i] = input.get(0);
                input.remove(0);
                newCount++;
            }else{
                output[i] = dup;
                newCount = 0;
            }
        }

        return output;
    }

    public static boolean stringsRearrangement(String[] inputArray) {
        Arrays.sort(inputArray);
        boolean currentState = false;
        for(int i = 0; i<inputArray.length-1;i++){
//        inputArray[0].len
                currentState = oneMistakeOnly(inputArray[i],inputArray[i+1]);
            if(inputArray[i] == inputArray[i+1]){
                currentState = true;
            }

            if(!currentState){
                return false;
            }
        }
        return true;
    }

    public static boolean oneMistakeOnly(String word1,String word2){
        int numMistakes = 0;
        for(int i = 0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                numMistakes++;
            }
        }
        if(numMistakes==1){
            return true;
        }else{
            return false;
        }
    }

    public static ArrayList<String> allLongestStrings(String[] inputArray) {
        ArrayList<String> output  = new ArrayList<>();
        int largest = 0;
        for(int i = 0;i<inputArray.length;i++){
            if(inputArray[i].length()==largest){

                output.add(inputArray[i]);

            }else if(inputArray[i].length()>largest){
                output.removeAll(output);
                largest = inputArray[i].length();
                output.add(inputArray[i]);
            }
        }
        return output;

    }

//    public static int triangle(int n){
//        String lastLine = "";
//
//        for(int i = 0;i<n;i++){
//            for(int j = -1;j<n;j++){
//
//            }
//        }
//    }

    public static boolean palindrome(int n){
        String input = Integer.toString(n);
        String newString = new StringBuilder(input).reverse().toString();

        if(newString.equals(input)){
            return true;
        }else{
            return false;
        }
    }

    public static void prime(){
        boolean isNotPrime = false;
        System.out.println("2");
        for(int i = 3;i<101;i++){
            for(int j = 2; j<101;j++){
                if(i%j==0 && j != i && j != 1){
                    isNotPrime = true;
                    break;
                }
            }
            if(!isNotPrime) {
                System.out.println(i);
            }
            isNotPrime = false;
        }
    }
    public static double diamter(double d){
        return d*3.14;
    }

    public static void guessingGame(){
        int count = 0;
        double num = Math.random() *100;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a guess");
        String guess = sc.nextLine();
        double integerGuess = Double.parseDouble(guess);
        while (integerGuess != num){
            count++;
            if(num>integerGuess){
                System.out.println("Too low, guess again");
            }else if(num<integerGuess){
                System.out.println("Too high, guess again");
            }
            guess = sc.nextLine();
            integerGuess = Integer.parseInt(guess);
        }
        System.out.println("it took you " + count + " tries");
    }

    public static double[][] boxBlur(int[][] image) {
        double[][] output = new double[image.length-2][image[0].length-2];
        int[][] currentBox = new int[3][3];
        int count = 0;
        double average = 0;
        for(int c = 0;c<(image.length+1)-3;c++) {
            for(int b = 0;b<(image[0].length+1)-3;b++) {
                for (int i = c; i < c+3; i++) {
                    for (int j = b; j < b+3; j++) {
                        currentBox[i-c][j-b] = image[i][j];
                    }
                }
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        count = count + currentBox[x][y];
                    }
                }
                average = Math.floor(count / 9);
                output[c][b] = average;
                count = 0;
            }

        }
        return output;
    }

    public static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for(int i = 0;i<inputArray.length;i++){
            if(inputArray[i] == elemToReplace){
                inputArray[i] = substitutionElem;
            }
        }
        return inputArray;
    }


    public static int[][] minesweeper(boolean[][] matrix) {
        int[][] output = new int[matrix.length][matrix[0].length];
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int checkI = 0;
        int checkY = 0;

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){

                checkI = i-1;
                checkY = j;

                    if(checkI >=0 && checkI<matrix.length && checkY >=0 && checkY<matrix[0].length &&  matrix[i-1][j]){
                        one++;
                    }
                checkI = i-1;
                checkY = j+1;


                    if(checkI >=0 && checkI<matrix.length && checkY >=0 && checkY<matrix[0].length && matrix[i-1][j+1]){
                        two++;
                    }
                checkI = i;
                checkY = j+1;

                    if(checkI >=0 && checkI<matrix.length && checkY >=0 && checkY<matrix[0].length && matrix[i][j+1]){
                        three++;
                    }
                checkI = i+1;
                checkY = j+1;

                    if(checkI >=0 && checkI<matrix.length && checkY >=0 && checkY<matrix[0].length && matrix[i+1][j+1]){
                        four++;
                    }
                checkI = i+1;
                checkY = j;


                if(checkI >=0 && checkI<matrix.length && checkY >=0 && checkY<matrix[0].length && matrix[i+1][j]){
                        five++;
                    }
                checkI = i+1;
                checkY = j-1;

                    if(checkI >=0 && checkI<matrix.length && checkY >=0 && checkY<matrix[0].length && matrix[i+1][j-1]){
                        six++;
                    }
                checkI = i;
                checkY = j-1;

                    if(checkI >=0 && checkI<matrix.length && checkY >=0 && checkY<matrix[0].length && matrix[i][j-1]){
                        seven++;
                    }
                checkI = i-1;
                checkY = j-1;

                    if(checkI >=0 && checkI<matrix.length && checkY >=0 && checkY<matrix[0].length && matrix[i-1][j-1]){
                        eight++;
                    }

                output[i][j] = one+three+two+four+five+six+seven+eight;
                    one = 0;
                    two = 0;
                    three = 0;
                    four = 0;
                    five = 0;
                    six = 0;
                    seven = 0;
                    eight = 0;
            }
        }
        return output;
    }


}


