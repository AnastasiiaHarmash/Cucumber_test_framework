package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id='auth-error-message-box']")
    private WebElement errorMessageBox;

    @FindBy(xpath = "//span[@class='a-list-item']")
    private WebElement errorMessage;

    public SignInPage(WebDriver driver) { super(driver); }

    public WebElement getEmailField() { return emailField; }

    public void enterTextToLoginField(final String loginData) {
        getEmailField().clear();
        getEmailField().sendKeys(loginData);
    }
    public void clickContinueButton() { continueButton.click(); }
    public boolean checkIsVisibleErrorMessageBox() { return errorMessageBox.isDisplayed(); }
    public String getTextFromErrorMessageBox() { return errorMessage.getText(); }
}
