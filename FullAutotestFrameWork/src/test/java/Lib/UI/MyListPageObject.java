package Lib.UI;

import Lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListPageObject extends MainPageObject{

    protected static String
    FOLDER_BY_NAME_TPL,
    REMOVE_FROM_SAVED_BUTTON,
    ARTICLE_BY_TITLE_TPL;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSaveArticleByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name" + name_of_folder,
                5);
    }

    public void waitArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(article_xpath,
                "Cannot find saved article by title",
                15);
    }

    public void waitArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent(article_xpath,
                "Saved article still present with title",
                15);
    }

    public void swipeArticleToDelete(String article_title)
    {
        this.waitArticleToAppearByTitle(article_title);
        String article_xpath = getFolderXpathByName(article_title);
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.swipeElementToLeft(article_xpath,
                    "Cannot find saved article");
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article from saved",
                    10
            );
        }
        if (Platform.getInstance().isIOS())
        {
        this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }
        if (Platform.getInstance().isMw()) {
            driver.navigate().refresh();
        }
        this.waitArticleToDisappearByTitle(article_title);
    }
}
