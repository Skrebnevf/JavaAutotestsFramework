package tests;
import Lib.CoreTestCase;
import Lib.UI.ArticlePageObject;
import Lib.UI.SearchPageObject;
import Lib.UI.factories.ArticlePageObjectFactory;
import Lib.UI.factories.SearchPageObjectFactory;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for article")
public class ArticleTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("Compare article title with expected one")
    @Description("We open Java OOP language article and make sure")
    @Step("Starting test testCompareArticleTitle")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testCompareArticleTitle ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(""); //Search line
        SearchPageObject.clickByArticleWithSubstring(""); //Substring Search
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.getArticleTitle();
        String article_title = ArticlePageObject.getArticleTitle();

        ArticlePageObject.takeScreenshot("article_page");
        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title);
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("Swipe article to the footer")
    @Description("We open an article and swipe to the footer")
    @Step("Starting test testSwipeArticleTitle")
    @Severity(value = SeverityLevel.MINOR)
    public void testSwipeArticleTitle ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(""); //Search Line
        SearchPageObject.clickByArticleWithSubstring(""); //Substring
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
    }
}
