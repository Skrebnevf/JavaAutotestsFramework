package Lib.UI.factories;

import Lib.Platform;
import Lib.UI.IOS.IOSNavigationUI;
import Lib.UI.MWSearchPAgeObject.MWNavigationUI;
import Lib.UI.NavigationUI;
import Lib.UI.android.AndroidNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory
{
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid())
        {
            return new AndroidNavigationUI(driver);
        }
        else if (Platform.getInstance().isIOS())
            {
            return new IOSNavigationUI(driver);
            } else {
            return new MWNavigationUI(driver);
        }
    }
}
