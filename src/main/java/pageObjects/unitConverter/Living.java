package pageObjects.unitConverter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Living {
    private AppiumDriver mobileDriver;
    public Living(AppiumDriver mobileDriver) {
        this.mobileDriver=mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }
    //sub-menu

    @AndroidFindBy(id="tab1_layout0")
    public AndroidElement CurrencyBtn;
    @AndroidFindBy(id="tab1_layout2")
    public AndroidElement timeBtn;
    //inputs
    @AndroidFindBy(id="tab1_input")
    public AndroidElement valueInput;

    @AndroidFindBy(id="tab1_selector")
    public AndroidElement dropDown;
    @AndroidFindBy(id="tab1_numok")
    public AndroidElement okBtn;
    @AndroidFindBy(xpath = "(//*[@id='tab1_list']/*/*/*/*[@id='unit_value'])[3]")
    public AndroidElement eurCurrencyValue;


    public MobileElement dynamicCalcElement(String  value){
        return (MobileElement) mobileDriver.findElement(By.id("tab1_num"+value));

    }
    public MobileElement dynamicCurrency(String value) {
        return (MobileElement) mobileDriver.findElement(By.xpath("//*[contains(text(), '" + value + "')]"));
    }



}
