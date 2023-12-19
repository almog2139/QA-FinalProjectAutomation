package pageObjects.unitConverter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Misc {
    private AppiumDriver mobileDriver;
    public Misc(AppiumDriver mobileDriver){
        this.mobileDriver=mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    //sub-menu
    @AndroidFindBy(xpath = "//*[@contentDescription='Favorites']")
    public AndroidElement favoriteIcon;
    @AndroidFindBy(xpath = "//*[@class='android.widget.RelativeLayout' and ./*[@text='Binary']]")
    public AndroidElement binaryCheckbox;
    @AndroidFindBy(xpath = "//*[@class='android.widget.RelativeLayout' and ./*[@text='Cooking']]")
    public AndroidElement cookingCheckbox;
    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    public AndroidElement backBtn;
    @AndroidFindBy(xpath = "//*[@class='android.widget.RelativeLayout' and ./*[@text='AWG']]")
    public AndroidElement awgCheckbox;
    @AndroidFindBy(xpath = "//*[@text='AWG']")
    public AndroidElement awgBtn;






}



