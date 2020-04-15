package front;

import front.core.BaseFunc;
import front.pages.ArticlePage;
import front.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

        List<WebElement> articleList0 = homePage.getArticles(5);
        for (WebElement e : articleList0) {
            System.out.println(e.getText());
        }


        for (int i = 0 ; i < articleList0.size() ; i++) {
            List<WebElement> articleList = homePage.getArticles(5);
            String artName = articleList.get(i).findElement(homePage.ARTICLE_NAME).getText();
            int commentCount = Integer.parseInt(articleList.get(i).findElement(homePage.ARTICLE_COMMENT_COUNT).getText().replace("(","").replace(")", ""));
            articleList.get(i).findElement(homePage.ARTICLE).click();
//            baseFunc.clickElement(homePage.ARTICLE);
            baseFunc.compareArticleName(artName, articlePage.ARTICLE_NAME);
            baseFunc.compareCommentCount(commentCount, articlePage.COMMENT_COUNT);
            baseFunc.navigateBack();
            baseFunc.waitElementIsVisible(homePage.ARTICLE);
            System.out.println("Done\n\n====================");
        }
    }
}

//        for (WebElement e : articleList) {
//            System.out.println(articleList.toString());
//        }
//    }
//baseFunc.waitElementIsVisible(homePage.ARTICLE_NAME);
//    String articleName = we.getText();
////            System.out.println(articleName);
//            baseFunc.clickElement(homePage.ARTICLE);
//            baseFunc.compareArticleName(articleName, articlePage.ARTICLE_NAME);
//            System.out.println("Checked");
//            baseFunc.navigateBack();




//    @AfterEach
//    public void closeBrowser() {
//        baseFunc.closeBrowser();
//    }
//}
