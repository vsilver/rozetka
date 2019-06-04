package Pages;

import org.openqa.selenium.WebDriver;

public class CategoryPage {

    private WebDriver driver;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage chooseRose(){


        return new ProductPage(driver);
    }
}
