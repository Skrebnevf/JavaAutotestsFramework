package Lib.UI;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;


public abstract class SearchPageObject extends MainPageObject{

    protected static String
    SEARCH_INIT_ELEMENT,
    SEARCH_INPUT,
    SEARCH_CANCEL_BUTTON,
    SEARCH_RESULT_BY_SUBSTRING_TPL,
    SEARCH_RESULT_ELEMENT,
    SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATE METHOD */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATE METHOD */

    @Step("Init the screen field")
    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot Find Element In Search", 5);
        this.waitForElementsPresent(SEARCH_INIT_ELEMENT, "Cannot Find Search Input After Click Element", 5);
    }

    @Step("Waiting for button to cancel search result")
    public void waitForCancelButtonToAppear()
    {
        this.waitForElementsPresent(SEARCH_CANCEL_BUTTON, "Cannot Find Search Cancel Button", 5);
    }

    @Step("Clicking button to cancel search result")
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot Find And Click Search Cancel Button", 5);
    }

    @Step("Clicking Cancel Button")
    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Cannot Find Search Cancel Button Is Still Present", 5);
    }

    @Step("Typing '{search_line}' to search line")
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot Find And Type Into Search Input",5);
    }


    @Step("Search result on substring")
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementsPresent(search_result_xpath,"Cannot Find Search Result With Substring" + substring, 5);
    }

    @Step("Clicking on substring button")
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath,"Cannot Find And Click With Substring" + substring, 10);
    }

    @Step("Found article")
    public int getAmountOfFoundArticle()
    {
        this.waitForElementsPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything in search line",
                15);
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    @Step("Waiting for empty search result")
    public void waitForEmptyResultsLabel()
    {
        this.waitForElementsPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);
    }

}
