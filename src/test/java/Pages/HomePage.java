package Pages;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assume.assumeTrue;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchField = By.xpath("//input[@name='search']");
    private By selectItem = By.xpath("//div[@class='search-suggest']/ul");

    public HomePage search(String wordforsearch) {
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(wordforsearch);
        //Select select = new Select(selectItem);
        //select.selectByIndex(1);
        return this;
    }

    public CategoryPage chooseDropDown() {

        WebElement countryUL = driver.findElement(selectItem);
        List<WebElement> countriesList = countryUL.findElements(By.tagName("li"));
        for (WebElement li : countriesList) {
            if (li.getText().equals("iphone xr")) {
                li.click();
            }
        }
        return new CategoryPage(driver);
    }
}




