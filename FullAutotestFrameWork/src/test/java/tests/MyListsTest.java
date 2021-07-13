package tests;

import Lib.CoreTestCase;
import Lib.Platform;
import Lib.UI.AuthorizationPageObject;
import Lib.UI.MyListPageObject;
import Lib.UI.NavigationUI;
import Lib.UI.factories.ArticlePageObjectFactory;
import Lib.UI.factories.MyListPageObjectFactory;
import Lib.UI.factories.NavigationUIFactory;
import Lib.UI.factories.SearchPageObjectFactory;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
    private static final String
    login = "",
    password = "";


    @Test
    @Feature(value = "Save Article to reading list")
    @DisplayName("Save article")
    @Description("Reading list")
    @Step("Starting testSaveFirstArticleToMyList")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSaveFirstArticleToMyList()
    {
        Lib.UI.SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(""); //search line
        SearchPageObject.clickByArticleWithSubstring(""); //substring

        Lib.UI.ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }
        if (Platform.getInstance().isMw()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();

            Assert.assertEquals("We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );

            ArticlePageObject.addArticleToMySaved();
        }

        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.OpenNavigation();
        NavigationUI.clickMyList();
        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid())
        {
            MyListPageObject.openFolderByName(name_of_folder);
        }

        MyListPageObject.swipeArticleToDelete(article_title);

    }

}
