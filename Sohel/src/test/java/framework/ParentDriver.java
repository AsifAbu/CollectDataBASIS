package framework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParentDriver {


    static WebDriver driver;

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public static WebDriver getDriver() {

        if (driver == null) {

            if (isWindows()) {
                //WebDriverManager.chromedriver().setup();
                //String projectPath = System.getProperty("user.dir");
                //System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/chromedriver.exe");
                ChromeOptions cOptions = new ChromeOptions();
                //cOptions.addArguments("--start-maximized");
                cOptions.addArguments("--window-size=1920,1080");
                cOptions.addArguments("--remote-allow-origins=*");
//                cOptions.addArguments("disable-infobars"); // disabling infobars
//                cOptions.addArguments("--disable-extensions"); // disabling extensions
//                cOptions.addArguments("--disable-gpu"); // applicable to Windows os only
//                cOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//                cOptions.addArguments("--no-sandbox"); // Bypass OS security model
//                cOptions.addArguments("--disable-in-process-stack-traces");
//                cOptions.addArguments("--disable-logging");
//                cOptions.addArguments("--log-level=3");
                //driver = new ChromeDriver(cOptions);
                //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }
            else if (isMac()) {
                //WebDriverManager.chromedriver().setup();
                WebDriverManager.chromedriver().clearDriverCache().setup();
                //WebDriverManager.chromedriver().clearResolutionCache().setup();
                //String projectPath = System.getProperty("user.dir");
                //System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/chromedriver.exe");
                /*ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("--start-maximized");
                cOptions.addArguments("--remote-allow-origins=*");*/
//                cOptions.addArguments("disable-infobars"); // disabling infobars
//                cOptions.addArguments("--disable-extensions"); // disabling extensions
//                cOptions.addArguments("--disable-gpu"); // applicable to Windows os only
//                cOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//                cOptions.addArguments("--no-sandbox"); // Bypass OS security model
//                cOptions.addArguments("--disable-in-process-stack-traces");
//                cOptions.addArguments("--disable-logging");
//                cOptions.addArguments("--log-level=3");
                driver = WebDriverManager.chromedriver().clearResolutionCache().create();
                driver.manage().window().setSize(new Dimension(1440,1000));
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }
            else if (isUnix()) {
//                System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver");
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--kiosk");
//                driver = new ChromeDriver(chromeOptions);
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }
            else {
                System.out.println("Your OS not support !!!"+OS);
            }

        }
        return driver;

    }
}
