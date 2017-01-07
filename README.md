# Coin-Simulator
simulate the coin toss process


Introduction

In this assignment you will write a graphics-based program to simulate someone tossing a pair of coins some number of times, and display the results. So for example the user may request 10 trials. For each trial two coins are tossed. The program reports in bar graph form how many times the result was two heads, how many times it was two tails, and how many times it was one of each.

This assignment will give you practice with creating and implementing classes, using loops, using the java library for random number generation, doing console-based IO, and drawing to a graphics window. Also you'll get practice in general program development.


Resources

Horstmann, Section 2.9, 2.10, 3.8, How-to 3.2 Programs that draw stuff
Horstmann, Chapter 3, Implementing Classes
Horstmann, Section 4.3.1, Reading input
Horstmann, Section 6.9.1, Random numbers and Simulations
The assignment files

Getting the assignment starter files. Note: these instructions assume you are logged into your scf account (i.e., on aludra). On your scf account make a pa1 directory and cd into it. Copy all of the source code files and the README starter file from the pa1 directory of the course account to your own pa1 directory. We can accomplish the first part with Unix wildcards (denoted with a *): the first command below copies all files that have a .java suffix from the given directory to your current directory. Do the following two commands:
cp ~csci455/assgts/pa1/*.java .
cp ~csci455/assgts/pa1/README .
The files in bold below are ones you create and/or modify and submit. The files are:

CoinTossSimulator.java Your CoinTossSimulator class. The public interface is provided. You will be completing the implementation and a test driver for it.
Bar.java A Bar class. The public interface is provided. You will be completing the implementation of it.
CoinSimViewer.java Your CoinSimViewer class. You create this file and class.
CoinSimComponent.java Your CoinSimComponent class. You create this file and class.
CoinTossSimulatorTester.java Your unit test program (a.k.a., test driver) for your CoinTossSimulator class. You create this file and class.
README for more about what goes in this file, see the section on README file. Before you start the assignment please read the following statement which you will be "signing" in the README:
"I certify that the work submitted for this assignment does not violate USC's student conduct code. In particular, the work is my own, not a collaboration, and does not involve code created by other people, with the exception of the resources explicitly mentioned in the CS 455 Course Syllabus. And I did not share my solution or parts of it with other students in the course."
For more information about the classes mentioned above see the section on class design.
The assignment

Initially your program will prompt for the number of trials to simulate (a trial is two coin tosses) on the console, error checking that a positive value is entered. (More details about error checking here.) This part of the program will be console-based, to keep things simpler (and faster if you are running it from aludra).
Then it will run the simulation and display a 500 tall by 800 wide pixel window with the results of that simulation. The results will consist of three labeled bars, each a different color, to show how many trials had the specified outcome. The label will show what the outcome was (e.g., Two Heads), the number of trials that had that result, and the percentage of trials that had that result (rounded to the nearest one percent). Because the simulation uses random coin tosses (simulated using a random-number generator) subsequent runs with the same input will produce different results.

Here is a screen-shot of output from one run of our solution to this assignment, where we do 1000 trials:

 

Remember, your output will not be identical to this because of the random nature of the results.

Note the placement of each of the bars evenly across the window. In addition, the height of each bar is given so that 100% would fill up most of the height of the window (but not run into the top of it). Thus the 48% of trials that resulted in a head and a tail in the example above fills up roughly half of the height of the window.

Also, your bar graph should get resized appropriately if the window gets resized. As mentioned in the textbook, every time a window gets resized or iconified and de-iconified paintComponent gets called again. Here's a later screen-shot of during same run shown above, but after the window had been resized:

 

Note that resizing the window does not change the results of the simulation.

Here's an example illustrating what the display looks like when all of the trials have the same result, forced here by only doing one trial (screen-shot shows the window after it was resized smaller):

 

More about the graphics library methods necessary to get these results in the section on Graphics programming.

There are a few other requirements for the assignment discussed in the following sections. To summarize here, the other requirements are:

you must create and use the classes mentioned in the section on Class design.
you must create a working test program for your CoinTossSimulator class, describe further in the section on Testing the CoinTossSimulator class.
you must edit and submit README file discussed in the section about that. Do not wait until you are about to submit the program to answer the README questions, because they involve further tests of your program, and you may discover a bug during that testing.
your program will also be evaluated on style and documentation. More about this in the section on grading criteria.

More details of the error-checking

As mentioned in the previous section, when your program prompts for the number of trials, you will error check that a positive value is entered. More specifically, we mean that on an invalid number of trials the program will print out a informative error message and then prompt and read again until the user enters a valid value. Example (user input shown in italics):
Enter number of trials: -5
ERROR: Number entered must be greater than 0.
Enter number of trials: 0
ERROR: Number entered must be greater than 0.
Enter number of trials: 100
Your program does not have to handle non-numeric input. (We will not test it on that case.)

Class design

To help you make your program object-oriented, we are giving you the general class design for this program. This follows the conventions of graphical classes used in the textbook (see Resources, near the beginning of this document, for relevant textbook readings). In particular, this general design follows the one in Section 3.8 of the textbook that has a viewer, a component, and a graphical object that can get instantiated multiple times and drawn in different locations on the screen (in that one the object class is a Car, here it's the Bar). You are required to use the following classes (ones in bold are ones you will be creating yourself or implementing):
CoinSimViewer. Contains the main method. Prompts for the number of trials, and creates the JFrame containing the CoinSimComponent. Besides CoinSimComponent, this class does not depend on any of the other classes mentioned here (e.g., if one of those other classes changed, CoinSimViewer would not have to change.) The later section on communicating information between objects will be useful when developing this and the next class listed.
CoinSimComponent. Extends JComponent. Constructor initializes any necessary data and runs the simulation. Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. This class uses the CoinTossSimulator and Bar class.
CoinTossSimulator. This is the class responsible for doing the simulation. It has no graphical output, and in fact, does no I/O to the console either. It has a run method to run a simulation of tossing a pair of coins for some number of trials. It has accessors to get the results of the simulation. Subsequent calls to run add trials to the current simulation. To reset the CoinTossSimulator to start a new simulation, call the reset method. For examples of how it operates, see the sample output of the test program from the section on testing this class.
We are giving you the exact interface to use for this class. By interface, we mean what clients need to know about the class to use it, i.e., the method headers and associated method comments. Do not change the interface when you incorporate it into your own program: we are going to test your CoinTossSimulator class with our own test driver; if you change the interface, it won't compile with our code.

CoinTossSimulator does not depend on any of the other of our classes or the graphics library. It does use Random (described further below). The skeleton code for CoinTossSimulator is in ~csci455/assgts/pa1/CoinTossSimulator.java.

Bar. For drawing a bar in a bar graph. You specify the dimensions and color of the bar in the constructor. The only other method is draw which draws the bar given. We are giving you the exact interface to use for this class. So the same things about this apply as mentioned in the above description of CoinTossSimulator. Bar does not depend on any of the other of our classes, but does use the graphics library. The skeleton code for Bar is in ~csci455/assgts/pa1/Bar.java.
CoinTossSimulatorTester. A program to test your CoinTossSimulator class independently from its use in the CoinTossViewer program. It will have its own main method. This class is described in more detail in the section on testing the CoinTossSimulator class.
java.util.Random. The java random number generator. See section 6.9 of the textbook for examples of its use. One thing to note about Random: it's a class that through a sequence of method calls generates a sequence of values that depend on the internal state of the object (in this way it is similar to Scanner). Students often want to create a new Random object every time they want a new random number. Don't do that. Instead, normally you create one Random object in your program, and then whenever you want a new random number you make another call to nextInt on that same object. (If you create a Random object every time you are not generating a pseudo-random sequence, although it will appear that you are.)
Note: this list doesn't include all the java library classes that will be used in the program; for example CoinSimComponent will need java.awt.Graphics.

Incremental development

Any program of non-trivial size will be developed faster, with fewer bugs, using the technique of incremental development, which means developing, and testing, pieces of the program incrementally. The incremental aspect is that your program may gradually grow until it includes the complete functionality. (Other people use different names for the same thing. Sometimes it's called building subsets.)

A desirable feature of individual classes is that they are as independent as possible from a program that uses them. Some classes, such as String, or ArrayList (which we will see soon) are general-purpose and can be used in many different programs. Other classes are more special-purpose, such as CoinTossSimulator, but still are modules that can be separated from a particular program that uses them. We can test such a module using a unit-test, which is a program specially designed to test the module.

We often unit-test one (or more) classes, and then once we are convinced that unit is working correctly, we can integrate that class with other code that uses it. If this larger code base is now buggy, we can feel fairly certain that the bug is in the new code we added, since we already tested the first class. So any time we find bugs, it's in a small program: much easier than locating bugs in large programs.

Similarly, if we make later changes or enhancements to our client program our code will be more robust in the face of these changes because, in our unit test, we tested the module in ways not specific to how it was used in the earlier version of the program. (As you have experienced as a user, software is always getting changed over time, e.g., the latest version of Windows is in the double-digits.) For example, in this assignment, there are methods and method functionality of CoinTossSimulator that are not used by the program that draws the bar graph, but you could never be sure whether they worked if you didn't test them.

For this assignment, the final product will not be a very large program, but we want to get you in the practice of using incremental development, so you will still be successful when you are trying to develop and debug much larger programs. Even in this program there are at least two distinct issues to deal with: (1) figuring out how to use the random-number generator to do a coin-toss simulation and (2) figuring out how to do the graphics to draw the results of the simulation. It will be much easier if we can deal with these issues one at a time, so we can isolate bugs related to each one more easily. For this assignment you are required to write a console-based Tester class to test our CoinTossSimulator class (such unit test classes were discussed in section 3.4 of the text). This test program is described in more detail in the next section.

Similarly, you could test your Bar class, apart from its use in this particular bar graph by creating several bars with hard-coded data or data from the keyboard using a Scanner. We won't require you to submit such a BarTester program for this assignment, however.


Testing the CoinTossSimulator class

You are actually going to submit two programs for this assignment, both of which use your CoinTossSimulator class. One is CoinTossViewer, described earlier, that has a graphical display. The other is a console-based program, CoinTossSimulatorTester, expressly written to thoroughly test your CoinTossSimulator class, without including the drawing functionality of the CoinTossViewer program. The rationale for unit tests was discussed in the previous section.
We will use a different compile command to compile each of these programs. We can compile and run the test program with the following commands:

javac CoinTossSimulatorTester.java
java CoinTossSimulatorTester
while we compile and run the larger program with these commands:
javac CoinSimViewer.java
java CoinSimViewer
Although each of these are multi-file programs you only need to list the file that contains main in the compile command and javac figures out what other classes are used in that program and compiles those as well. Similarly, the only class name you give as the argument to the java virtual machine is the one containing main.
As mentioned in the previous section a test program like CoinTossSimulatorTester is called a unit test; we have discussed such unit tests in lecture, and they are also discussed in Section 3.4 of the textbook. One goal of this test program is for you to test its full functionality of the CoinTossSimulator class. Its use in the CoinSimViewer program does not test the full functionality. In particular, with the CoinTossSimulator you can do multiple calls to the run method to add more trials to the ones already made. Only if you call reset does it reset the simulation back to its beginning state (i.e., no trials done yet).

So, what should you put in your CoinTossSimulatorTester? This will be a console-based program -- i.e., no GUI. It will be a non-interactive program (i.e., fixed data), that tests every method multiple times, printing informative output to the console with the results of each operation.

Unlike the unit-test programs in the textbook and lecture, we can't predict the exact results of calls to run, because of the random nature of the program. Instead, write code to test that the sum of the number of two-head tosses, two-tail tosses, and head-tail tosses add up to the total number of trials. (Hint: In the sample output below, we display true or false for this result by just printing out the result of a boolean expression.)

Your output should look like the following. This shows only part of a sample run of our tester program: (Note: the part in italics is not the literal output you should produce, but describes what we left out here. The parts in red are parts we would like you to pay particular attention to here -- your output will not appear in red.)

After constructor:
Number of trials: 0
Two-head tosses: 0
Two-tail tosses: 0
One-head one-tail tosses: 0
Tosses add up correctly? true

After run(1):
Number of trials: 1
Two-head tosses: 0
Two-tail tosses: 1
One-head one-tail tosses: 0
Tosses add up correctly? true

After run(10):
Number of trials: 11
Two-head tosses: 2
Two-tail tosses: 3
One-head one-tail tosses: 6
Tosses add up correctly? true

After run(100):
Number of trials: 111
Two-head tosses: 28
Two-tail tosses: 30
One-head one-tail tosses: 53
Tosses add up correctly? true

[ . . . output for tests with different number of trials were here . . .]

After reset:
Number of trials: 0
Two-head tosses: 0
Two-tail tosses: 0
One-head one-tail tosses: 0
Tosses add up correctly? true

After run(1000):
Number of trials: 1000
Two-head tosses: 265
Two-tail tosses: 229
One-head one-tail tosses: 506
Tosses add up correctly? true

[ . . . output for tests on more runs were here . . .]

Remember you won't get these exact numbers because of the random nature of the simulation.

Hints on graphics programming

Most of the graphics primitives you will need for this program are covered in the graphics sections at the end of Chapters 2 and 3 of the textbook, except for a few things we will discuss here. So, you should not need to go hunting through the online documentation or random websites to figure out how to do the necessary drawing. More specifically: how to draw a filled rectangle is illustrated in the alien face example in textbook section 2.10.4; and the start of the section of this assignment on class design discusses another example from the textbook that has a similar object-oriented design to this one.
Your program may use a fixed size for the width of each bar, and for the buffer-space between the tallest possible bar plus its label and the top and bottom of the window (the solution whose results we showed earlier also does this). Any such constants in your program need to be named constants (see section on grading criteria below, for more information). For the purposes of this assignment you do not have to worry about the fact that if we make the window small enough horizontally, the labels centered under each bar, and eventually the bars themselves will start running into each other.

(Note: named constants would also be helpful to map the bar colors to what they are used for, e.g., constant HEAD_TAIL_COLOR.)

As illustrated earlier, the height and the spacing of the bars in the bar graph will depend on the size of the window they are displayed in. The JComponent methods, getWidth() and getHeight(), which get the width and height of the component, will come in handy here. Since CoinSimComponent is a subclass of JComponent you can directly call those methods from your component object. (Similar to how we could call the inherited get and set methods from GregorianCalendar objects in lab 2, even though they were defined in the superclass, Calendar.)

To make sure all the necessary information appears on the window and in the right place, you will also need to know the dimensions of the label you will be displaying (here we'll just use the default font size for the given graphics context). This is not covered in the textbook, so here is a code snippet:

   String label = "Hello, world!";   // suppose this is the label you want to display
   Font font = g2.getFont();
   FontRenderContext context = g2.getFontRenderContext();
   Rectangle2D labelBounds = font.getStringBounds(label, context);
   int widthOfLabel = labelBounds.getWidth();
   int heightOfLabel = labelBounds.getHeight();

How to communicate information between objects

There are several techniques to communicate information between classes and methods of classes, including via parameters and return values of methods. In particular, here we have the issue of receiving some information in main in CoinSimViewer, that is, the number of trials, but needing to use that information in the component. To do this, your CoinSimComponent class will need to have its own constructor (Note: this is different than the component examples in the book). From main you can pass the information to that constructor, and then, if you also need access to it in other methods, you would save it in an instance variable.
Recall that you never will be calling paintComponent yourself, nor are you allowed to change the parameters to it.


README file

For this and all other programs you will be required to submit a text file called README with your assignment. In it you will initial the certification we mentioned earlier. This is also the place to document known bugs in your program. That means you should describe thoroughly any test cases that fail for the the program you are submitting. (Not your bug history -- just info about the version you are submitting.) You should also document here what subset your solution implements if you weren't able to complete the whole program (more about that in the next section). You can also use the README to give the grader any other special information, such as if there is some special way to compile or run your program (this would be unusual for students who complete the assignment).
For this program, also put the answers to the following questions in the README:

What is the probability of each of the three outcomes in a trial: two heads, one head and one tail, and two tails? Why is one of them different than the other two?
Roughly how many trials do you need to do before you mostly get results within 1% of these probabilities? Do several simulations using your program to determine an answer to this. You just need a general order of magnitude, not an exact answer.
Roughly how many trials can you do before it crashes with an overflow error? (you do not need an exact answer, just an order of magnitude) State the largest value you tried where it still worked correctly, and one where it overflowed. You can get an idea of what general values to try by looking at the limits on Java integers (see Section 4.1.1 of the text). Play around with your program to verify that it actually works for very large values that are within the limits. Warning: For very large values you may have to wait a fair amount of time before you get the results (probably slower on aludra than on you own machine).
Grading criteria

This program will be graded based on correctness, style, and testing. Programs that do not compile will get little or no credit. However, an incomplete program can get some correctness points if it has partial functionality (you document the partial functionality in the README, discussed above). This grading policy is to encourage frequent testing of subsets (discussed earlier in the section on incremental development). Also, for incomplete programs, the style score will be scaled according to how much is completed.
We have published a more complete set of style guidelines for the course on the assignments page, but here are a few things to pay particular attention to for this program:

documentation. You need to supply an overall comment for each class, and detailed comments about the interface of each method (so called method comments). (We have already provided the interface comments for the CoinTossSimulator and Bar classes since we specified those interfaces for you.) This was described in more detail in lecture and the textbook (see Section 3.2.4). Use in-line comments to explain any confusing code ("this is a for loop" type comments are not helpful).
named constants. There are some numbers mentioned in the assignment description as well as other values that are described to be fixed in the program. Each of these should be given a descriptive name (e.g., BAR_WIDTH) in the program so it would be easy to change the value later. Named constants in Java are discussed in section 4.1.2 and programming tip 4.1 in the textbook.
private data. You should never need public data. Rather, clients should only be able to access data through methods The rationale for this is discussed in section 3.1.3 of the textbook.
good identifier names. Use descriptive names for variables, parameters, and methods. Also use Java naming conventions. Details in item 6 of course style guidelines. Sections 2.2.3 and 4.1.2 of the textbook discuss more about naming.
good/consistent indenting. Use the conventions from the textbook or lecture.
For this program only, you do not have to worry too much about method length (guideline #7), and while you should document any instance variables that are not obvious from their names, you do not have to worry about representation invariants (item #15).
Implementing the required class design and answering the README questions will also be part of your style/documentation score.

How to turn in your assignment

Make sure your name, loginid, course, and assignment are at the top of each file you submit (for source files, they would be inside of comments), for any assignment you submit for this course. You will lose a point on the assignment if this information is missing.
No matter where/how you developed the code, we will be grading it on aludra using the java compiler and virtual machine there.

If you developed your code locally on your own machine (e.g., using eclipse, or a local copy of javac with some text editor on your machine): First you will need to upload your source files to your account on aludra. There are directions on how to do so in a link from the Documentation page labeled Transferring files to aludra . Then you will need to make sure it compiles and runs on aludra (redo all of your tests). Then follow the directions in the following paragraph.

How to submit your program Make sure you are logged into your aludra account. If your assignment solution is not on your aludra account, follow the directions in the previous paragraph first. To submit your assignments you will use an aludra Unix command called submit. You need to execute this command from the directory on your scf account that contains the files you wish to submit. So you don't make a mistake providing the arguments to this command, we have provided the exact command to use in a file called turninpa1 (please take a look at it). This type of file that contains Unix commands is called a shell script (this one is a very simple shell script). To execute the commands in this shell script, you type:

source ~csci455/assgts/pa1/turninpa1
at the Unix prompt. It uses the exact file-names shown in bold earlier in the section about the assignment files. The submit command it runs should output a message for each of the five files saying it was submitted successfully:
Submitting file "README" to "csci455" ... SUCCEEDED.
Submitting file "CoinSimViewer.java" to "csci455" ... SUCCEEDED.
Submitting file "CoinSimComponent.java" to "csci455" ... SUCCEEDED.
Submitting file "CoinTossSimulator.java" to "csci455" ... SUCCEEDED.
Submitting file "CoinTossSimulatorTester.java" to "csci455" ... SUCCEEDED.
Submitting file "Bar.java" to "csci455" ... SUCCEEDED.
If you get a FAILED message for any of the files instead, that means it did not get submitted. (It's probably because you were in the wrong directory or you do not have a file by that name.) If you get something like "command not found", that means it did not get submitted, and you are probably not logged into aludra: reread from the start of this section to see what to do. Once you fix the problem you can just call turninpa1 again. If you call submit multiple times with the same file names and options, the last version submitted is the one that will be graded: each submit of a particular file overwrites the previous one.
