package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.ResultPage;
import page.SearchPage;

import static java.lang.Thread.sleep;

/**
 * Created by oleksandr.orlov on 05.08.2017.
 */
public class SearchTest extends BaseTest {

    public WebDriver webDriver;
    public SearchPage searchPage;

    @Parameters({ "browserName" })
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browserName) {
        webDriver = selectBrowserByName(browserName);

        webDriver.navigate().to("https://google.com/");
        searchPage = new SearchPage(webDriver);
    }

    @AfterClass
    public void afterClass() {

 //       webDriver.quit();
    }


    @Test
    public void searchResultsValidation() {

        int expectedCount = 10;
        Assert.assertTrue(searchPage.isSearchPageLoaded(), "Search page is not loaded");
        Assert.assertTrue(searchPage.getPageURL().contains("https://www.google.com"),"Search page Wrong url");
        Assert.assertEquals(searchPage.getPageTitle(), "Google", "Search page title is wrong");

        ResultPage resultPage = searchPage.enterSearchValue("ITEA");

        Assert.assertTrue(resultPage.isResultPageLoaded(), "Result page is not loaded");

        Assert.assertTrue(resultPage.resultsCount()==expectedCount,
                "Page1 Results count =" + resultPage.resultsCount() + ". expected " + expectedCount);

        Assert.assertTrue(resultPage.isAllElementsContain("ITEA"), "Page1. Not All results have ITEA");

        resultPage.switchToResultPage2();

        Assert.assertTrue(resultPage.isResultPageLoaded(), "Result page2 is not loaded");

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(resultPage.resultsCount()==expectedCount,
                "Page2 Results count =" + resultPage.resultsCount() + ". expected " + expectedCount);

        Assert.assertTrue(resultPage.isAllElementsContain("ITEA"), "Page2. Not All results have ITEA");

        System.out.println("hz");

    }



}
