package page.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import page.object.BaseFunc;

import static org.openqa.selenium.By.*;

public class CommentsPage {
    private final By TITLE = xpath(".//h1[@class = 'article-title']/a");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public CommentsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting this awesome title");

        return baseFunc.getText(TITLE);
    }
}
