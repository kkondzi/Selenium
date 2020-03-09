package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {

    WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By displayedNameLocator = By.cssSelector("div[class='woocommerce-MyAccount-content']");

    public String getDisplayedName() {
        return driver.findElement(displayedNameLocator).getText();
    }

}
