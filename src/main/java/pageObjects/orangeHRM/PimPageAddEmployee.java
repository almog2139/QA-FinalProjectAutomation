package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PimPageAddEmployee {


    @FindBy(how= How.NAME,using="firstName")
    public WebElement firstNameField;
    @FindBy(how= How.NAME,using="middleName")
    public WebElement middleNameField;
    @FindBy(how= How.NAME,using="lastName")
    public WebElement lastNameField;
    @FindBy(how= How.XPATH,using="//div[@class='orangehrm-employee-form']/div/div[2]/div/div/div[2]/input")
    public WebElement employeeId;
    @FindBy(how = How.CSS,using = "button[type='submit']")
    public WebElement saveBtn;

    @FindBy(how = How.CSS,using = ".oxd-switch-wrapper")
    public WebElement createLoginPageCheckBox;

    @FindBy(how=How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    public WebElement username;

    @FindBy(how=How.CSS,using = "input[type='password']")
    public List<WebElement> passwords;







}
