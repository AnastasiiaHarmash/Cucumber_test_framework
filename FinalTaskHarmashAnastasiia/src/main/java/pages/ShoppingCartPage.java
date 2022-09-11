package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//div[@id='sc-active-cart']//div[@class='a-cardui-body a-scroller-none']")
    private WebElement cartField;

    @FindBy(xpath = "//div[@class='a-row sc-your-amazon-cart-is-empty']//h2")
    private WebElement cartMessage;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteFromCartButton;

    public ShoppingCartPage(WebDriver driver) { super(driver); }

    public boolean isCardFieldVisible() { return cartField.isDisplayed(); }
    public String getTextFromCartMessage() { return cartMessage.getText(); }
    public void clickDeleteFromCartButton() { deleteFromCartButton.click(); }
}
