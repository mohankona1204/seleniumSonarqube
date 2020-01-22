package Library;


import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static Base.BaseTest.driver;

import Base.BaseTest.*;

public class MyWaits {






    public void waitForControlAppearsForWebElement(WebElement element) {
        try {
            (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException var3) {
            System.out.println(var3.getMessage());
            System.out.println(var3.getStackTrace());
        } catch (ElementNotVisibleException var4) {
            System.out.println(var4.getMessage());
            System.out.println(var4.getStackTrace());
        } catch (Exception var5) {

        }

    }

    public void waitForControlAppearsForWebElementForList(List<WebElement> element, int waittime) {
        try {
            (new WebDriverWait(driver, (long)waittime)).until(ExpectedConditions.visibilityOfAllElements(element));
        } catch (NoSuchElementException  var4) {
            System.out.println(var4.getMessage());
            System.out.println(var4.getStackTrace());
        } catch (ElementNotVisibleException var5) {
            System.out.println(var5.getMessage());
            System.out.println(var5.getStackTrace());
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
            System.out.println(var6.getStackTrace());
        }

    }

    public void waitForControlAppearsForWebElement(WebElement element, int waitimeSec) {
        try {
            (new WebDriverWait(driver, (long)waitimeSec)).until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException  var4) {
            System.out.println(var4.getMessage());
            System.out.println(var4.getStackTrace());
        } catch (ElementNotVisibleException var5) {
            System.out.println(var5.getMessage());
            System.out.println(var5.getStackTrace());
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
            System.out.println(var6.getStackTrace());
        }

    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            (new WebDriverWait(driver, 60L)).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception var3) {
            System.out.println(var3.getStackTrace());
            System.out.println(var3.getMessage());
        }

    }

    public void waitForAlertElementIsPresent(int waitTime) {
        try {
            (new WebDriverWait(driver, (long)waitTime)).until(ExpectedConditions.alertIsPresent());
        } catch (Exception var3) {
            System.out.println(var3.getStackTrace());
            System.out.println(var3.getMessage());
        }

    }

    public void waitForElementToBeSelected(WebElement element, int waitTime) {
        try {
            (new WebDriverWait(driver, (long)waitTime)).until(ExpectedConditions.elementToBeSelected(element));
        } catch (Exception var4) {
            System.out.println(var4.getStackTrace());
            System.out.println(var4.getMessage());
        }

    }

    public void waitForInvisibilityOfTheElementLocated(List<WebElement> element, int waitTime) {
        try {
            (new WebDriverWait(driver, (long)waitTime)).until(ExpectedConditions.invisibilityOfAllElements(element));
        } catch (Exception var4) {
            System.out.println(var4.getStackTrace());
            System.out.println(var4.getMessage());
        }

    }

    public void waitForInvisibilityOfElementWithText(WebElement element, int waitTime) {
        try {
            (new WebDriverWait(driver, (long)waitTime)).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception var4) {
            System.out.println(var4.getStackTrace());
            System.out.println(var4.getMessage());
        }

    }

    public void waitForPresentInElementValue(WebElement element, String MsgValue, int waitTime) {
        try {
            (new WebDriverWait(driver, (long)waitTime)).until(ExpectedConditions.textToBePresentInElementValue(element, MsgValue));
        } catch (Exception var5) {
            System.out.println(var5.getStackTrace());
            System.out.println(var5.getMessage());
        }

    }

    public void waitForVisibilityOfTheElementLocated(List<WebElement> element, int waitTime) {
        try {
            (new WebDriverWait(driver, (long)waitTime)).until(ExpectedConditions.visibilityOfAllElements(element));
        } catch (Exception var4) {
            System.out.println(var4.getStackTrace());
            System.out.println(var4.getMessage());
        }

    }
}
