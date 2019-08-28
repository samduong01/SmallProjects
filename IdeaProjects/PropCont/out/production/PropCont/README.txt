Introduction:
    This program checks if the string is a legal logical sentence.

This program full-fills the specifications by making having a method in the LogicalSentence class that checks if a String is a legal logical sentence.

Classes to look at: LogicalSentence, TestLogicalSentence.

How the code works:
    When the program is run, it creates an instance of LogicalSentence, then it iterates through all the Strings in the testCases array. When it calls checkLegalSentence()
    the program will then check if the string is compound. In the isCompound() method, it finds the location of the operator and then it takes the substring from 0 to
    the location of the operator and another substring from the operator's location + the operators length to the end of the string. It then calls isSimple on both of these
    substrings and if they are both simple then the compound sentence is legal. The isSimple works by finding the location of the operator and checking if the characters on
    each side of the operator are letters with length 1. Furthermore, both these functions remove spaces, tildes, and parentheses so that the logic works. In the isSimple method,
    a try catch is used because if there is an operator at the first or last element, it will catch the exception and return false.

Features:
    1. This program works if the logical sentence contains tildes, spaces, or parentheses.
    2. This program checks if any sentence is a legal logical sentence

Hardest Part:
    The hardest part was figuring out how to find the index of a regex in a String in the isCompound method.

Resources:
    https://stackoverflow.com/questions/4194310/can-java-string-indexof-handle-a-regular-expression-as-a-parameter - to find the regex location

