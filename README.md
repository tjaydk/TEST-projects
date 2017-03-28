# Selenium Test Hand-In

## 1. Discuss Pros and Cons with manual versus automated tests
### Pros of Automated Testing:
1. Runs tests quickly and effectively
While the initial setup of automated test cases may take a while, once you’ve automated your tests, you’re good to go. You can reuse tests, which is good news for those of you running regressions on constantly changing code. You won’t have to continuously fill out the same information or remember to run certain tests. Everything is done for you automatically.

2. Can be cost effective
While automation tools can be expensive in the short-term, they save you money in the long-term. They not only do more than a human can in a given amount of time, they also find defects quicker. This allows your team to react more quickly, saving you both precious time and money.

3. More interesting
Filling out the same forms time after time can be frustrating, and not to mention boring. Test automation solves this problem. The process of setting up test cases takes coding and thought, which keeps your best technical minds involved and committed to the process.

4. Everyone can see results
When one person is doing manual testing, the rest of the team can’t see the results of the tests being run. With automated tests, however, people can sign into the testing system and see the results. This allows for greater team collaboration and a better final product.

### Cons of Automated Testing:
1. Tools can be expensive
The automation tools can be an expensive purchase. As a result, it is important to only use the ones that will give you full, or as close to full coverage, as you can find.

2. Tools still take time
While the automation process cuts down on the time it takes to test everything by hand, automated testing is still a time intensive process. A considerable amount of time goes into developing the automated tests and letting them run. For example, a large client of ours ran into trouble when their daily run of automated tests exceeded the 24-hour mark.

3. Tools have limitations
While automated tests will detect most bugs in your system, there are limitations. For example, the automated tools can’t test for visual considerations like image color or font size. Changes in these can only be detected by manual testing, which means that not all testing can be done with automatic tools.

### Pros of Manual Testing
1. Short-term cost is lower
Buying software automation tools is expensive. With manual testing, you won’t have to put the same up-front costs into the software.

2. More likely to find real user issues
Automated tests are just that – automatic. They’re robotic and don’t necessarily act as a real user would. Manual testing, on the other hand, allows the developing program to be used as it would be upon launch. Any bugs that may pop up when a user handles the program in a certain way are more likely to be caught with manual testing.

3. Manual testing is flexible
When one of those brilliant thoughts comes to you, something that could change the course of the project, you want to be able to work on it immediately. With automated testing this is difficult. You have to set up test cases, program it into the automated tool, and then run the tests. With manual testing, you can just quickly test and see the results. Automatic tests take more time to set up, which doesn’t allow you to test ideas quickly and easily.

### Cons of Manual Testing:
1. Certain tasks are difficult to do manually
There are certain actions that are difficult to do manually. For example? Low level interface regression testing. This kind of testing is extremely difficult to perform manually, and, as a result, is prone to mistakes and oversight when done by hand. Automated testing, once set up, is much better equipped to find errors for this kind of testing.

2. Not stimulating
Manual testing can be repetitive and boring – no one wants to keep filling out the same forms time after time. As a result, many testers have a hard time staying engaged in this process, and errors are more likely to occur.

3. Can’t reuse manual tests
With automated tests, if you add anything to the program, you can rerun all of the required tests instantly – the tests are already set up. This isn’t the case with manual testing. If there is any change to the software, you have to run the tests again by hand. This is valuable time lost.

