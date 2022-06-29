package pages;

import base.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.logging.Logger;

public class WeatherMoreDetailsPage extends BaseActions {

    private static final Logger log = Logger.getLogger(WeatherMoreDetailsPage.class.getName());
    WebDriver driver;

    public WeatherMoreDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyOnExpectedMoreDetailsPage(String pageUrl) {
        log.info("Verifying if expected more details page opens with URL: " + pageUrl);
        return pageUrl.equals(driver.getCurrentUrl());
    }
}
