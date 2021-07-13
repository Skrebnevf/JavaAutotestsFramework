package Lib.UI.factories;

import Lib.Platform;
import Lib.UI.IOS.IOSSearchPageObject;
import Lib.UI.MWSearchPAgeObject.MWSearchPAgeObject;
import Lib.UI.SearchPageObject;
import Lib.UI.android.AndroidSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory
{
    public static SearchPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(driver);
        } else if (Platform.getInstance().isIOS())
        {
            return new IOSSearchPageObject(driver);
        } else {
            return new MWSearchPAgeObject(driver);
        }
    }
}
