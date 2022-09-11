package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(text(), 'email address')]") //div[@id='auth-email-invalid-claim-alert']
    private WebElement errorMessageWrongEmail;

    public RegistrationPage(WebDriver driver) { super(driver); }

    public boolean isEmailFieldVisible() { return emailField.isDisplayed(); }
    public WebElement getEmailField() { return emailField; }
    public void enterTextToEmailField(final String textToEmailField) {
        emailField.clear();
        emailField.sendKeys(textToEmailField);
    }
    public boolean isContinueButtonVisible() { return continueButton.isDisplayed(); }
    public void clickContinueButton() { continueButton.click(); }
    public WebElement getErrorMessageWrongEmail() { return errorMessageWrongEmail; }
    public boolean isErrorMessageWrongEmailVisible() { return errorMessageWrongEmail.isDisplayed(); }
}
