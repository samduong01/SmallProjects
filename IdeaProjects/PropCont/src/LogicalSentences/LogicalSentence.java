package LogicalSentences;

public class LogicalSentence {
    /**
     * determines if a string is simple
     * @param s is the String that the method is determining if it is simple
     * @return returns if a string is simple or not
     */
    public static boolean simple(String s){
        //return if the length is one, it is a letter, and it is lowercase
        return s.length() == 1 && Character.isLetter(s.charAt(0)) && Character.isLowerCase(s.charAt(0));
    }
}
