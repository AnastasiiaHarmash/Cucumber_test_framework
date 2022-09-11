package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersAndAccessoriesPage extends BasePage{

    @FindBy(xpath = "//span[@class='a-size-base a-color-base apb-browse-refinements-indent-1 a-text-bold']")
    private WebElement activeCategory;

    public ComputersAndAccessoriesPage(WebDriver driver) { super(driver); }

    public String getTextActiveCategory() { return activeCategory.getText(); }
}
