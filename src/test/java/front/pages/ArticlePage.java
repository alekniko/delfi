package front.pages;

import front.core.BaseFunc;
import org.openqa.selenium.By;

public class ArticlePage {
    public final By ARTICLE_NAME = By.xpath("//div[contains(@class,'article-title')]");

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


}
