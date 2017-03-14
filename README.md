# UNIT Testing, Testable Code, Mocking and Code Coverage
### A solution to demonstrate the exercise "UNIT Testing, Testable Code, Mocking and Code Coverage".
#### By Emil, Rune, Ebbe & Dennis

First of we started by refactoring the code to follo the SOLID principles. So instead of the just following the guide we
tried to do it without:

### DateFormatter.class
We started of by refactoring the DateFormatter.java class and implemented a constructor that took the date and simple
formatter as an argument.

Created a private method which communicated with the TimeZone.getAvailableIDs() and throws either an exception or returns a
string array.

Implemented getters and setters.

Created a custom exception InvalidTimeZoneException.java to be thrown if the specific timezone was not present in the TimeZone.getAvailableIDs(). 

#### Test of DateFormatter.class
Made a parameterized test of the getFormattedDate that tested two timezones and one invalid timezone. For the invalid
TimeZone we test that the InvalidTimeZoneException is thrown.

It uses a BeforeClass to create a date and format it to make sure that the test will always run with the same date.

### JokeFetcher.class
We refactored the JokeFetcher substantially. 

We implemented an ENUM type instead of using the List<String> availableTypes, thereby insuring that it's not possible
to use an incorrect type. This also meant that we could remove the isStringValid and getAvailableTypes methods from the class.

Moved the jokesToFetchArray out of the getJokes method and into the main method and then passed it as an argument to the getJokes

Made an interface with one method, retrieveJoke() and made the Joke.java class implement the interface. At the same time
made the Joke.java class abstract and used polymorphism to create subclasses of the joke class, each representing a specific
joketype and overwriting the retrieveJoke to implement their specific implementation of the http call. Afterwards we removed
all the getJoke methods in the JokeFetcher.java class.

Removed the switch case from the getJokes to be able to mock it out later on.

Created a getDate method to return a date representing current date and time.

Created a localeDateString to use the getDate to create a locale representation of a date in the formate dd MMM yyyy hh:mm aa.

#### Test of JokeFetcher.class
After alot of problems with the mockito library we chose to follow the guide instead and, but after some more studying we
found out that it was actually possible to test the program with the changes that we made. So we made a test of the
getJokes method that mocks out the generateJokesList to return a psuedo joke { joke: "Hej", reference: "Hej" } and then
test that when calling the getJokes it then retrieves this joke.

To see how far we got without the guide see [link](https://github.com/tjaydk/TestMockHandIn).

#### Test made after following the guide
We peserved the enums an some of the other things that we had made but implemented the factory pattern as described in the
guide.
After following the guide we created a new test for the JokeFetcer.java class

##### Test of JokeFetcher.class (after guide)
Tested that the IFactory contained all the factories that is passed as an argument, still using the enum types.

##### Test of JokeService.class
Mocked out the DateFormatter, FetcherFactory and all the JokeFetchers. Calling the retrieveJoke insure that the method is
called in the different factories and that the jokes contain the values specified.


#### Using IntelliJ Code Coverage here is the results from our tests

| JokeService.java | 100% (1/1) | 100% (3/3) | 100% (18/18) |
|------------------|------------|------------|--------------|

