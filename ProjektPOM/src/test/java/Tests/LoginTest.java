package Tests;

import PageObjects.LoginPage;
import PageObjects.WelcomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    String username = "username";
    String email = "testowy@klient.pl";
    String password = "password";

    @Test
    public void correctUsernameCorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.loginSubmit();

        WelcomePage welcomePage = new WelcomePage(driver);

        Assertions.assertTrue(welcomePage.getDisplayedName().contains(username));

    }

    @Test
    public void incorrectUsernameCorrectPassowrd() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("incorrect-username");
        loginPage.enterPassword(password);
        loginPage.loginSubmit();

        Assertions.assertEquals("Nieznana użytkownik. Proszę sprawdzić ponownie lub spróbować swój email.", loginPage.getAlert());
    }

    @Test
    public void correctUsernameIncorrectPassowrd() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword("incorrect-password");
        loginPage.loginSubmit();

        Assertions.assertEquals("BŁĄD: Wprowadzone hasło dla nazwy użytkownika " + username + " nie jest poprawne. Nie pamiętasz hasła?", loginPage.getAlert());
    }

    @Test
    public void incorrectUsernameIncorrectPassowrd() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("incorrect-username");
        loginPage.enterPassword("incorrect-password");
        loginPage.loginSubmit();

        Assertions.assertEquals("Nieznana użytkownik. Proszę sprawdzić ponownie lub spróbować swój email.", loginPage.getAlert());
    }
}
