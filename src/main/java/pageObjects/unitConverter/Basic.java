package pageObjects.unitConverter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class Basic {
    private AppiumDriver mobileDriver;
    public Basic(AppiumDriver mobileDriver){
        this.mobileDriver=mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);


    }

    //sub-menu
    @AndroidFindBy(id="tab0_layout0")
    public AndroidElement lengthBtn;
    @AndroidFindBy(id="tab0_layout1")
    public AndroidElement areaBtn;
    @AndroidFindBy(id="tab0_layout2")
    public AndroidElement weightBtn;
    @AndroidFindBy(id="tab0_layout3")
    public AndroidElement volumeBtn;

    //inputs
    @AndroidFindBy(id="tab0_input")
    public AndroidElement valueInput;

    @AndroidFindBy(id="tab0_selector")
    public AndroidElement dropDown;
    @AndroidFindBy(id="tab0_numok")
    public AndroidElement okBtn;

    @AndroidFindBy(xpath = "(//*[@id='tab0_list']/*/*/*[@id='unit_value'])[11]")
    public AndroidElement kmValue;



    public MobileElement dynamicElement(String text){
        return (MobileElement) mobileDriver.findElement(By.xpath("//*[text()='" + text + "']"));

    }
    public MobileElement dynamicCalcElement(String  value){
        return (MobileElement) mobileDriver.findElement(By.id("tab0_num"+value));

    }

}



