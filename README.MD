### Code Coverage

##### How much of the code is covered by test cases to start out?

| Class                         | Class, %   | Method, %  | Line, %    |
|:------------------------------|:----------:|:----------:|:----------:|
| DayService                    | 100% (1/1) | 100% (1/1) | 85% (6/7)  |
| ReimbursementService          | 100% (2/2) | 100% (3/3) | 87% (7/8)  |
| InvalidMonthException         | 100% (1/1) | 100% (1/1) | 100% (2/2) |
| InvalidYearException          | 100% (1/1) | 100% (1/1) | 100% (2/2) |
| InvalidReimbursementException | 100% (1/1) | 100% (1/1) | 100% (2/2) |

##### Could and should the code coverage of your project be raised?
No. The only thing that isn't covered it literally the class instantiation, because i'm using static methods.
Obtaining 100% code can be a requirement from a customer, and in this case we would have to try meeting the 
requirements. However, achieving 100% code coverage can in some cases be practically impossible. In this case,
where we have a static utility class which is never instantiated, we would have to go out of our ways to achieve
100% code coverage, which provides no value at all for our customer.

##### How could be achieve 100% code coverage?
If we absolutely needed 100% code coverage, we could achieve it by doing the following: 
When we implement a static-only class, we can add a private constructor to ensure that instances 
of the class can't be created. We can then throw an exception in that constructor, and write a test 
which finds the class by name, sets the constructors access to public through 
a setAccessible() call, calls the constructor and then asserts that the exception is thrown.

![bla](https://media.giphy.com/media/XreQmk7ETCak0/giphy.gif)