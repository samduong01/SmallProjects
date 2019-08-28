package LogicalSentences;

public class TruthColumn {
    /**
     * determines if an array of booleans is contingent
     * @param booleans is the input of array of booleans
     * @return returns if an array of booleans is contingent or not
     */
    public static boolean contingent(boolean[] booleans){
        //boolean values for if a false or true is found
        boolean foundFalse = false;
        boolean foundTrue = false;
        //iterate through array and if a false is found set foundFalse to true
        //if a true is found set foundTrue to true
        for(int i = 0;i<booleans.length;i++){
            if(booleans[i]){
                foundTrue = true;
            }else{
                foundFalse = true;
            }
        }
        //if both are true, return true, else return false
        return foundFalse && foundTrue;
    }

    /**
     * determines if an array of booleans is unsatisfiable
     * @param booleans is the input of array of booleans
     * @return returns if an array of booleans is unsatisfiable or not
     */
    public static boolean unsatisfiable(boolean[] booleans){
        //iterate through the array and if a true is found then return false. If the program gets to the end of the array then return true
        for(int i = 0;i<booleans.length;i++){
            if(booleans[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * determines if an array of booleans is valid
     * @param booleans is the input of array of booleans
     * @return returns if an array of booleans is valid or not
     */
    public static boolean valid(boolean[] booleans){
        //iterate through array and if there is false, return false, and if the program goes through the whole array, return true
        for(int i = 0;i<booleans.length;i++){
            if(!booleans[i]){
                return false;
            }
        }
        return true;
    }
}
