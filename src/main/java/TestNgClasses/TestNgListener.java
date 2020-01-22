package TestNgClasses;

import Library.MyWaits;
import Library.PropertyReader;
import Library.objControl;
import Pages.HomePage_Opencart;
import Pages.LoginPage_Opencart;
import Pages.RegisterAccountPage_Opencart;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestNgListener implements ITestListener {

    public static WebDriver driver;
    public static PropertyReader propertyReader;
    public static ExtentReports extent;
    public static ExtentTest Report;

    public static objControl OBJECTS_CONTROL = new objControl();
    public static HomePage_Opencart HOMEPAGE_OC = new HomePage_Opencart();
    public static LoginPage_Opencart LOGINPAGE_OC = new LoginPage_Opencart();
    public static RegisterAccountPage_Opencart REGISTERPAGE_OC = new RegisterAccountPage_Opencart();
    public static MyWaits WAITS = new MyWaits();

    public TestNgListener ()
    {
        propertyReader = new PropertyReader();
    }
    @Override
    public void onFinish(ITestContext Result)
    {

    }

    @Override
    public void onStart(ITestContext Result)
    {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result)
    {
        System.out.println("The name of the testcase failed is :"+Result.getName());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result)
    {
        System.out.println("The name of the testcase Skipped is :"+Result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result)
    {
        System.out.println(Result.getName()+" test case started");


    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("The name of the testcase passed is :"+Result.getName());
    }


}
