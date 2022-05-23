package ui_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class browserStack {
    public static final String USERNAME = "notificacionesgl1";
    public static final String AUTOMATE_KEY = "pvsqyH7AACsUaciFt2uF";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    public WebDriver driver;

    @Test
    public void openSTM() throws Exception {
        // To execute scripts through remote server or grid on mulitple browsers, we need to set capabilities of platform, version etc., to run the scripts
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("realMobile", "true");
        capability.setCapability("os_version", "14");
        capability.setCapability("device", "iPhone 11");
        capability.setBrowserName("chrome");
        capability.setVersion("88");
        capability.setCapability("browserstack.debug", "true");
        // Creatng URL object
        URL browserStackUrl = new URL(URL);
        // Create object of driver. We execute scripts remotely. So we use RemoteWebDriver
        //There are many constructors to remotewebdriver
        //To pass URL object and Capabilities object, use the below mentioned constructor
        //RemoteWebDriver(URL remoteAddress, Capabilities desiredCapabilities)
        driver = new RemoteWebDriver(browserStackUrl, capability);
        //Implicit wait for 30 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // to open url
        driver.get("https://www.carocuore.com/");
        List<WebElement> demovar = driver.findElements(By.tagName("a"));
        System.out.println(demovar.size());


        ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag

        for (WebElement var : demovar) {
            System.out.println(var.getText()); // used to get text present between the anchor tags
            System.out.println(var.getAttribute("href"));
            hrefs.add(var.getAttribute("href"));
            System.out.println("*************************************");
        }

        //Navigating to each link
        int i = 0;
        for (String href : hrefs) {
            driver.navigate().to(href);
            System.out.println((++i) + ": navigated to URL with href: " + href);
            wait(3000); // To check if the navigation is happening properly.
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }
}