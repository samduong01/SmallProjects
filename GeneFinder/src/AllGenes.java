import java.util.Scanner;
public class AllGenes {
    public static void main(String[] args) {
        System.out.println("SamGeneFinder: This is a gene finder program.");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a genome string. Please do not enter a genome longer then 2,147,483,647 bases. Then the program will find genes if there are any:");
        String geneString = scan.nextLine();
        System.out.println(scanGene(geneString));

    }
    public static String scanGene(String geneString) {

        int startIndex = 0;
        int endIndex = 0;
        String geneOrGenes = "gene";
        int startCodon, endCodon;
        int counter = 0;
        for(int posStartIndex = 0;posStartIndex < geneString.length() - 3; posStartIndex++) {
            if(counter>1){
                geneOrGenes = "genes";
            }
            if(geneString.substring(posStartIndex,posStartIndex+3).equals("ATG")) {

                startIndex = posStartIndex;
                for (int posEndIndex = startIndex + 2 ;posEndIndex < geneString.length() -2 ; posEndIndex++) {

                    if (geneString.substring(posEndIndex,posEndIndex+3).equals("TAA") || geneString.substring(posEndIndex,posEndIndex+3).equals("TGA")||geneString.substring(posEndIndex,posEndIndex+3).equals("TAG")) {

                        endIndex = posEndIndex;
                        if ((endIndex - startIndex) % 3 == 0)
                            counter++;
                            System.out.println("We found a gene! It is between position " + startIndex +1 + " and " + endIndex + 1);
                            System.out.println("    " + geneString.substring(startIndex,endIndex + 3));
                    }else{
                        posEndIndex = posEndIndex++;
                        continue;
                    }
                }

            }
        }
        return ("We found " + counter + " " +  geneOrGenes + " in your genome you inputed. Thanks for using The SamGeneFinder Program!");
    }
}

