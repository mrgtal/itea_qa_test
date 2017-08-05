package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksandr.orlov on 05.08.2017.
 */
public class ResultPage extends BasePage {

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultStats;

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> resultsList;

    @FindBy(xpath = "//div//table[@id='nav']//tbody//tr//a[@aria-label='Page 2']")
    private WebElement resultPageButton2;

    @FindBy(className = "curr")
    private WebElement currentPage;


    public ResultPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }


    public boolean isResultPageLoaded() {

        return waitUntilElementDisplayed(resultStats, 15).isDisplayed();
    }


    public boolean isAllElementsContain(String requiredValue) {
        for(WebElement resultListElement : resultsList) {
            if(!resultListElement.getText().toLowerCase().contains(requiredValue.toLowerCase())) {
                return false;
            }

System.out.println(resultListElement.getText());

        }
        return true;

    }

    public int resultsCount() {

        return resultsList.size();
    }


    public void switchToResultPage2() {
        waitUntilElementDisplayed(resultPageButton2, 15).isDisplayed();
        resultPageButton2.click();
        isResultPageLoaded();

    }




}
