package Scripts;



import Base.BaseTest;

import Library.utilExcel;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC_LoginToApp extends BaseTest {

    @Test
    @Parameters("LoginToOpencartData")
    public static void logintoApplication(String sheetName) throws InterruptedException, IOException {
        utilExcel.getExcelSheet(System.getProperty("user.dir")+propertyReader.readProperty("TestDataPath"),sheetName);

        HOMEPAGE_OC.clickLogin();
        LOGINPAGE_OC.setUsername("Mohan");
        LOGINPAGE_OC.setPassword("Kona");
        LOGINPAGE_OC.clickLogin();
    }
}
