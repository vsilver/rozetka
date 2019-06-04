package Tests;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.HomePage;

import java.util.concurrent.TimeUnit;
import static org.junit.Assume.assumeTrue;
import static org.junit.Assert.assertEquals;

public class Tests {

    private WebDriver driver;
    private HomePage homepage;

    private String wordforsearch;

    private final static String WORDFORSEARCH = "iphone";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        homepage = new HomePage(driver);
    }

    @Test
    public void search(){
        wordforsearch = WORDFORSEARCH;
        homepage.search(wordforsearch);

    }

    @After
    public void closeConnect() throws Exception {
        driver.quit();
    }
}
