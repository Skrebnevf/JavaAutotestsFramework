package Lib.UI;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "id:Add or edit preferred languages",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Learn more about data collected",
    NEXT_LINK = "id:Next",
    SKIP = "id:Skip",
    GET_STARTED_BUTTON = "id:Get started";

    public WelcomePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementsPresent(STEP_LEARN_MORE_LINK,
                "Cannot find 'Learn more about Wikipedia'",
                5);
    }

    public void waitForNewWayToExplore()
    {
        this.waitForElementsPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'ways to explore'",
                5);
    }

    public void waitForAddOrEditsPreferredLangText()
    {
        this.waitForElementsPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,
                "Cannot find 'Add or edit languages'",
                5);
    }

    public void waitForLearnMoreAboutDataCollectedText()
    {
        this.waitForElementsPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find 'Learn more about data collected'",
                5);
    }

    public void clickNextButton()
    {
        this.waitForElementsPresent(NEXT_LINK,
                "Cannot find 'Next Button'",
                5);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementsPresent(GET_STARTED_BUTTON,
                "Cannot find 'Get Started Button'",
                5);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP,"Cannot find 'SKIP' button", 5);
    }
}
