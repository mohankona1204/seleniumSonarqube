package Library;

import Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;
import static Base.BaseTest.driver;

//import org.apache.commons;

public class objControl {

    private static Date date;
    Wait<WebDriver> wait;



    public void elementSendKeys(WebElement element, String data)
    {
        try{
            element.sendKeys(data);
        }catch(Exception e){
            fail("The edit box element is not found");
        }
    }
    public void elementClick(WebElement element)
    {
        try {
            element.click();
        }catch(Exception e) {
            fail("The element is not found");
        }
    }

  //  Select functions
    public boolean selectByValue(WebElement locator, String value) {
        try {
            new Select(locator).selectByValue(value);
            return true;
        }
        catch (Exception e) {
            //verificationErrors.append(e.toString());
            System.out.println("Could not find element");
            return false;
        }
    }

    public boolean selectByText(WebElement locator, String text) {
        try {
            new Select(locator).selectByVisibleText(text);
            return true;
        }
        catch (Exception e) {
            //verificationErrors.append(e.toString());
            System.out.println("Could not find element");
            return false;
        }
    }

    public boolean selectByIndex(WebElement locator, int index) {
        try {
            new Select(locator).selectByIndex(index);
            return true;
        }
        catch (Exception e) {
            //verificationErrors.append(e.toString());
            System.out.println("Could not find element");
            return false;
        }
    }

    public String getFirstSelectedOptionText(WebElement locator) {
        String val = null;
        try {
            val = new Select(locator).getFirstSelectedOption().getText();
            return val;
        }
        catch (Exception e) {
            val = null;
            System.out.println("Could not find element");
            return val;
        }
    }

    //scroll To Element
    public void scrollToElement(String xpath) throws Exception {
        WebElement element = driver.findElement(By.xpath(xpath));
        if (xpath.startsWith(".//*[@id=")) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).moveByOffset(20, 20).click(element).build().perform();
        } else {
            if (!xpath.startsWith(".//*[@data-start-automation-id=")) {
                throw new Exception("Wrong or no ID in xpath");
            }

            if (!element.isDisplayed()) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
            }

            element.click();
        }

    }


   // Alert functions
    public void acceptAlert(){
        Alert popup = driver.switchTo().alert();
        popup.accept();
    }

    public void dismissAlert() {
        Alert popup = driver.switchTo().alert();
        popup.dismiss();
    }

    //To highlight an element
    public void drawBorder(WebElement locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", locator);
    }

    //Frame handling
    public void getFrames(){
        List<WebElement> ele = driver.findElements(By.tagName("frame"));
        System.out.println("frames nb: " + ele.size());
        if (ele.size()!=0){
            for(WebElement el : ele){
                System.out.println(el.getAttribute("name"));
            }
        } else { System.out.println("-null-"); }
    }


    //Date
    public static String getDate(String DatePattern){
        DateFormat dateFormat = new SimpleDateFormat(DatePattern);
        date = new Date();
        return dateFormat.format(date);
    }


     // ScreenShot
    public static void captureScreenshot(WebDriver driver,String screenshotName,String format) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            //FileUtils.copyFile(source, new File("./src/test/resources/screenshots/"+screenshotName +format));
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }

    }
        public String getScreenShot() throws Exception {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            //after execution, you could see a folder "FailedTestsScreenshots" under src folder
            String destination = System.getProperty("user.dir") + "/Screenshots/"+"screenshotName"+dateName+".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            return destination;
        }

    }






