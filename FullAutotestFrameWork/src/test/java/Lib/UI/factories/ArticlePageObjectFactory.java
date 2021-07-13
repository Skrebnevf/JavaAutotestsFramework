package Lib.UI.factories;

import Lib.Platform;
import Lib.UI.ArticlePageObject;
import Lib.UI.IOS.IOSArticlePageObject;
import Lib.UI.MWSearchPAgeObject.MWArticlePageObject;
import Lib.UI.android.AndroidArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory
{
    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSArticlePageObject(driver);
        } else {
            return new MWArticlePageObject(driver);
        }
    }
}
