package front;

import front.core.BaseFunc;
import front.pages.ArticlePage;
import front.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class FrontTest {
    private BaseFunc baseFunc = new BaseFunc();

    @BeforeEach
    public void beforeMethod() {
        baseFunc.navigateToURL("https://rus.delfi.lv/");

    }

    @Test
    public void someTest() {
        HomePage homePage = new HomePage(baseFunc);
        ArticlePage articlePage = new ArticlePage(baseFunc);

        for (WebElement we : homePage.getArticles(5)) {
            baseFunc.waitElementIsVisible(homePage.ARTICLE_NAME);
            String articleName = we.getText();
//            System.out.println(articleName);
            baseFunc.clickElement(homePage.ARTICLE_NAME);
            baseFunc.compareArticleName(articleName, articlePage.ARTICLE_NAME);
            System.out.println("Checked");
            baseFunc.navigateBack();
        }
    }

//    @AfterEach
//    public void closeBrowser() {
//        baseFunc.closeBrowser();
//    }
}
