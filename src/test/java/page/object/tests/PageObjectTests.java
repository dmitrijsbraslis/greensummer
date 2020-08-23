package page.object.tests;

import org.junit.jupiter.api.Test;
import page.object.BaseFunc;
import page.object.pages.ArticlePage;
import page.object.pages.HomePage;

public class PageObjectTests {
    @Test
    public void pageObjectTest() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("delfi.lv");

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(2);
        ArticlePage articlePage = homePage.openArticle(2);

//        ArticlePage articlePage = new ArticlePage(baseFunc);
    }
}
