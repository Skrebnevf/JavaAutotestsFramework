package Lib.UI.IOS;

import Lib.UI.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject
{
    static
    {
                TITLE = "id:Java (programming language)";
                FOOTER_ELEMENT = "id:View article in browser";
                OPTIONS_ADD_TO_MY_LIST = "id:Save for later";
                CLOSE_ARTICLE_BUTTON = "id:Back";
    }

    public IOSArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
