package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import com.google.common.base.Function;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static org.junit.Assert.assertTrue;
import static utilities.ConfigReader.getProperty;

public class Driver extends TestBench {

    public static final String USERNAME = "zulfikarayub_zFWO7w";
    public static final String AUTOMATE_KEY = "1XaTd3nehMwVYaYcVakR";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    public static final String URL2 = "https://www.admitone.com.ar/shop/mujer.html";
    public static int count;
    public static String fakePass, codeReceived, randomEmailID, mailProductNameCheck, UiProductName, UiProductPrice, firstName, surname, dni, phoneNumber, streetName, streetNumber, zipcode;
    public static WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    public static ExtentSparkReporter html;
    public static ExtentReports report;
    public static ExtentTest test;
    public static String runtype;
    public static Logger log = LogManager.getLogger(Driver.class);
    public static Faker faker = new Faker();
    public static adminOne_pageObject adminOne_pageObject;
    public static VtexPage_admitOne VtexPage_admitOne;
    public static VtexPage_babyCotton VtexPage_babyCotton;
    public static VtexPage_tucciar VtexPage_tucciar;
    public static VtexPage_Umbroar VtexPage_Umbroar;
    public static VtexPage_Vitamin VtexPage_Vitamin;
    public static VtexPage_Fila VtexPage_Fila;
    public static googleSignIn googleSignIn;
    public static VtexPage_kosiukoar VtexPage_kosiukoar;
    public static VtexPage_Minoar VtexPage_Minoar;
    public static JavascriptExecutor js;


    public Driver() {
    }


    public void initTestMethod() {
        driver = geTDriver();
        googleSignIn = new googleSignIn(driver);
        adminOne_pageObject = new adminOne_pageObject(driver);
        VtexPage_admitOne = new VtexPage_admitOne(driver);
        VtexPage_babyCotton = new VtexPage_babyCotton(driver);
        VtexPage_tucciar = new VtexPage_tucciar(driver);
        VtexPage_Umbroar = new VtexPage_Umbroar(driver);
        VtexPage_Vitamin = new VtexPage_Vitamin(driver);
        VtexPage_Fila = new VtexPage_Fila(driver);
        VtexPage_kosiukoar = new VtexPage_kosiukoar(driver);
        VtexPage_Minoar = new VtexPage_Minoar(driver);
        js = (JavascriptExecutor) driver;
    }

    public WebDriver geTDriver() {
        try {
            runtype = ConfigReader.getProperty("runtype");
            if (runtype.equalsIgnoreCase("local")) {
                if (driver == null) {
                    switch (ConfigReader.getProperty("browser")) {
                        case "chrome":
                            WebDriverManager.chromedriver().setup();
                            setDriver(new ChromeDriver());
                            break;
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            setDriver(new FirefoxDriver());
                            break;
                        case "ie":
                            WebDriverManager.iedriver().setup();
                            setDriver(new InternetExplorerDriver());
                            break;
                        case "safari":
                            WebDriverManager.getInstance(SafariDriver.class).setup();
                            setDriver(new SafariDriver());
                            break;
                        case "headless-chrome":
                            WebDriverManager.chromedriver().setup();
                            setDriver(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                            break;
                    }

                }

            } else if (runtype.equalsIgnoreCase("remote")) {
                DesiredCapabilities caps = new DesiredCapabilities();

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");
                URL browserStackUrl = new URL(URL);
                setDriver(new RemoteWebDriver(browserStackUrl, caps));
                //Implicit wait for 30 seconds
                //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver = getDriver();
        tdriver.set(driver);
        return newDriver();
    }


//    public static  synchronized WebDriver getWebDriver(){
//        return tdriver.get();
//    }

    public WebDriver newDriver() {
        return tdriver.get();
    }

    public static void catch_brokenImages() {
        int iBrokenImageCount = 0,imgHeight,imgWeight;

        // driver.navigate().to(URL2);
        //driver.manage().window().maximize();

        try {
            List<WebElement> image_list = driver.findElements(By.tagName("img"));
            /* Print the total number of images on the page */
            log.info("The page under test has " + image_list.size() + " images");
            for (WebElement img : image_list) {
                if (img != null) {
                    imgHeight = img.getSize().getHeight();
                    imgWeight = img.getSize().getWidth();
                    log.info("image height is..."+imgHeight);
                    log.info("image wirght is..."+imgWeight);
                    Assert.assertTrue(imgHeight!=0);
                    Assert.assertTrue(imgWeight!=0);
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpGet request = new HttpGet(img.getAttribute("src"));
                    HttpResponse response = client.execute(request);
                    /* For valid images, the HttpStatus will be 200 */
                    if (response.getStatusLine().getStatusCode() != 200) {
                        log.info(img.getAttribute("outerHTML") + " is broken.");
                        iBrokenImageCount++;

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("The page " + URL2 + " has " + iBrokenImageCount + " broken images");
    }




    /**
     * This method will take screenshot and save it with the given file name
     */
    public static String takeScreenShot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screen = ts.getScreenshotAs(OutputType.FILE);
        String scrshotFile = Constants.SCREENSHOTS_FILEPATH + fileName + "_" + getTime() + ".png";
        try {
            FileUtils.copyFile(screen, new File(scrshotFile));
        } catch (IOException e) {
            System.out.println("Cannot take screenshot");
        }
        return scrshotFile;
    }

    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        return sdf.format(date.getTime());
    }

    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * return a list of string from a list of elements ignores any element with no
     * text
     *
     * @param list
     * @return
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator) throws Exception {
        List<WebElement> elems = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            elemTexts.add(el.getAttribute("textContent"));
        }
        System.out.println(elemTexts);
        return elemTexts;
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = null;
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            org.testng.Assert.fail(e.getMessage());

        }

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeinsec)).pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }

