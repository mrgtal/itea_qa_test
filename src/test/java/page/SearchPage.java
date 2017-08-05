package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by oleksandr.orlov on 05.08.2017.
 */
public class SearchPage extends BasePage {


    @FindBy(xpath = "//center//input[@name='btnK']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='gs_htif0']")
    private WebElement searchField;




    public SearchPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(searchButton, 10);
    }

    public boolean isSearchPageLoaded() {

        return waitUntilElementDisplayed(searchButton, 15).isDisplayed();
    }

    public ResultPage enterSearchValue(String searchValue) {
        searchField.sendKeys(searchValue);
        searchButton.click();

        return PageFactory.initElements(webDriver, ResultPage.class);

    }


}
