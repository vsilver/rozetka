package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    private By changecolor = By.xpath("//span[@class='variants-i-icon ng-star-inserted' and style='background-color: rgb(51, 51, 255)']");
    private By addtobasket = By.xpath("//button[@class='btn-link-i' and contains(text(), 'Купить')]");

    public ProductPage changeColor(){
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.presenceOfElementLocated(changecolor));
        driver.findElement(changecolor).click();
        return this;
    }

    public ProductPage addToBasket(){
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.presenceOfElementLocated(addtobasket));
        driver.findElement(addtobasket).click();
        return this;
    }

    public ProductPage swithToPopup(){
        String myWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(myWindowHandle);
        return this;
    }

}
