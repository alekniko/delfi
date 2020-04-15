package front.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import java.util.List;

public class BaseFunc {
    private WebDriver driver;


    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/nikomale/Documents/WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.close();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void waitElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void compareArticleName(String articleNameHomePage, By articleNameArtPage) {
        waitElementIsVisible(articleNameArtPage);
        String artName = driver.findElement(articleNameArtPage).getText();
        System.out.println(articleNameHomePage);
        System.out.println(artName);
        Assertions.assertEquals(articleNameHomePage, artName, "Article name in Home Page is not the same as article name in Article Page");
    }
}
