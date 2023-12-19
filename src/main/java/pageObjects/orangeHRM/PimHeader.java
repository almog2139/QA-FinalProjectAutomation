package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PimHeader {
    @FindBy(how= How.XPATH,using="//nav[@role='navigation']/ul/li[3]")
    public WebElement addEmployeebtn;
    @FindBy(how= How.XPATH,using="//nav[@role='navigation']/ul/li[2]")
    public WebElement employeeListbtn;
}
