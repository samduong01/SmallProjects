Introduction:
    This program figures out all occurences of a gene inside a given string. It prints out to the console the gene and the location of it along with
    how many genes total it found in the end

This program full-fills the specifications by being a project of your choice

Classes/Interfaces to look at: StringTesting, SubstitutableString, Main

How the code works:
    When the program starts, it creates 4 String arrays for the test cases. It then iterates through all the test cases and calls extractFirstParen and
    substituteAll on the test cases. extractFirstParen works by iterating through the String and if a ( is found, then set the startIndex to that location
    and then it will iterate through the rest of the array to find a ). It then checks the substring between the ( and ) and if it doesn't contain ( and )
    then it will return the substring. It also has a try catch for this so that if no ( or ) is found, the .substring will not throw and error. The catch
    returns no substring found as if no ( or ) is ever found, that means there is no substring in the first place. The substituteAll works by using the
    java built in method to replace all occurences of b in String a with String c.

Features:
    1. This program finds the first subtring delimited by parentheses that contains no parentheses
    2. Has an array of test cases to organize data in a more readable way
    3. This program replaces all ocurrences of String b inside of String a with String c

Hardest Part:
    The hardest part was figuring out how to make extractFirstParen with all the edge cases

Resources:
    I did not use any extra resources except the documentation standard and the schoology assignment



