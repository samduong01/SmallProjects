Introduction:
    This program draws a US flag with the standard US flag proportions and scales the flag based on the user input. The user
    can drag the window of the flag to change the size of the flag. The flag will then scale based on the height of the window.

This program full-fills the specifications by producing an applet or application which displays the United States flag to scale.

Classes to look at: Main, FlagFrame

How the code works:
    When the program runs, the program creates an instance of FlagFrame with a default scale of x600. It then sets all the scale
    constants to their respective values. It then calls paint() which updates the scale to the height of the frame. THen it
    creates a new Graphics2D object by casting the g Graphics object to Graphics2D. This is done so the program can create a star
    using the Graphics2D object. It then draws the stripes by calling drawStripes() which draws 7 red rectangles at equal intervals.
    It then calls drawBlueBox() and draws a blue box at the position of the last stripe. It then calls drawStars() which draws 9 rows
    of 4 or 5 stars depending if it is an even or odd row. It draws the stars by using using Path2D and cos and sin to figure out the
    angle and draw each "arm" of the star. It then draws a black bounding box around the whole flag. Inside the paint method, the scale
    field is constantly updated to the height of the window, since scale is updated, all the proportion fields are updated accordingly.

Features:
    1. This program draws a scaled US flag
    2. This program allows the user to change the size of the flag while keeping the flags proportions the same by dragging the window

Hardest Part:
    The hardest part was figuring out how to draw the stars.

Resources:
    I used the Java Docs for using Path2D to figure out how to draw a star and http://mathworld.wolfram.com/StarPolygon.html
    to figure out the math to draw a star. I also used the documentation standard and the schoology assignment.