package Scripts;

import Base.BaseTest;
import org.testng.annotations.Test;

import static Base.BaseTest.HOMEPAGE_OC;
import static Base.BaseTest.REGISTERPAGE_OC;

public class TC_RegisterToApp2 extends BaseTest{

    @Test
    public void RegistertoApplication2()
    {
        HOMEPAGE_OC.clickRegister();
        REGISTERPAGE_OC.setFirstName("fname");
        REGISTERPAGE_OC.setLastName("lname");
    }
}
