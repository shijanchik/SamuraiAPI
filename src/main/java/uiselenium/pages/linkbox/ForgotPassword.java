package uiselenium.pages.linkbox;

import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiselenium.pages.base.BasePage;

public class ForgotPassword extends BasePage {

    public ForgotPassword(@NonNull WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Reset Password')]")
    private WebElement resetPassword;
    @FindBy(xpath = "//div[@class='forgot-pass-link']/a[@class='link']")
    private WebElement backToLogin;



}
