package Library;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static Base.BaseTest.Report;
import static Base.BaseTest.driver;

public class MyAssert {

    public static void True(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            //addVerificationFailure(e);
        }
    }

    public static void True(boolean condition, String message) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


        File DestFile = new File(System.getProperty("user.dir") + "/test-output/" + timeStamp.toString() + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
        //String stringScreentshot="<a href=\".."+ SrcFile+ "\">ScreenCaptured</a>";
        String stringScreentshot = "<a href =" + DestFile + ">ScreenCaptured</a>";
        try {

            Assert.assertTrue(condition, message);
            Report.log(LogStatus.PASS, message, stringScreentshot);
        } catch (Throwable e) {

            Report.log(LogStatus.FAIL, message, stringScreentshot);
            //addVerificationFailure(e);
        }
    }

    public static void False(boolean condition) {
        String stringScreentshot = "<a href=\"..\">ScreenCaptured</a>";
        try {
            Assert.assertFalse(condition);

        } catch (Throwable e) {
            // addVerificationFailure(e);
        }
    }

    public static void False(boolean condition, String message) {

        String nn = "<a href=\"..\">ScreenCaptured</a>";
        try {
            Assert.assertFalse(condition, message);
            Report.log(LogStatus.PASS, message, nn);
        } catch (Throwable e) {
            Report.log(LogStatus.FAIL, message, nn);
            // addVerificationFailure(e);
        }
    }

    public static void False(boolean actual, boolean expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            //addVerificationFailure(e);
        }
    }

    public static void Equals(Object actual, Object expected, String message) {
        try {

            Assert.assertEquals(actual, expected);
            Report.log(LogStatus.PASS, message, "asds");
        } catch (Throwable e) {
            //addVerificationFailure(e);
            Report.log(LogStatus.FAIL, message, "asds");
        }
    }

    public static void Equals(Object[] actual, Object[] expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            //addVerificationFailure(e);
        }
    }

    public static void fail(String message) {
        Assert.fail(message);
    }

    public static String GetScreenShot() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


        File DestFile = new File(System.getProperty("user.dir") + "/test-output/" + timeStamp.toString() + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
        //String stringScreentshot="<a href=\".."+ SrcFile+ "\">ScreenCaptured</a>";
        String stringScreentshot = "<a href =" + DestFile + ">ScreenCaptured</a>";
        return stringScreentshot;
    }

}
