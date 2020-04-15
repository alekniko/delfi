package front.pages;

import front.core.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class HomePage {

    public final By ARTICLE = By.tagName("article");
    public final By ARTICLE_NAME = By.xpath("//article/div/div/span/a/h1");
//    public final By ARTICLE_NAME = By.xpath(".//span[@class='text-size-22 d-block']");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> getArticles(int count) {

        List<WebElement> articles = baseFunc.getElements(ARTICLE);
//        List<WebElement> returnedArticles = new ArrayList<WebElement>();
//        for (int i = 0; i < count; i++) {
//            returnedArticles.add(articles.get(i));
//        }

        return articles.subList(0, count - 1);
    }
}
