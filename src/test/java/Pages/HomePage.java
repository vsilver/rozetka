package Pages;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assume.assumeTrue;

public class HomePage {
    private WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    private By searchField = By.xpath("//div[@class='search__input-wrapper']//input[@class='search-form__input ng-pristine ng-valid ng-touched']");

    public HomePage search(String wordforsearch){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(wordforsearch);
        //driver.findElement(searchField).click();
        return this;
    }

    public HomePage chooseDropDown(){

        return this;
    }


}
