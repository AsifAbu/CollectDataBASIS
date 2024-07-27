package src;

import framework.ParentScenario;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.BasePage;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/features"},
        glue = {"test"},
        monochrome = true,
        publish = false,
        plugin = {}
//        plugin = { "pretty", "html:target/reports/cucumber-htmlreport.html",
//                "json:target/reports/JSONReports.json",
//                "junit:target/reports/XMLReports.xml"}

)


public class Runner extends AbstractTestNGCucumberTests {


    @AfterSuite
    public static void teardown() {
        ParentScenario.getDriver().quit();
    }


}
