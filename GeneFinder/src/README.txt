Introduction:
    This program figures out all occurences of a gene inside a given string. It prints out to the console the gene and the location of it along with
    how many genes total it found in the end

This program full-fills the specifications by being a project of your choice

Classes to look at: Gene, Main

How the code works:
    When the program starts, the program gets the string from the user to test to see if there are any genes in it. It then calls the findGenes method
    statically. In findGenes(), the program first looks for the index in the string where the next 2 characters make the codon ATG. Once this is found
    the program goes from this starting codon and searches for either TAA, TGA, or TAG. Once one is found, if the total gene length is a multiple of 3,
    then the program will print to the console what the gene is and where it is located. Also, a counter increases. At the end of the method, a String is returned
    indicating how many genes were found.

Features:
    1. Finds location of a valid gene
    2. Prints out the gene it found
    3. Prints out total amount of genes it found

Hardest Part:
    The hardest part was making sure the program wouldn't go out of bounds.

Resources:
    I did not use any extra resources except the documentation standard and the schoology assignment



