package Lib.UI.android;

import Lib.UI.NavigationUI;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI
{
    static
    {
    MY_LIST_LINK = "xpath://android.widget.FrameLayout[@content-desc='My list']";
    }

    public AndroidNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
