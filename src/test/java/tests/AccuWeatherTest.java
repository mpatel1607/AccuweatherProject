package tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WeatherMoreDetailsPage;
import pages.WeatherPage;
import java.util.ArrayList;
import java.util.List;

public class AccuWeatherTest extends BaseTest {

    String weatherPageUrl = "https://www.accuweather.com/en/ca/windsor/n9a/weather-forecast/1183?current=true";
    String moreDetailsPageUrl = "https://www.accuweather.com/en/ca/windsor/n9a/current-weather/1183";

    @Description("Open accuweather -> Use current location -> Allow location access -> Tap on 'More Details' -> Verify page with more details opens by verifying URL")
    @Test
    public void verifyTapOnMoreDetailsOpensExpectedPage() throws InterruptedException {

        List<String> arrayWindows = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String)arrayWindows.get(1));

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.tapOnSearchInput(), "Unable to tap on location search bar");
        Assert.assertTrue(homePage.tapOnUseCurrentLocation(), "Unable to tap on 'Use Current Location'");
        Thread.sleep(5000); // Waiting for page to load
        driver.switchTo().parentFrame();
        WeatherPage weatherPage = new WeatherPage(driver);
        Assert.assertTrue(weatherPage.verifyOnExpectedWeatherPage(weatherPageUrl), "Opened unexpected weather page");
        Assert.assertTrue(weatherPage.tapOnMoreDetails(), "Unable to tap on 'More Details' button from weather page");
        Thread.sleep(5000); // Waiting for page to load
        WeatherMoreDetailsPage moreDetailsPage = new WeatherMoreDetailsPage(driver);
        Assert.assertTrue(moreDetailsPage.verifyOnExpectedMoreDetailsPage(moreDetailsPageUrl), "Opened unexpected 'More Details' page");
    }
}
