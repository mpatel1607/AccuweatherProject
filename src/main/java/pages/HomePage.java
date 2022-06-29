package pages;

import base.BaseActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.logging.Logger;

public class HomePage extends BaseActions {

    WebDriver driver;
    private static final Logger log = Logger.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//*[@class='search-input']")
    WebElement searchInput;

    @FindBy(xpath = "//*[@class='current-location-text']")
    WebElement currentLocation;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean tapOnSearchInput(){
        log.info("Tapping on location search bar");
        return tapOnWebElement(searchInput, driver);
    }

    public Boolean tapOnUseCurrentLocation(){
        log.info("Tapping on 'Use Current Location'");
        return tapOnWebElement(currentLocation, driver);
    }
}
