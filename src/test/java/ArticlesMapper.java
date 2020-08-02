import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.*;

public class ArticlesMapper {
    private final By IMG = tagName("img");
    private final By TITLE = tagName("h1");
    private final By COMMENT_COUNT = xpath(".//a[contains(@class, 'comment-count')]");

    public List<Article> map(List<WebElement> elements) {
        assertFalse(elements.isEmpty(), "There is nothing to parse");

        List<Article> articles = new ArrayList<Article>();

        for (WebElement element : elements) {
            if (element.getText().length() != 0) {
                int commentCount = 0;
                if (!element.findElements(COMMENT_COUNT).isEmpty()) {
                    System.out.println("Parsing: " + element.getText());
                    String comments = element.findElement(COMMENT_COUNT).getText();
                    comments = comments.substring(1, comments.length() - 1);
                    commentCount = Integer.parseInt(comments);
                }

                articles.add(new Article(element.findElement(IMG).getAttribute("src"),
                        element.findElement(TITLE).getText(),
                        commentCount));
            }
        }

        return articles;
    }
}
