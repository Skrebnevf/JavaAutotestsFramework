package Lib.UI.factories;

import Lib.Platform;
import Lib.UI.IOS.IOSMyListPageObject;
import Lib.UI.MWSearchPAgeObject.MWListPageObject;
import Lib.UI.MyListPageObject;
import Lib.UI.android.AndroidMyListPAgeObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListPageObjectFactory
{

    public static MyListPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListPAgeObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSMyListPageObject(driver);
        } else {
            return new MWListPageObject(driver);
        }
    }
}