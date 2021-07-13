package tests;

import Lib.CoreTestCase;
import Lib.Platform;
import Lib.UI.WelcomePageObject;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase
{
    @Test
    @Feature(value = "Pass welcome screen")
    @DisplayName("Welcome page")
    @Description("Pass welcome screen")
    @Step("Starting testPassThroughWelcome")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testPassThroughWelcome()
    {
        if((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMw())) {return;}
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.waitForLearnMoreLink();
        WelcomePageObject.clickNextButton();
        WelcomePageObject.waitForNewWayToExplore();
        WelcomePageObject.clickNextButton();
        WelcomePageObject.waitForAddOrEditsPreferredLangText();
        WelcomePageObject.clickNextButton();
        WelcomePageObject.waitForLearnMoreAboutDataCollectedText();
        WelcomePageObject.clickGetStartedButton();
    }
}