## 2. Explain about the Test Pyramid and whether this exercise supported the ideas in the "pyramid"
![pyramid](https://github.com/ERPedersen/TEST-projects/blob/week-8-selenium/pyramid.jpg?raw=true)

The testing pyramid is used with automated testing. The testing pyramid helps developers to get on the same page on how to tackle the automated testing for a project.

The testing parymid helps by using a common language, sharing rules of thumb on where and when to use different types of tests, and therefor save teams a lot of time and effort by being clear about what kinds of tests they want to write, and when.
The test pyramid contains three types of test subjects: the user interface test, the integration test and unit test.

### UI test
The UI test are tests that test the system just like a real live end user would. They mimic the user’s interactions in the form or a script, we run that script in the form or a test, and it basically interacts with the system just like a regular user would. We tests the complete system end-to-end. 

#### Pros and cons:

UI tests are fantastic and going end-to-end through the entire application, and ensuring that everything is hooked up and working. They are the deepest, most integrated kind of test we can write. And if an UI tests works, chances are very good everything is going to work in production.

UI tests are very slow. It takes orders of magnitude longer to run a UI test than a unit test. Which means once we start to have a lot of UI test, our build times start to get long, our ability to iterate really slows down.

UI test are very fragile. Changing the user interface often breaks the corresponding UI tests. So we have to be careful about how we write UI test, and try really hard not to make them overly fragile.

So because of their speed and fragility, we should use UI tests more sparingly, and save them. 

-	Go end-to-end
-	See what the user sees
-	Are expensive and slow

### Integration Test
The purpose of integration testing is to verify functional, performance, and reliability requirements placed on major design items. The integration test are set up to test every time you push a change to a build/release or at deployment.

There are two major ways of carrying out an integration test, called the bottom-up method and the top-down method. 

Bottom-up integration testing begins with unit testing, followed by tests of of progressively higher-level combinations of units called modules or builds. 

In top-down integration testing, the highest-level modules are tested first and progressively lower-level modules are tested after that. In a comprehensive software development environment, bottom-up testing is usually done first, followed by top-down testing. The process concludes with multiple tests of the complete application, preferably in scenarios designed to mimic those it will encounter in customers' computers, systems and networks.

#### Pros and cons 
Integration tests like UI tests also test connectivity. But because they don’t go through the UI, there are no where near as slow or fragile. Integration test are testing things like web services, and giving some level of confidence that things are things hooked up, without paying an high price.

While integration test are good at telling us when we have a problem, they unfortunately usually dont tell us precisely where. As it could be anywhere in the system.

For low level precision, that tell us exactly where things went wrong, we rely on the unit test.
-	Test connectivity
-	Test web-services and API’s
-	Are not the most precise

### Unit test
Unit test a testing specific methods functionality.

#### Pros and cons
Unit tests are the fastest form of automated test we’ve got. These tests are fast, efficient, highly precise, and can pinpoint exactly where something fails when a test breaks. They give really rapid feedback. Are inexpensive. Developers should write a lot of unit test when testing their applications.

Unit test downside is that it do periodically miss bugs that can sometimes occur only when you hook things up. Which is why integration and UI tests are still valuable. But for most of our automated testing efforts, we should be using the unit test.
-	Fast test
-	Versatile test
-	Miss integration

## 3. Discuss some of the problems with automated GUI tests and what makes such tests "vulnerable" 
The biggest problem with automating GUI testing is that it removes the human aspect of testing. A GUI is used by a human and therefore the GUI needs to be either accepted or rejected by a human which an automated test can't do. 

Also automated GUI test don't always follow all the rules which is normally set for tests. It's not certain that the test execution will be fast, and the code that needs to be written can be more complicated than what is generally accepted. This can make automated GUI tests cost deficient, however still more cost efficient than manual GUI tests.

Lastly, the most obvious problem with automated GUI testing is that they are fragile. Small changes to the GUI can easily break all previously written tests

## 4. Demonstrate details in how to create a Selenium Test using the code for the exercise

The first thing we need to do is set a system property that defines the location of the webdriver we are using to execute the tests. In this case, we are using the `webdriver.chrome.driver`, which allows us to run our Selenium Tests in the Chrome browser. We are setting this property in the `@BeforeClass` method, which is executed once our test-class is run. Next, we call instantiate our `WebDriver` which will open the browser window. We had a problem with a system driver called JNA, which we ended up disabling by calling the following method `System.setProperty("jna.nosys", "true");`.

```java
@BeforeClass
public static void beforeClass() {
    System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Selenium\\chromedriver.exe");
    System.setProperty("jna.nosys", "true");
    driver = new ChromeDriver();
}
```

In the `@BeforeEach` method, we call the endpoint which resets the data in the database, to ensure that every test is run with the initial test data on the database. This ensures that the tests can be run independently from each other.

```java
@Before
public void beforeEach() {
    driver.get("http://localhost:3000/reset");
}
```

We will take the first `testScenario1()` as an example, in which the following steps occur:
1. Call the `driver.get()` method, which will point our browser to the page where we want to execute our tests.
2. Use the `WebDriverWait` class with a timeout of 10 seconds, to ensure that the page has been loaded, before we conclude anything.
3. Get the `<tbody>` with the id `#tbodycars`.
4. Find all elements with the type `tr` in the above mentioned `<tbody>`.
5. Return whether the size of the list is equal to 5.
6. Assert that the result is true.

```java
@Test
public void testScenario1() {

    driver.get("http://localhost:3000");

    Boolean result = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver webDriver) {
            WebElement element = driver.findElement(By.id("tbodycars"));
            List<WebElement> elementList = element.findElements(By.tagName("tr"));
            System.out.println("The initial size of the list is: " + elementList.size());
            return elementList.size() == 5;
        }
    });

    assertThat(result, is(true));
}
```

## 5. Explain shortly about the DOM, and how you have read/manipulated DOM-elements in your test

### DOM Definition
**From W3C:** _"The W3C Document Object Model (DOM) is a platform and language-neutral interface that allows programs and scripts to dynamically access and update the content, structure, and style of a document."_

Once a web page is loaded, the browser creates a rendered version of the HTML code that was interpreted. This is called the Document Object Model (DOM).

The W3C DOM standard is separated into 3 different parts:
- Core DOM - standard model for all document types
- XML DOM - standard model for XML documents
- HTML DOM - standard model for HTML documents

The HTML DOM is a standard object model and programming interface for HTML. It defines:

- The HTML elements as objects
- The properties of all HTML elements
- The methods to access all HTML elements
- The events for all HTML elements

**In other words:** _The HTML DOM is a standard for how to get, change, add, or delete HTML elements._

### How does Selenium interact with the DOM?
All implementations of `WebDriver` that communicates with a browser uses a common wire protocol. This wire protocol defines a RESTful web service using JSON over HTTP, which enables the `WebDriver` to communicate with the browser.

Each WebDriver command is mapped to an HTTP method via the `WebDriver` service, and is then passed on to the HTTP Command Processor to communicate with the browser. The Command responses are returned as HTTP/1.1 response messages via the `WebDriver` service.

Different drivers, such as the Chrome Driver and the Edge Driver, have different implementations to accomplish the above.

### How have we used Selenium to interact with the DOM?
As mentioned above, the `WebElement` class, allows us to manipulate, add or delete HTML elements in the DOM. A WebElement can be constructed with Selenium in our Java program by using the `findElement()` method on the `WebDriver`. The `findElement()` method accepts a number of ways to locate elements on the DOM. We have the possibility to find elements with the `By` class, which exposes the following methods:

- `id()`
- `name()`
- `className()`
- `xpath()`
- `cssSelector()`
- `tagName()`
- ...

Through the `WebElement` class, we now have access to the following methods which purposes are pretty self explanatory:
- `clear()`
- `sendKeys()`
- `getText()`
- `click()`
- `getAttribute()`
- `getTagName()`
- `submit()`
- ...

## 6. Explain how (and why it was necessary) you have solved "waiting" problems in your test
When we request a page that we need to run tests on, it is crucial to allow for the DOM to render, before trying to execute any operations on the DOM. This speaks for itself in a serverside rendered application, but today many websites rely on complex JavaScript frameworks. Some of the applications may rely on external AJAX requests, which can take time to execute, and may leave certain components or elements unavailable before some JavaScript code has rendered asynchronously. 

The way to get around this, is to use the `WebDriverWait` class, in which you can set a `timeOutInSeconds` parameter. Selenium will repeat the operation inside your `until()` call, until the method returns true. 

## 7. Screenshot of tests running
![ScreenShot](https://github.com/ERPedersen/TEST-projects/blob/week-8-selenium/screenshot.png?raw=true)
