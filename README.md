# Selenium Test Hand-In

## 1. Discuss Pros and Cons with manual versus automated tests
...

## 2. Explain about the Test Pyramid and whether this exercise supported the ideas in the "pyramid"
...

## 3. Discuss some of the problems with automated GUI tests and what makes such tests "vulnerable" 
...

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

## 7. Screenshot and video of tests running
![ScreenShot](https://i.imgsafe.org/a3813c0dc7.png)
