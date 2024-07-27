package framework;

import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ParentScenario extends ParentDriver{

    WebDriver driver = getDriver();
//    static void setup() {
//
//        driver = WebDriverManager.chromedriver().setup();
//    }

    public BasePage basePage = new BasePage(driver);
    public GenerateData generateData = new GenerateData(driver);



}
