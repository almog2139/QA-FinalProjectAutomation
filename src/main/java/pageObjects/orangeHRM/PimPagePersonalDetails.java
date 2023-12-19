package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PimPagePersonalDetails {
    @FindBy(css = ".orangehrm-edit-employee-name h6")
    public WebElement employeeName;

    @FindBy(how= How.LINK_TEXT,using = "Job")
    public WebElement jobTablistBtn;

    @FindBy(how= How.XPATH,using = "//form[@class='oxd-form']//div[@class='oxd-select-text-input'][1]")
    public WebElement jobTitleBtn;
}
