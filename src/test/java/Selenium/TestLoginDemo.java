package Selenium;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by Michael on 5/11/2014.
 */
public class TestLoginDemo {
    LoginPage loginPage;
    String baseUrl = "outbrain.com";
    String username = "TestUser100";
    String password = "TestUser100";
    WebDriver driver = new FirefoxDriver();


    /**
     * 1. First we create an inner class in order to reuse the code for logging in and logging out.
     * The constructor of the class accepts the WebDriver interface, so that we could use different implementations of the interface (FF, Chrome, IE).
     * This could have been done with getters and setters (for proper encapsulation), but for time's sake, i'm using the constructor now.
     * If these procedures will be widely used in other test suitesm for example, LoginPage can be made a separate class.
     */
    public class LoginPage {
        WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        /**
         * Navigate to the login page and wait 3 seconds for the page to load.
         */
        public void openLoginPage() {
            driver.get("https://my." + baseUrl);
        }

        /**
         * Login to the test account.
         */
        public void login(String username, String password) {
            WebElement userNameField = driver.findElement(By.xpath("/*//*[@id=\"signin-member-username\"]"));
            userNameField.sendKeys(username);
            WebElement passwordField = driver.findElement(By.xpath("/*//*[@id=\"signin-member-password\"]"));
            passwordField.sendKeys(password);
            driver.findElement(By.xpath("/*//*[@id=\"signin-member\"]/div/div[2]/input")).click();
        }

        /**
         * Logout from the test account.
         */
        public void logout() {
            WebElement logoutLink = driver.findElement(By.xpath("//*[@id=\"loggedIn-box\"]/span/a"));
            logoutLink.click();
        }
    }


    /**
     * In this @Before test we initialize the LoginPage inner class to work with it in every of the following tests.
     * In this specific case I chose to use Firefox web driver, but we can easily replace it with Chrome or IE.
     */
    @Before
    @Ignore
    public void setup() {
        loginPage = new LoginPage(driver);
    }

    /**
     * Testing logging in.
     * We assert that after successful login, the link to logout is displayed.
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testUserCanLogin() throws Exception {
        loginPage.openLoginPage();
        loginPage.login(username, password);
        WebElement logoutLink = loginPage.driver.findElement(By.xpath("//*[@id=\"loggedIn-box\"]/a/span"));
        String loggedInUser = logoutLink.getText();

        Assert.assertEquals("The username we used to login should be the same as the username displayed in the LoggedIn-Site element", username, loggedInUser);

    }

    /**
     * Testing logging out.
     * After looging in and logging out, the homepage "outbrain.com" is displayed, and there is a "login" link, which the user can use to login again.
     * We use the "lolging" link to assert successful logging out.
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testUserCanLogout() throws Exception {
        loginPage.openLoginPage();
        loginPage.login(username, password);
        loginPage.logout();

        String loginLinkTextExpected = "Login";
        String loginLinkTextActual = loginPage.driver.findElement(By.xpath("//*[@id=\"login\"]")).getText();

        Assert.assertEquals("When the user logs out, the main page is displayed and again there is a link to Login page", loginLinkTextExpected, loginLinkTextActual);

    }

    /**
     * This test verifies that a user cannot login with an incorrect password.
     * @throws Exception
     */
    @Test
    @Ignore
    public void testLoginWithIncorrectPassword() throws Exception {
        loginPage.openLoginPage();
        this.password = "TestUser1001";
        loginPage.login(username, password);

        String loginLinkTextExpected = "Login";
        String loginLinkTextActual = loginPage.driver.findElement(By.xpath("//*[@id=\"login\"]")).getText();

        Assert.assertNotSame("When the user logs out, the main page is displayed and again there is a link to Login page", loginLinkTextExpected, loginLinkTextActual);

    }


}