    /**
     * Verifies whether the element is displayed on page fails if the element is not
     * found or not displayed
     *
     * @param element
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + element);
        }
    }

    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    /**
     * Selects a random value from a dropdown list
     *
     * @param select
     * @return
     */
    public static void selectRandomTextFromDropdown(WebElement select, int whichIndex) {
        Select selectOption = new Select(select);
        log.info("selecting by index of .... " + whichIndex);
        log.info("selecting by index of .... " + selectOption.getAllSelectedOptions());
        selectOption.selectByIndex(whichIndex);

    }

    /**
     * Selects a random value from a dropdown list and returns the selected Web
     * Element
     *
     * @param select
     * @return
     */
    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using
     * JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command, element);
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command);
    }

    public static boolean isElementSelected(By locator) {
        return webAction(locator).isSelected();
    }

    public static void sendValue(By locator, String value) {
        try {
            webAction(locator).sendKeys(value);
        } catch (Exception e) {
            System.out.println("Some exception occured while sending value" + locator);
        }

    }

    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class).ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds nut still could not find the element therefore TimeOutException has been thrown");
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public static void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static void getAllUrls() {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//*[@href or @src]"));

            for (WebElement e : list) {
                String link = e.getAttribute("href");
                if (null == link)
                    link = e.getAttribute("src");

                System.out.println(e.getTagName() + "=" + link);

            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public static void navigateCrossWebSite() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        ArrayList<String> valid_links = new ArrayList<>();
        String flag = ""; // A flag is added so that the link is not repeated

        log.info("Total links found → " + links.size());

        for (WebElement link : links) {
            log.info(link.getAttribute("href"));
            if (link.getAttribute("href") != null && link.getAttribute("href").contains("http") && !link.getAttribute("href").equals(flag)) {
                valid_links.add(link.getAttribute("href"));
                flag = link.getAttribute("href");
            }
        }

        log.info("Total of valid links found → " + valid_links.size());

        int i = 0;
        for (String href : valid_links) {
            log.info((++i) + ":: Navigate to URL with href: " + href);
            driver.navigate().to(href);
        }
    }

    // @BeforeTest(alwaysRun = true)
    public void generateReport() {
        html = new ExtentSparkReporter(Constants.REPORT_FILEPATH);
        html.config().setTheme(Theme.DARK);
        html.config().setDocumentTitle("Orange HRM Testing Report");
        html.config().setReportName("HRM Testing Execution Report");

        report = new ExtentReports();
        report.attachReporter(html);

        report.setSystemInfo("QA Engineer", Constants.USER_NAME);
        report.setSystemInfo("Environment", Constants.OS_NAME);
        report.setSystemInfo("Browser", ConfigReader.getProperty("browser"));

    }

    //@AfterTest(alwaysRun = true)
    public void writeReport() {
        report.flush();
    }

    public void changeTabByIndex(int index) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        log.info("Swiching Tabs");
    }

    public void visit(String url) {
        geTDriver();
        initTestMethod();
        getDriver().get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void url_validate() {
        //visit(getProperty("url_appashops"));
        String url = "";
        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
        log.info("Total links on the Wb Page: " + allURLs.size());

        //We will iterate through the list and will check the elements in the list.
        Iterator<WebElement> iterator = allURLs.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            log.info(url);
        }

    }

    public static void getScreenShot(Scenario scenario) {


        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }

    public void type(Object inputText, By locator) {
        driver.findElement(locator).sendKeys((CharSequence[]) inputText);
    }

    // Simple Click Method
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver1) throws IOException {
        log.info("screen shot code is called ....");
        driver1 = driver;
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = "./reports/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;


    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public String splitUrl(String url, String divider, int sliceIndex) {
        String[] parts = url.split(divider);
        return parts[sliceIndex];
    }

    public void mouseHoverElementAndClickInternalElement(By elementForMouseHover, By internalElementForClick) {
        Actions action = new Actions(driver);
        WebElement mainMenu = driver.findElement(elementForMouseHover);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.moveToElement(mainMenu).moveToElement(driver.findElement(internalElementForClick)).click().build().perform();
    }

    public void waitForElementDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
    }

    /**
     * this method will split the dollar and number from the string and gives
     * only the number
     **/
    public String amountSplit(String paymentAmount) {
        String totalPay = null;

        try {
            totalPay = paymentAmount;
            log.info("the amount from UI is  " + totalPay);
            String[] arrOfStr = totalPay.split("$");
            totalPay = arrOfStr[1];
            log.info("the amount after removing $ is  " + totalPay);


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            org.testng.Assert.fail(e.getMessage());
        }
        return totalPay;

    }


}
