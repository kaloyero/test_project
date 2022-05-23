package ui_tests.vtex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;
import utilities.Driver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static utilities.ConfigReader.getProperty;

public class AppaShops extends Driver {
    public static Logger log = LogManager.getLogger(babyCotton.class);


    public static void verifyAllLinks(String linkUrl)
    {
        try
        {
            java.net.URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }

    @Test(description = "login flow")
    public void loginCheck() {


        try {

            visit(getProperty("url_appashops"));
            VtexPage_babyCotton.loginCheckAppa();
            VtexPage_babyCotton.LoginMailinator();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAppa();
            url_validate();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
    @Test
    public void BrokenLinksAppa() {

        visit("https://www.appashops.com.ar/");
        //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        // This line will print the number of links and the count of links.
        log.info("No of links are "+ links.size());
        //checking the links fetched.
        for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            verifyAllLinks(url);
            catch_brokenImages();
        }

    }



    @Test(description = "login flow")
    public void urlTesting() {

        visit("https://www.appashops.com.ar/hombre");
        wait(10);
        url_validate();
        log.info("//////////////////URL MAIN APPA/////////////////////");
        visit("https://www.appashops.com.ar/mujer");
        url_validate();
        log.info("//////////////////URL MAIN MUJER/////////////////////");
        visit("https://www.appashops.com.ar/Marca");
        url_validate();
        log.info("//////////////////URL MAIN HOMBRE/////////////////////");
        visit("https://www.appashops.com.ar/Hogar");
        url_validate();
        log.info("//////////////////URL MAIN HOGAR/////////////////////");
        visit("https://www.appashops.com.ar/Marcas");
        url_validate();
        log.info("//////////////////URL MAIN MARCAS/////////////////////");

    }

    @Test
    public void Register() {

        try {

            visit(getProperty("url_appashops"));
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            //Driver.catch_brokenImages();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "create account and change password from my account page ")
    public void myAccChangePass() {

        try {

            visit(getProperty("url_appashops"));
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            VtexPage_admitOne.PopUpGracias(VtexPage_babyCotton.popUpNoButton);
            VtexPage_babyCotton.myAccountDetailCheck();
            VtexPage_babyCotton.myAccountChangePassword();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "place order successfully ")
    public void placeOrderSuccessfully() {

        try {
            visit(getProperty("url_appashops"));
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            VtexPage_admitOne.PopUpGracias(VtexPage_babyCotton.popUpNoButton);
            VtexPage_babyCotton.babySearchProduct("Toalla");
            VtexPage_babyCotton.cartCheckOut();
            VtexPage_babyCotton.cartPageDetailFill();
            VtexPage_babyCotton.paymentCashOption();
            VtexPage_babyCotton.MailinatorToForOrderConfirmation();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "delete the product from cart and add it again")
    public void deleteProductFrmCart() {

        try {

            visit(getProperty("url_appashops"));
            VtexPage_babyCotton.babySearchProduct("Toalla");
            VtexPage_babyCotton.cartCheckOut();
            VtexPage_admitOne.PopUpGracias(VtexPage_babyCotton.popUpNoButton);
            VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg, VtexPage_babyCotton.cartPgLogo);
            VtexPage_babyCotton.babySearchProduct("body");
            VtexPage_babyCotton.cartCheckOut();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


}

