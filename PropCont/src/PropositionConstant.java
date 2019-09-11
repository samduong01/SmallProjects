public class PropositionConstant {

    //fields
    private String name;
    private boolean truthValue;

    //constructor
    PropositionConstant(){

    }

    //methods
    /**
     * setter for the field called name
     * @param name is the String that we want the field called name to be
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for the field called truthValue
     * @param truthValue is the boolean that we want the field called truthValue to be
     */
    public void setTruthValue(boolean truthValue) {
        this.truthValue = true;
    }

    /**
     * getter for the field called name
     * @return the String field called name
     */
    public String name() {
        return name;
    }

    /**
     * getter for the field called value
     * @return the boolean field called value
     */
    public boolean truthValue(){
        return truthValue;
    }
}
