import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("SamGeneFinder: This is a gene finder program.");
        System.out.println("Enter a genome string");
        String geneString = sc.nextLine();
        System.out.println(Gene.findGenes(geneString));
    }
}
