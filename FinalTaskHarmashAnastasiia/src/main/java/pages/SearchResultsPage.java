package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> searchResultsTitle;

    @FindBy(xpath = "//a[@id='p_89/Apple']")
    private WebElement appleFilterButton;

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-secondary']")
    private WebElement filtersCounter;

    public SearchResultsPage(WebDriver driver) { super(driver); }

    public List<WebElement> getSearchResultsTitle() { return searchResultsTitle; }
    public void clickFirstElementInSearchResults() { searchResultsTitle.get(0).click(); }
    public WebElement getAppleFilterButton() { return appleFilterButton; }
    public boolean isAppleFilterButtonVisible() { return appleFilterButton.isDisplayed(); }
    public void clickAppleFilterButton() { appleFilterButton.click(); }

    public WebElement getFiltersCounter() { return filtersCounter; }
    public boolean isFiltersCounterVisible() { return filtersCounter.isDisplayed(); }
    public String getTextFromFiltersCounter() { return filtersCounter.getText(); }

}
