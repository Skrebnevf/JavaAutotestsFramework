package Lib.UI.IOS;

import Lib.UI.MyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListPageObject extends MyListPageObject
{

    static
    {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name='{TITLE}')]";
    }

    public IOSMyListPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
