package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream inStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(inStream);
        if (driver == null) {
            if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
            }
            if(prop.getProperty("browser").equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            }
            driver.get(prop.getProperty("qaUrl"));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

}
