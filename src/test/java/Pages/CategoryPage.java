package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

    private WebDriver driver;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
    }
    private By roselocator = By.xpath("//a[@href=https://rozetka.com.ua/apple_iphone_xr_128_gb_red/p54192372/]");

    public ProductPage chooseRed(){
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.presenceOfElementLocated(roselocator));
        driver.findElement(roselocator).click();

        return new ProductPage(driver);
    }
}
