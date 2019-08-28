Introduction:
    This program checks which Strings inside an array is simple or not. It also determines if a set of boolean arrays is valid, contingent, or unsatisfiable.

This program full-fills the specifications by having a simple() method that determines if a String is simple, a valid() method that determines if a boolean
array is valid, a unsatisfiable() method that determines if a boolean array is unsatisfiable, and a contingent() method that determines if a boolean array
is contingent.

Classes to look at: LogicalSentence, TestLogicalSentence, TruthColumn

How the code works:
    When the program works, the program initializes an array of Strings with pre-made test values and initializes an array of boolean arrays (matrix). It
    then iterates through the array of Strings and prints if each element is simple or not. It then iterates through all the boolean arrays in the array and
    prints if the boolean array (truth column) is either valid, contingent, or unsatisfiable. The simple method works by taking a String and returns if it
    has a length of one, it is a letter, and it is lowercase. The valid method works by iterating through the array and if it sees a false, then that means
    the array is not valid. If it gets to the end of the whole array without returning, then that means it's valid and returns true. The contingent method
    works by iterating through the array and if it sees a false, a boolean called foundFalse is set to true, and the same goes for if a true is found. Then
    after it finishes the loop, if both booleans are true, then the boolean array is contingent. The unsatisfiable method works by iterating through the array
    and if the there is a true, then it will return false. If it gets to the end of the array without returning, then it will return true, meaning that it is
    unsatisfiable.

Features:
    1. This program determines if a String is simple or not
    2. This program determines if an array of booleans is valid, contingent, or unsatisfiable.
    3. This program uses multiple test cases organized inside of arrays to test these methods and prints the results to the console.

Hardest Part:
    The hardest part was figuring out how to organize my array of boolean test cases.

Resources:
    I did not use any extra resources except the documentation standard and the schoology assignment



