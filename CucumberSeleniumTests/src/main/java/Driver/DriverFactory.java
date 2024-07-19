package Driver;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }
    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {
            case "chrome" -> {
                  /* System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=+");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);*/
                driver = new ChromeDriver();
                break;

            }

            case "firefox" -> {
                driver = new FirefoxDriver();
                break;
            }
        }
            driver.manage().window().maximize();
            return driver;

    }

    public static String getBrowserType()
    {
        String browserType = null;
        String browsertypeRemoteValue = System.getProperty("browserType");

        try {
            if (browsertypeRemoteValue == null || browsertypeRemoteValue.isEmpty()) {
                Properties properties = new Properties();
                FileInputStream file =
                        new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
                System.out.println(browserType);
            } else {
                browserType = browsertypeRemoteValue;
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return browserType;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
