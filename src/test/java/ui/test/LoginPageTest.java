package ui.test;

import lombok.experimental.Accessors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import uiselenium.common.CommonActions;
import uiselenium.pages.linkbox.LoginPage;

public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = CommonActions.webDriver();
        loginPage = new LoginPage(driver);
        loginPage.open("https://linkbox.zaplanom.com/en/login");
    }

    @Test
    public void registerFail() {
        driver = CommonActions.webDriver();
        loginPage = new LoginPage(driver);
        loginPage.open("https://linkbox.zaplanom.com/en/login");
        loginPage.clickSignInButton();
        String errorText = loginPage.getErrorText().getText();
        Assertions.assertEquals(errorText, "This field is required.");
    }

    @After
    public void tearDown() {
        driver.quit();
    }




}
