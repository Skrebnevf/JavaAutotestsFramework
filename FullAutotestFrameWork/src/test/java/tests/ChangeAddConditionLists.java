package tests;

import Lib.CoreTestCase;
import Lib.Platform;
import Lib.UI.ArticlePageObject;
import Lib.UI.SearchPageObject;
import Lib.UI.factories.ArticlePageObjectFactory;
import Lib.UI.factories.SearchPageObjectFactory;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ChangeAddConditionLists extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Orientation"), @Feature(value = "Assert")})
    @DisplayName("Screen orientation")
    @Description("Test Change Screen orientation")
    @Step("Starting test testChangeScreenOrientationOnSearchResult")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testChangeScreenOrientationOnSearchResult()
    {
        if (Platform.getInstance().isMw()) {
            return;
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(""); //Search line
        SearchPageObject.clickByArticleWithSubstring(""); //substring
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals("Article title have been change before rotation",
                title_before_rotation, title_after_rotation);

        this.rotateScreenPortrait();
        String title_second_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals("Article title have been change after rotation",
                title_before_rotation, title_second_rotation);
    }

    @Test
    @Feature(value = "Background")
    @DisplayName("Background")
    @Description("Article Background")
    @Step("Starting testArticleBackground")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testArticleBackground ()
    {
        if (Platform.getInstance().isMw()) {
            return;
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(""); //Search line
        SearchPageObject.waitForSearchResult(""); //substring
        this.backgroundApp();
        SearchPageObject.waitForSearchResult(""); //return results
    }
}
