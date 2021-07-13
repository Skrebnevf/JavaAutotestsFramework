package Lib.UI;

import Lib.Platform;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
    TITLE,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST,
    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    OK_BUTTON,
    ADD_TO_MY_READING_LIST,
    CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("Waiting for title on the article page")
    public WebElement waitForTitleElement()
    {
        return this.waitForElementsPresent(TITLE, "Cannot Find Article Title On Page", 15);
    }

    @Step("Get article title")
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        screenshot(this.takeScreenshot("article_title"));
        if (Platform.getInstance().isAndroid())
        {
        return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    @Step("Waiting swipe to footer")
    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot Find Footer Element",
                    40);
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT, "Cannot find element", 40);
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        }
    }

    @Step("Add some article to reading list")
    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find Button to more options",
                5);

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST,
                "Cannot find element 'add to reading list'",
                5);

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find element 'Got it'",
                5);

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input set name folder",
                5);

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot input text to folder",
                5);

        this.waitForElementAndClick(
                OK_BUTTON,
                "Cannot press element 'OK'",
                5);
    }

    @Step("Remove article from reading list")
    public void removeArticleFromSavedIfItAdded()
    {
        if(this.isElementPresent(OPTIONS_ADD_TO_MY_LIST)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article  find saved",
                    1
            );
            this.waitForElementsPresent(
                    OPTIONS_ADD_TO_MY_LIST,
                    "Cannot find button to add an article to saved list after removing it from list before",
                    1
            );
        }
    }

    @Step("Add second article to my reading list")
    public void addToMyListSecondTitle()
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find Button to more options",
                5);

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST,
                "Cannot find element 'add to reading list'",
                5);

        this.waitForElementAndClick(ADD_TO_MY_READING_LIST,
                "Cannot Find Created Folder",
                5 );
    }

    @Step("Add article to reading list")
    public void addArticleToMySaved()
    {
        if (Platform.getInstance().isMw()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST, "Cannot find option to add article to reading list", 5 );
    }
    public void closeArticle()
    {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot find Button 'X'",
                5);
    } else {
            System.out.println("Method closeArticle() do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }
}
