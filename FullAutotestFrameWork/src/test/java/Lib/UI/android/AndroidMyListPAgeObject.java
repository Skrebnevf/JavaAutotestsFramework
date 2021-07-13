package Lib.UI.android;

import Lib.UI.MyListPageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListPAgeObject extends MyListPageObject {

    static
    {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}'";
    }

    public AndroidMyListPAgeObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
