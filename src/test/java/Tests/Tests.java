package Tests;

import Pages.ProductPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.CategoryPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static sun.java2d.cmm.ColorTransform.In;


public class Tests {

    private WebDriver driver;
    private HomePage homepage;
    private CategoryPage categorypage;
    private ProductPage productpage;


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
        categorypage = new CategoryPage(driver);
        productpage = new ProductPage(driver);
    }

    @Test
    public void search(){
        wordforsearch = WORDFORSEARCH;
        homepage.search(wordforsearch);
        homepage.chooseDropDown();
        Assert.assertTrue(driver.getPageSource().contains("iphone xr"));
    }

    @Test
    public void chooseIphone(){
        wordforsearch = WORDFORSEARCH;
        homepage.search(wordforsearch);
        homepage.chooseDropDown();
        categorypage.chooseRed();
        Assert.assertTrue(driver.getPageSource().contains("Apple iPhone Xr 128GB Red (MRYE2)"));
    }

    @Test
    public void changeColor(){
        wordforsearch = WORDFORSEARCH;
        homepage.search(wordforsearch);
        homepage.chooseDropDown();
        categorypage.chooseRed();
        productpage.changeColor();
        Assert.assertTrue(driver.getPageSource().contains("iPhone Xr 128GB Blue (MRYH2)"));
    }

    @Test
    public void addToBusket(){
        wordforsearch = WORDFORSEARCH;
        homepage.search(wordforsearch);
        homepage.chooseDropDown();
        categorypage.chooseRed();
        productpage.changeColor();
        productpage.addToBasket();
        productpage.swithToPopup();
        Assert.assertTrue(driver.getPageSource().contains("Вы добавили товар в корзину"));
    }

    @After
    public void closeConnect() throws Exception {
        driver.quit();
    }
}
