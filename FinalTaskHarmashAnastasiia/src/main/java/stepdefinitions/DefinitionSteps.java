package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.Locale;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    SignInPage signInPage;
    ComputersAndAccessoriesPage computersAndAccessoriesPage;
    ShoppingCartPage shoppingCartPage;
    ProductPage productPage;
    RegistrationPage registrationPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.isSearchFieldVisible());
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that current URL contains search word {string}")
    public void checkUrlContainsWord(final String searchWord) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(driver.getCurrentUrl().contains(searchWord));
    }

    @And("Check that elements {int} match the request {string}")
    public void checkThatAllElementsMatchTheRequest(int numberOfElements, final String searchRequest) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        int i = 1;
        for (WebElement webElement : searchResultsPage.getSearchResultsTitle()) {
            Assert.assertTrue(webElement.getText().toLowerCase(Locale.ROOT).contains(searchRequest));
            i++;
            if (i > numberOfElements) { break; }
        }
    }

    @And("User clicks on a button Sigh-in")
    public void clickSighInButton() {
        homePage.clickSignInButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User enters incorrect data {string} in the login field")
    public void enterIncorrectDataInLoginField(final String incorrectData) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterTextToLoginField(incorrectData);
    }

    @And("The user clicks on the continue button")
    public void clickContinueButton() {
        signInPage.clickContinueButton();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("An error message appears {string}")
    public void errorMessageAppears(final String errorMessage) {
        Assert.assertTrue(signInPage.checkIsVisibleErrorMessageBox());
        Assert.assertTrue(signInPage.getTextFromErrorMessageBox().contains(errorMessage));
    }

    @And("User checks that the field with the category selection is visible")
    public void checkFieldWithTheCategorySelectionIsVisible() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.isShopByCategoryFieldVisible());
    }

    @And("User clicks on the category Computers and Accessories")
    public void clickOnComputersAndAccessoriesCategory() {
        homePage.clickComputersAndAccessoriesLabel();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that the computers category {string} is active")
    public void checkThatComputersCategoryNameIsActive(final String categoryName) {
        computersAndAccessoriesPage = pageFactoryManager.getComputersAndAccessoriesPage();
        Assert.assertEquals(computersAndAccessoriesPage.getTextActiveCategory(), categoryName);
    }

    @And("User checks that the shopping cart icon is visible")
    public void checkThatCartIconIsVisible() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.isCartIconVisible());
    }

    @And("User clicks on the shopping cart icon")
    public void clickShoppingCartIcon() {
        homePage.clickCartIcon();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that the cart field is visible")
    public void checkThatCartFieldIsVisible() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.isCardFieldVisible());
    }

    @And("User checks that the number of items in the cart = {string}")
    public void checkNumberOfItems(final String numberOfItems) {
        Assert.assertEquals(homePage.getTextCartItemsCounter(), numberOfItems);
    }

    @And("User checks that the cart is empty {string}")
    public void checkThatCartIsEmptyMessage(final String cartIsEmptyMessage) {
        Assert.assertEquals(shoppingCartPage.getTextFromCartMessage(), cartIsEmptyMessage);
    }

    @And("User clicks on the first item in the list")
    public void clickOnFirstItemInList() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickFirstElementInSearchResults();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that the add to cart button is visible and available")
    public void checkThatBuyButtonIsVisibleAndAvailable() {
        productPage = pageFactoryManager.getProductPage();
        Assert.assertTrue(productPage.isAddToCartButtonVisible());
        Assert.assertTrue(productPage.isAddToCartButtonEnabled());
    }

    @And("User clicks Add to Cart button")
    public void clickAddToCartButton() {
        productPage.clickAddToCartButton();
    }

    @And("The user removes an item from the cart")
    public void removeItemFromCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.clickDeleteFromCartButton();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User scroll page to the New Customer button")
    public void scrollPageToNewCustomerButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.moveToNewCustomerButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getNewCustomerButton());
        Assert.assertTrue(homePage.isNewCustomerButtonVisible());
    }

    @And("User clicks on a New Customer button")
    public void clickNewCustomerButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getNewCustomerButton());
        Assert.assertTrue(homePage.isNewCustomerButtonVisible());
        homePage.clickNewCustomerButton();
    }

    @And("User enters wrong email address in email field {string}")
    public void enterWrongEmailAddressInEmailField(final String wrongEmail) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(registrationPage.isEmailFieldVisible());
        registrationPage.enterTextToEmailField(wrongEmail);
    }

    @And("User clicks the Continue button")
    public void clickContinueButtonOnRegistrationPage() {
        Assert.assertTrue(registrationPage.isContinueButtonVisible());
        registrationPage.clickContinueButton();
        registrationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that the error message is visible")
    public void checkThatErrorMessageIsVisible() {
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getErrorMessageWrongEmail());
        Assert.assertTrue(registrationPage.isErrorMessageWrongEmailVisible());
    }

    @And("User waits until the filter buttons are visible")
    public void waitUntilFilterButtonVisible() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getAppleFilterButton());
        Assert.assertTrue(searchResultsPage.isAppleFilterButtonVisible());
    }

    @And("User clicks on the Apple filter button")
    public void clickAppleFilterButton() {
        searchResultsPage.clickAppleFilterButton();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getAppleFilterButton());
        Assert.assertTrue(searchResultsPage.isAppleFilterButtonVisible());
    }

    @And("User checks that the number of filters is visible")
    public void checkNumberOfFiltersIsVisible() {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getFiltersCounter());
        Assert.assertTrue(searchResultsPage.isFiltersCounterVisible());
    }

    @And("User checks that the filter is selected {string}")
    public void checkThatTheFilterIsSelected(final String numberOfSelectedFilters) {
        Assert.assertTrue(searchResultsPage.getTextFromFiltersCounter().contains(numberOfSelectedFilters));
    }

    @And("User checks that the Quantity container is visible")
    public void checkThatQuantityContainerIsVisible() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getQuantityContainer());
        Assert.assertTrue(productPage.isQuantityContainerVisible());
    }

    @And("User clicks on Quantity container")
    public void clickOnQuantityContainer() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickQuantityContainer();
    }

    @And("User checks that the dropdown list is visible")
    public void checkThatDropdownListIsVisible() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getQuantityListBox());
        Assert.assertTrue(productPage.isQuantityListBoxVisible());
    }

    @And("User clicks on number two in the dropdown list")
    public void clickOnNumberTwoInDropdownList() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickNumberTwoOnListBox();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that the selected number is equal to two")
    public void checkThatSelectedNumberIsEqualToTwo() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getQuantityContainer());
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getQuantityIsTwoListBox());
        Assert.assertTrue(productPage.isQuantityIsTwoListBoxVisible());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
