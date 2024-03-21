package uiselenium.pages.linkbox;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiselenium.pages.base.BasePage;

@Setter
@Getter
public class LoginPage extends BasePage {

    public LoginPage(@NonNull WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class='forgot-pass-link']/a[@class='link']")
    private WebElement forgotPassword;
    @FindBy(xpath = "//span[@class='invalid-feedback']/strong[@class='js_input_error']")
    private WebElement errorText;

    public LoginPage clickSignInButton() {
        signInButton.click();
        return this;
    }

}
