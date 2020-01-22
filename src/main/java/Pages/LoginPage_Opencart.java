package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Base.BaseTest.*;

public class LoginPage_Opencart {

    @FindBy(id = "input-email")
    private WebElement input_email;

    @FindBy(id = "input-password")
    private WebElement input_password;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement button_login;

    public void setUsername(String uname)
    {
        WAITS.waitForControlAppearsForWebElement(input_email);
        OBJECTS_CONTROL.elementSendKeys(input_email,uname);
    }

    public void setPassword(String pwd)
    {
        OBJECTS_CONTROL.elementSendKeys(input_password,pwd);
    }

    public void clickLogin()
    {
        OBJECTS_CONTROL.elementClick(button_login);
    }
}
