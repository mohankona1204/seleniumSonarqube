package Scripts;

import Base.BaseTest;
import org.testng.annotations.Test;

import static Base.BaseTest.HOMEPAGE_OC;
import static Base.BaseTest.REGISTERPAGE_OC;

public class TC_RegisterToApp1 extends BaseTest{

    @Test
    public void RegistertoApplication1()
    {
        HOMEPAGE_OC.clickRegister();
        REGISTERPAGE_OC.setFirstName("fname");
        REGISTERPAGE_OC.setLastName("lname");

    }
}
