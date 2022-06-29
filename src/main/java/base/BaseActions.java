package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;

public class BaseActions {

    private static final Logger log = Logger.getLogger(BaseActions.class.getName());

    public Boolean tapOnWebElement(WebElement element, WebDriver driver){
        log.info("Tapping on web element");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            return true;
        } catch (Exception e) {
            log.severe("Issues while tapping on web element"+e.getMessage());
            return false;
        }
    }
}
