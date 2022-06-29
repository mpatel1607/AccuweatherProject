package pages;

import base.BaseActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class WeatherPage extends BaseActions {

    private static final Logger log = Logger.getLogger(WeatherPage.class.getName());
    WebDriver driver;

    @FindBy(xpath = "//span[text()='More Details']")
    WebElement moreDetailsLink;

    public WeatherPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean tapOnMoreDetails() {
        log.info("Tapping on 'More Details'");
        return tapOnWebElement(moreDetailsLink, driver);
    }

    public Boolean verifyOnExpectedWeatherPage(String expectedUrl) {
        log.info("Verifying expected weather page opens");
        return expectedUrl.equals(driver.getCurrentUrl());
    }
}
