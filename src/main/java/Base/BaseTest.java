package Base;


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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public static WebDriver driver;
    public static PropertyReader propertyReader;
    public static ExtentReports extent;
    public static ExtentTest Report;

    public static objControl OBJECTS_CONTROL = new objControl();
    public static HomePage_Opencart HOMEPAGE_OC = new HomePage_Opencart();
    public static LoginPage_Opencart LOGINPAGE_OC = new LoginPage_Opencart();
    public static RegisterAccountPage_Opencart REGISTERPAGE_OC = new RegisterAccountPage_Opencart();
    public static MyWaits WAITS = new MyWaits();


    public BaseTest ()
    {
        propertyReader = new PropertyReader();
    }

    @BeforeClass
    public void testSetUp() throws MalformedURLException {

    }

    @AfterTest
    public void tearDown() throws IOException {

    }

    @AfterMethod
    public void testTearDown() throws IOException {
        driver.close();
        driver.quit();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        setDriver();
        System.out.println("in before method");
        PageFactory.initElements(driver,HOMEPAGE_OC);
        PageFactory.initElements(driver,LOGINPAGE_OC);
        PageFactory.initElements(driver,REGISTERPAGE_OC);
    }


    public static void setDriver() throws MalformedURLException {
        String browser = propertyReader.readProperty("browser").toString();
        Boolean Grid = Boolean.parseBoolean(propertyReader.readProperty("UseSeleniumGrid"));
        long implicitWait = Integer.parseInt(propertyReader.readProperty("implicitWaitInSeconds"));
//        String Host = propertyReader.readProperty("GridHubAddress");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +propertyReader.readProperty("chromePath"));
                //driver = new ChromeDriver();
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
               // options.addArguments("test-type");
//                options.setExperimentalOption("debuggerAddress","10.77.253.207:8181");
//                if (Grid){
//                    driver= new RemoteWebDriver(new URL(Host), cap);
//                }
//                else {
                   driver= new ChromeDriver(options);
//                }

                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");

                DesiredCapabilities cap1 = DesiredCapabilities
                        .internetExplorer();
                InternetExplorerOptions optionsIE = new InternetExplorerOptions();
                optionsIE.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,
                        true);

                cap1.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,
                        true);
                optionsIE.setCapability(
                        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                        true);
                optionsIE.setCapability(
                        InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
                optionsIE.setCapability(
                        InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP,
                        true);

                cap1.setCapability(
                        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                        true);
                cap1.setCapability(
                        InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
                cap1.setCapability(
                        InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP,
                        true);
                cap1.setCapability("nativeEvents", false);

//                if (Grid){
//                 driver= new RemoteWebDriver(new URL(Host), cap1);
//                }
//                else {
//                   driver= new InternetExplorerDriver(optionsIE);
//                }

                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new WebDriverException();
        }
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loadUrl();
    }

    public static void loadUrl() {
        URL baseUrl;
        HttpURLConnection connection = null;
        try {
            baseUrl = new URL(propertyReader.readProperty("url"));
           // connection = (HttpURLConnection) baseUrl.openConnection();
          //  connection.connect();
           // if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
               // LOGGER.error("Unable to connect to the url connection");
               // LOGGER.error("Response Code " + connection.getResponseCode());
               // LOGGER.error("Response Message " + connection.getResponseMessage());
           // }
            driver.get(baseUrl.toString());
        } catch (IOException e) {
           // LOGGER.error("URL connection error");
            e.printStackTrace();
        }
    }

    public void getResult(){

//        extent.endTest(Report);
    }

    public void endReport(){
        // writing everything to document
        //flush() - to write or update test information to your report.
//        extent.flush();
        //Call close() at the very end of your session to clear all resources.
        //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
        //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream.
        //Once this method is called, calling any Extent method will throw an error.
        //close() - To close all the operation
//        extent.close();
    }
}
