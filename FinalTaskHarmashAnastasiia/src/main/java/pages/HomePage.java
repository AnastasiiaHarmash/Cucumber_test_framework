package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement signInButton;

    @FindBy(xpath = "//h2[contains(text(), 'Shop by Category')]")
    private WebElement shopByCategoryField;

    @FindBy(xpath = "//a[@aria-label='Computers & Accessories']")
    private WebElement computersAndAccessoriesLabel;

    @FindBy(xpath = "//div[@id='nav-cart-count-container']")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartItemsCounter;

    @FindBy(xpath = "//a[@class='sign-in-tooltip-link']")
    private WebElement newCustomerButton;

    public HomePage(WebDriver driver) { super(driver); }

    public void openHomePage(String url) { driver.get(url); }
    public boolean isSearchFieldVisible() { return searchField.isDisplayed(); }
    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }
    public void clickSearchButton() { searchButton.click(); }
    public void clickSignInButton() { signInButton.click(); }
    public boolean isShopByCategoryFieldVisible() { return shopByCategoryField.isDisplayed(); }
    public void clickComputersAndAccessoriesLabel() { computersAndAccessoriesLabel.click(); }
    public boolean isCartIconVisible() { return cartIcon.isDisplayed(); }
    public void clickCartIcon() { cartIcon.click(); }
    public String getTextCartItemsCounter() { return cartItemsCounter.getText(); }
    public boolean isNewCustomerButtonVisible() { return newCustomerButton.isDisplayed(); }
    public void clickNewCustomerButton() { newCustomerButton.click(); }

    public WebElement getNewCustomerButton() { return newCustomerButton; }

    public void moveToNewCustomerButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4200)");
    }
}
