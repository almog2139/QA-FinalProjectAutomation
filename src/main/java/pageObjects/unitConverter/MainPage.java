package pageObjects.unitConverter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {

    private AppiumDriver mobileDriver;
    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver=mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);


    }
    //menu
    @AndroidFindBy(xpath="//*[text()='BASIC']")
    public AndroidElement basicBtn;
    @AndroidFindBy(xpath="//*[text()='LIVING']")
    public AndroidElement livingBtn;
    @AndroidFindBy(xpath="//*[text()='SCIENCE']")
    public AndroidElement scienceBtn;
    @AndroidFindBy(xpath="//*[contains(text(), 'MISC')]")
    public AndroidElement miscBtn;
    @AndroidFindBy(id="button2")
    public AndroidElement popupDismissBtn;



}
