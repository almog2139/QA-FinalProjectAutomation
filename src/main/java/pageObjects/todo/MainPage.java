package pageObjects.todo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;


public class MainPage {

    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "input_b5pqF")
    public WebElement createInput;

    @FindBy(className = "taskWrapper_2u8dN")
    public List<WebElement> tasks;
    @FindBy(className = "destroy_19w1q")
    public WebElement deleteBtn;
    @FindBy(className = "tagSelector_1mhz5")
    public WebElement openColorSelectBtn;
    @FindBy(className = "downArrowIcon_3Zu5N")
    public WebElement arrowIcon;
    @FindBy(className = "toggleVisibilityPanel_hNPyc")
    public WebElement visiblityToggleBtn;
    @FindBy(css = ".toggleIconsWrapper_2kpi8 svg")
    public WebElement completeSvgBtn;

    @FindBy(className = "tag_3u4he")
    public List<WebElement> colors;

    public WebElement dynamicElement(String color){
        WebElement element = driver.findElement(By.xpath("//div[@class='wrapper_3Kpfj vertical_di1oV tagList_2NRe0']//span[@style='background: rgb" + color + ";']"));
        return element;

    }
    public WebElement dynamicColorToSelect(String color){
        WebElement element = driver.findElement(By.xpath("//div[@class='wrapper_3Kpfj tagsWrapper_jJPK-']/span[@style='background: rgb" + color + ";']"));
        return element;

    }
}
