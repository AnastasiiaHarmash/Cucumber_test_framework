package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    private WebElement quantityContainer;

    @FindBy(xpath = "//ul[@class='a-nostyle a-list-link']")
    private WebElement quantityListBox;

    @FindBy(xpath = "//li[@aria-labelledby='quantity_1']")
    private WebElement numberTwoOnListBox;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']//span[contains(text(), '2')]")
    private WebElement quantityIsTwoListBox;

    public ProductPage(WebDriver driver) { super(driver); }
    public boolean isAddToCartButtonVisible() { return addToCartButton.isDisplayed(); }
    public boolean isAddToCartButtonEnabled() { return addToCartButton.isEnabled(); }
    public void clickAddToCartButton() { addToCartButton.click(); }
    public WebElement getAddToCartButton() { return addToCartButton; }

    public WebElement getQuantityContainer() { return quantityContainer; }
    public boolean isQuantityContainerVisible() { return quantityContainer.isDisplayed(); }
    public void clickQuantityContainer() { quantityContainer.click(); }

    public WebElement getQuantityListBox() { return quantityListBox; }
    public boolean isQuantityListBoxVisible() { return quantityListBox.isDisplayed(); }
    public void clickNumberTwoOnListBox() { numberTwoOnListBox.click(); }

    public WebElement getQuantityIsTwoListBox() { return quantityIsTwoListBox; }
    public boolean isQuantityIsTwoListBoxVisible() { return quantityIsTwoListBox.isDisplayed(); }

}
