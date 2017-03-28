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
...

## 6. Explain how (and why it was necessary) you have solved "waiting" problems in your test
...

## 7. Screenshot and video of tests running
![ScreenShot](https://i.imgsafe.org/a3813c0dc7.png)
