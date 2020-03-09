package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to("http://localhost/sklep/moje-konto/");
    }

    private By UsernameInputLocator = By.cssSelector("input[name='username']");
    private By PasswordInputLocator = By.cssSelector("input[autocomplete='current-password']");
    private By LoginSubmitButtonLocator = By.cssSelector("button[name='login']");
    private By AlertMsgLocator = By.cssSelector("ul[class='woocommerce-error']");

    public void enterUsername(String username) {
        driver.findElement(UsernameInputLocator).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(PasswordInputLocator).sendKeys(password);
    }

    public void loginSubmit() {
        driver.findElement(LoginSubmitButtonLocator).click();
    }

    public String getAlert() {
        return driver.findElement(AlertMsgLocator).getText();
    }

}
