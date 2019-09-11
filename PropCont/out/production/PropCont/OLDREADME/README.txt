Introduction:
    This program implements a PropositionConstant class which has a name and truthValue field. The program prints and changes the fields
    using getters and setters. Furthermore, this program allows the user to change the name, however, it also checks to make sure that
    the name is a valid name being it has to start with a lowercase letter and consist of only letters, numbers, and underscores. This program
    also has two stub classes which are TruthAssignment and LogicalSentences.LogicalSentence which are to be used later on.

This program full-fills the specifications by making a PropositionConstant class that has a method called truthValue that has no arguments
and returns a boolean. It also has a method called name which has no arguments and returns a String. The TestPropositionConstant class
creates an instance of PropositionConstant, then prints it's name and truth value, then changes the truth value and prints the new truth value.
It also has the two stub classes called TruthAssignment and LogicalSentences.LogicalSentence.

Classes to look at: TestPropositionConstant, PropositionConstant, LogicalSentences.LogicalSentence, and TruthAssignment.

How the code works:
    When the program is run, the program creates an instance of the class PropositionConstant with a default constructor with no arguments. Then using
    the getter methods, name() and truthValue(), it prints the default name and truthValue which is null and false. Then it asks the user to enter the
    name that they want to change it to. The program then calls the method checkInput() which recursivley checks if the input is a valid input. If
    the first character is not a lower case and if the whole string does not contain only letters, numbers and underscores using regex, then it will call
    itself again. Once it gets a valid input, the method will just return, which causes all the other calls in the stack to return. After this, it uses a setter
    method to change the name to whatever the user entered. After this, it sets the truthValue to the opposite of the old value. Then it prints out the changed
    truthValue using the getter method.

Features:
    1. This program allows the user to change the name of the PropositionConstant object
    2. Not only does it allow the user to change the name, it also recurslivey checks to see if if the new name the user entered was valid.
    3. The PropositionConstant uses getters and setters to interact with the private fields.

Hardest Part:
    The hardest part was figuring out the recursive logic for the checking of the user input.

What I Would Do Next Time:
    Next time, I would make a method inside of the Main class that changes the name, and changes the truthValue so that the code is more modular and cleaner.

Resources:
    https://dev.to/catherinecodes/a-regex-cheatsheet-for-all-those-regex-haters-and-lovers--2cj1 - used to figure out regex code

