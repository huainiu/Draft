package Selenium.Mamba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michael on 5/30/2014.
 */
public class Login {
    String baseUrl = "http://www.mamba.ru";
    WebDriver driver;
    int counter;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get(baseUrl + "/ru/tips/?tip=login");
    }

    public void login(String username, String password) throws InterruptedException {
        WebElement userNameField = driver.findElement(By.id("inputLogin"));
        userNameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("inputPassword"));
        passwordField.sendKeys(password);
        driver.findElement(By.name("submit_login")).click();
        Thread.sleep(5000);
    }

    public void logout() {
        String logoutLink = "http://www.mamba.ru//logout.phtml";
        driver.get(logoutLink);
        driver.close();
    }

    public void search(String ageFrom, String ageTo, String t) throws InterruptedException {
        String searchQuery = "http://www.mamba.ru/search.phtml?ia=M&lf=F&af=" + ageFrom + "&at=" + ageTo + "&wp=1&wv=0&wvc=0&ni=1&wr=0&sz=b&s_c=1393_0_0_0&geo=0&s_tg=&geo=0&t=" + t;
        driver.get(searchQuery);

        Thread.sleep(5000);
    }

    //from age to age, time period = d (day), w (week), m (month).
    public List<HashMap<String, String>> getNewGirls() throws InterruptedException {

        Thread.sleep(3000);
        List<WebElement> girls = driver.findElements(By.xpath("//*[@id=\"section:page\"]/div[1]/div/div[3]/div/div/div[1]/div[3]/ul/*"));
        List<HashMap<String, String>> girlsData = new ArrayList<HashMap<String, String>>();
        for (WebElement girl : girls) {
            HashMap map = new HashMap<String, String>();
            String name = girl.findElement(By.xpath("//*[@id=\"section:page\"]/div[1]/div/div[3]/div/div/div[1]/div[3]/ul/li[" + (girls.indexOf(girl) + 1) + "]/div/div[3]/div[1]/a")).getText();
            String link = girl.findElement(By.xpath("//*[@id=\"section:page\"]/div[1]/div/div[3]/div/div/div[1]/div[3]/ul/li[" + (girls.indexOf(girl) + 1) + "]/div/div[3]/div[1]/a")).getAttribute("href");
            map.put("name", name);
            map.put("link", link);
            map.put("nameRussian", name); //TODO: transliteration to Russian if English.
            girlsData.add(map);
        }

        return girlsData;
    }

    public void sayHello(List<HashMap<String, String>> girls) throws InterruptedException {
        for (Map girl : girls) {
            driver.get(girl.get("link").toString());
            WebElement messageElement = driver.findElement(By.xpath("//*[@id=\"Anketa_Info\"]/div[1]/div[2]/div[2]/a[1]/span"));

            String parentHandle = driver.getWindowHandle(); // get the current window handle
            messageElement.click(); // click some link that opens a new window
            Thread.sleep(3000);

            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
            }
            //code to do something on new window
            try {
                WebElement messageField = driver.findElement(By.xpath("//*[@id=\"f_message\"]"));
                String message = "Привет, " + girl.get("name") + "!:) Красивое фото. Можем пообщаться?:)";
                messageField.sendKeys(message);
                WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"ChatForm\"]/div[3]/input"));
                sendButton.click(); //TODO: uncomment.
                Thread.sleep(2000);
                driver.close(); // close newly opened window when done with it
                this.counter++;
            } catch (Exception e) {
                e.printStackTrace();
                driver.switchTo().window(parentHandle); // switch back to the original window
            }


            driver.switchTo().window(parentHandle); // switch back to the original window
        }
    }

    public int checkNumberOfPages() {
        int i = 0;
        try {
            WebElement pagenator = driver.findElement(By.xpath("//*[@id=\"Paginator\"]"));
            if (pagenator == null) {
                i = 1;
            } else {
                List<WebElement> pages = driver.findElements(By.xpath("//*[@id=\"Paginator\"]/*"));
                i = pages.size();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return i;
        }
    }

/*    public void nextResultsPage(){
        List<WebElement> pages = driver.findElements(By.xpath("/*//*[@id=\"Paginator\"]*//*"));
        for (int i = 0; i < pages.size()-1; i++) {

        }

    }*/

    public void repeatHelloNextPage() throws InterruptedException {
        List<HashMap<String, String>> girls = getNewGirls();
        sayHello(girls);
    }

    public static void main(String[] args) throws InterruptedException {

        String username = "";
        String password = "";
        WebDriver driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        //Login login = new Login(driver);
        //login.openLoginPage();
        //login.login(username, password);
        //List<HashMap<String, String>> girls = login.getNewGirls("18", "38", "m");
        //System.out.println(login.checkNumberOfPages());


        try {
            Login login = new Login(driver);
            login.openLoginPage();
            login.login(username, password);

            login.search("18", "38", "w");
            List<HashMap<String, String>> girls = login.getNewGirls();
            login.sayHello(girls);

            if (login.checkNumberOfPages() > 1) {
                driver.findElement(By.xpath("//*[@id=\"Paginator\"]/div[2]/a")).click();
                for (int i = 2; i < login.checkNumberOfPages(); i++) {
                    girls = login.getNewGirls();
                    login.sayHello(girls);
                    driver.findElement(By.xpath("//*[@id=\"Paginator\"]/div[" + i + "]/a")).click();
                }

            } else {
                System.out.println("Completed. Sent messages to " + login.counter + " new girls.");
            }

        } finally {
            driver.quit();
        }


    }


}
