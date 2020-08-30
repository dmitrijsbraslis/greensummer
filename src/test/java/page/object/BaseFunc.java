package page.object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void openPage(String url) {
        LOGGER.info("Trying to open page: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        driver.get(url);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void click(WebElement element) {
        wait.until(elementToBeClickable(element));
        element.click();
    }

    public void click(By locator) {
        wait.until(elementToBeClickable(locator));
        findElement(locator).click();

//        click(findElement(locator));
    }

    public String getText(By locator) {
        //1.find element
        //2.get text
        LOGGER.info("Lana! Here we are looking for text");

        return findElement(locator).getText();
    }

    public WebElement findElement(By locator) {
        LOGGER.info("Lana asks to find element here");

        wait.until(visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public boolean isElementPresents(By locator) {
        try {
            wait.until(presenceOfElementLocated(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
