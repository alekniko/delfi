package front.pages;

import front.core.BaseFunc;
import org.openqa.selenium.By;

public class ArticlePage {
    public final By ARTICLE_NAME = By.xpath("//div[contains(@class,'article-title')]/h1");
    public final By COMMENT_COUNT = By.xpath("//div[contains(@class,'article-title')]/a");

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


}
