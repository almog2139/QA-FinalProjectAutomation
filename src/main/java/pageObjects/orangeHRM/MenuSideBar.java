package pageObjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuSideBar {
    @FindBy(xpath = "//span[text()='PIM']")
//    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li[2]/a")
    public WebElement sideMenuPinBtn;
}
