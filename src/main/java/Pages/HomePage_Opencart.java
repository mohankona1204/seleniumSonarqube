package Pages;


import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class HomePage_Opencart  {

    @FindBy(xpath="//*[@title='My Account']")
    private WebElement link_myAccount;

    @FindBy(xpath = "//*[text()='Login']")
    private WebElement link_login;

    @FindBy(xpath = "//*[@title=\"My Account\"]//following::a[1]")
    private WebElement link_register;


    public void clickLogin() throws InterruptedException {
        link_myAccount.click();
        link_login.click();

    }

    public void clickRegister()
    {
        link_myAccount.click();
        link_register.click();
    }
}
