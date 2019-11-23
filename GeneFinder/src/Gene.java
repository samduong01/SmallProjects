public class Gene {
    /**
     * determines all occurences of a valid gene
     * @param s is a String input
     * @return returns a String indicating how many genes were found
     */
    public static String findGenes(String s) {
        int startIndex;
        int endIndex;
        int counter = 0;
        for(int posStartIndex = 0;posStartIndex < s.length() - 3; posStartIndex++) {
            //find start codon
            if(s.substring(posStartIndex,posStartIndex+3).equals("ATG")) {
                startIndex = posStartIndex;
                for (int posEndIndex = startIndex + 2 ;posEndIndex < s.length() -2 ; posEndIndex++) {
                    //find end codon
                    if (s.substring(posEndIndex,posEndIndex+3).equals("TAA") || s.substring(posEndIndex,posEndIndex+3).equals("TGA")||s.substring(posEndIndex,posEndIndex+3).equals("TAG")) {
                        endIndex = posEndIndex;
                        //check if it is a multiple of 3
                        if ((endIndex - startIndex) % 3 == 0) {
                            counter++;
                            System.out.println("A gene was found, it is between position " + startIndex + 1 + " and " + endIndex + 1);
                            System.out.println("    " + s.substring(startIndex, endIndex + 3));
                        }
                    }else{
                        posEndIndex = posEndIndex++;
                    }
                }
            }
        }
        return ("The program found " + counter + " genes in your genome you inputed. Thanks for using The SamGeneFinder Program!");
    }
}

