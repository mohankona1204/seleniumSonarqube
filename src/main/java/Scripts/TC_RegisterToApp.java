package Scripts;

import Base.BaseTest;
import org.testng.annotations.Test;
import static Base.BaseTest.*;

public class TC_RegisterToApp extends  BaseTest{

    @Test
    public void RegistertoApplication()
    {
        HOMEPAGE_OC.clickRegister();
        REGISTERPAGE_OC.setFirstName("fname");
        REGISTERPAGE_OC.setLastName("lname");
    }
}
