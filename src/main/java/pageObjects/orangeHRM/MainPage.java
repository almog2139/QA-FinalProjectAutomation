package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how= How.CSS,using=".oxd-topbar-header-breadcrumb h6")
    public WebElement mainPageHeader;


    @FindBy(how=How.CSS,using = ".oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget")
    public List<WebElement> dashboardItems;

}
