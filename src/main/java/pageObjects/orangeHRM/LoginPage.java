package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(css="input[type='password']")
    public WebElement password;

    @FindBy(className = "orangehrm-login-button")
    public WebElement login_btn;
}
