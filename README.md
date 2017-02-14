## Triangles

---
### Statig Code Analysis of Triangle program

#### a) Install Metrics software in your IDE (see tool examples in slides)
Done

#### b) Check coding standards in your Triangle program
```
1>------ Rebuild All started: Project: Triangles, Configuration: Debug Any CPU ------
1>  Triangles -> Triangles.exe
1>  Running Code Analysis...
1>  Code Analysis Complete -- 0 error(s), 0 warning(s)
========== Rebuild All: 1 succeeded, 0 failed, 0 skipped ==========
```

#### c) Calculate central metrics in your Triangle program
![Central Metrics](http://i.imgur.com/N64E56X.png "Central Metrics")

#### d) Find out what CC variation that your metrics tool uses
The Code Metrics tool in Visual Studio 2015 uses CC1. This is a fact because booleans do not increase the cyclomatic complexity, 
but every conditional (if/switch) does.

#### e) Possibly refactor your code based on static testing results
View latest commits.

### Peer Review of your Triangle program
#### Exchange your Triangle solution with another student
I have reviewed [this project](https://github.com/NicolaiVBonderup/TestExercises/blob/TriangleCalc/TestExercises/TestExercises/Program.cs) from Nicolai Bonderup

#### Inspect the other student’s implementation and write down your comments
###### Summary
The solution provides a graphical user interface, where the user can input a value for each of the sides in the triangle.
It is not possible to crash the program by giving an invalid input. The program compares the inputs with each other, 
and tells which triangle type they form, however it is not matching the inputs with the Triangle Inequality Theorem. 
The code is easily readable, but could be slightly more maintainable if the calculation logic was seperated from the GUI application.

###### Pros
- Provides a graphical user interface.
- Checks the triangle type, by comparing the length of the sides.
- Checks whether the input is an 32-bit Integer.
- The code is easily readable.

###### Cons
- Doesn't check if the sides can actually form a triangle.
- Calculation logic is not seperated from the Main class.

#### Coding Standard Document
- Follow a specific code style
- Consistent indentation
- Consistent line breaks
- Block grouping
- Consistent variable naming
- Consistent class naming
- Consistent file naming
- DRY Principle
- Return early instead of deep nesting
- Class/method documentation



