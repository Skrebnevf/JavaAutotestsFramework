package Lib.UI.IOS;

import Lib.UI.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUI extends NavigationUI
{
    static
    {
        MY_LIST_LINK = "id:Saved";
    }

    public IOSNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
