package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static Base.BaseTest.*;

public class RegisterAccountPage_Opencart {

    @FindBy(id = "input-firstname")
    private WebElement input_firstName;

    @FindBy(id = "input-lastname")
    private WebElement input_lastName;

    public void setFirstName(String fname)
    {
        WAITS.waitForControlAppearsForWebElement(input_firstName);
        OBJECTS_CONTROL.elementSendKeys(input_firstName,fname);
    }

    public void setLastName(String lname)
    {
        WAITS.waitForControlAppearsForWebElement(input_lastName);
        OBJECTS_CONTROL.elementSendKeys(input_lastName,lname);
    }
}
