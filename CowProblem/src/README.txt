Introduction:
    This program draws a cow with a different arrangements of spots every time you run the program. Furthermore,
    the program allows the user to enter a new location where they want the cow to be placed on the screen.

This program full-fills the specifications by drawing a cow.

Classes to look at: Main and CowFrame

How the code works:
    When the program is run, the console will ask you if you want to change the cow's default location. If the user enters yes,
    the program will ask what coordinates they want the cow to be at and initialize the CowFrame object with the constructor that
    assigns the CowFrame's x and y location as what the user entered. If the user did not want to change the Cow's default location,
    the CowFrame object is initialized using the default constructor that has the default x and y values. In the cow class, the background
    is set to sky blue to act as the sky. Then, in the paint method the drawGrass, drawLegs, drawBody, drawHead, drawEyes, drawEars, drawTail,
    and drawMouth methods are called.

    Randomly Generate Spots:
    The way the drawSpots method works is for each of the 10 spots it needs to draw, it will randomly generate a number between 0 and 1000 for
    the x and y. 1000 that way no matter where the cow is the spot will always be on the cow. Then, it will check to see if the spot is inside
    on cows body. If it is not inside the cows body than it will not draw the spot and do another iteration of the loop. In addition, the the
    program will randomly choose if the spot it draws will be white or brown by checking if Math.random() is less than 0.5.

Features:
    1. Not only does the program draw a cow, it allows the user to enter a x and y coordinate
       for where the cow will be placed.
    2. Every time you run the program, the cow will randomly generate 10 spots on the cow that
       are randomly generated as either white or brown

Hardest Part:
    The hardest part was figuring out the constants for the spacing between all the parts of the cows.

What I Would Do Next Time:
    Next time, inside the drawSpots() method, I would take out the if statement that checks if the spot is inside the cows body and just make
    the x and y values be assigned values that are already inside the body box. I would do this by setting x = minX + (int)(Math.random() * ((maxX - minX) + 1))
    and y = minY + (int)(Math.random() * ((maxY - minY) + 1)).

Resources:
    https://www.rapidtables.com/web/color/RGB_Color.html - used to figure out color rgb

