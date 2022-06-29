package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.File;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class BaseTest {

    public static WebDriver driver;
    static String path = "chromedriver.exe";
    static String url = "https://www.accuweather.com/";
    private static final Logger log = Logger.getLogger(BaseTest.class.getName());

    @BeforeTest
    public void launchBrowser(){
        log.info("Initializing Chrome Driver");
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("profile.default_content_settings.geolocation", 1);
        jsonObject.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", jsonObject);
        options.addExtensions(new File("extension_4_46_2_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        driver = new ChromeDriver(options);
        log.info("Launching Accuweather web page");
        driver.get(url);
    }

    @AfterTest
    public void closeBrowser(){
        log.info("Quiting web driver after all test runs");
        driver.quit();
    }
}
