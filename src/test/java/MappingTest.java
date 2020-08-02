import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.openqa.selenium.By.*;

public class MappingTest {
    private final By ARTICLE = tagName("article");

    @Test
    public void delfiMappingTest() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        ArticlesMapper mapper = new ArticlesMapper();
        List<Article> articles = mapper.map(driver.findElements(ARTICLE));

        for (Article article : articles) {
            System.out.println("---------------------");
            System.out.println(article.getFullInfo());
            System.out.println("---------------------");
        }
    }
}
