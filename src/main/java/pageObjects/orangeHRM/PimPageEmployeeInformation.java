package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PimPageEmployeeInformation {

    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[2]//input")
    public WebElement employeeId;

    @FindBy(css = "button[type='submit']")
    public WebElement searchBtn;

    @FindBy(css = ".oxd-table-card")
    public List<WebElement> employees;
    @FindBy(css=".oxd-table-card>div>div:nth-child(9)>.oxd-table-cell-actions>button:first-child")
    public  WebElement deleteBtn;

    @FindBy(css=".orangehrm-modal-footer button:nth-child(2)")
    public  WebElement btnConfirmDeleteEmployee;
}
