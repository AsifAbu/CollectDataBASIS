package pages;

import framework.Constants;
import framework.ParentDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage extends ParentDriver {
    static WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    //WebElement element2;
    Actions action;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);
        this.driver = driver;
    }

    public void teardownBaseObject() {
        driver.quit();
    }

    public void verifyBrowserIsOpen(){
        Assert.assertFalse(driver.toString().contains("null"));
    }

    public void navigateToPage() {
        driver.navigate().to("https://basis.org.bd/member-list");
    }

    //Element click ability check, return webElement from Xpath
    public WebElement waitUntilClickable(String xpathOfTheElement) {
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOfTheElement)));
        return element;
    }

    //Element click ability check, return webElement
    public WebElement waitUntilClickable(WebElement element) {
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    //Element visibility check, return webElement
    public WebElement waitUntilElementVisible(WebElement element) {
        element = wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    //Element presence check, return boolean
    public boolean elementPresence(String elementLocator) {
        boolean flag;
        flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementLocator)));
        return flag;
    }
}
