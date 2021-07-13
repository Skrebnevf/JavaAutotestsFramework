package tests;

import Lib.CoreTestCase;
import Lib.UI.SearchPageObject;
import Lib.UI.factories.SearchPageObjectFactory;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class SearchTests extends CoreTestCase {


    @Test
    @Feature(value = "Search")
    @DisplayName("Search test")
    @Description("Search test")
    @Step("Starting testSearch")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("");
        SearchPageObject.waitForSearchResult("");

    }

    @Test
    @Feature(value = "Cancel Search")
    @DisplayName("Cancel search test")
    @Description("Cancel search test")
    @Step("Starting testCancelSearch")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCancelSearch ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }

    @Test
    @Feature(value = "Empty search")
    @DisplayName("Test empty search")
    @Description("Search test")
    @Step("Starting testAmountOfNotEmptySearch")
    @Severity(value = SeverityLevel.MINOR)
    public void testAmountOfNotEmptySearch ()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = ""; //search line
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticle();

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0);
    }

    @Test
    @Feature(value = "Empty search")
    @DisplayName("Test empty search")
    @Description("Search test")
    @Step("Starting testAmountOfEmptySearch")
    @Severity(value = SeverityLevel.MINOR)

    public void testAmountOfEmptySearch ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = ""; //search line
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
    }
}
