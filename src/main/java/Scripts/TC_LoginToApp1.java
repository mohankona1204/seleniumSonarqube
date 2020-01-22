package Scripts;

import Base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Base.BaseTest.HOMEPAGE_OC;
import static Base.BaseTest.LOGINPAGE_OC;


public class TC_LoginToApp1 extends BaseTest{

    @Test
    @Parameters("LoginToOpencart1Data")
    public void logintoApplication1(String excelPath) throws InterruptedException {
        System.out.println(excelPath);
        HOMEPAGE_OC.clickLogin();
        LOGINPAGE_OC.setUsername("email");
        LOGINPAGE_OC.setPassword("pwd");
        LOGINPAGE_OC.clickLogin();
    }


}
