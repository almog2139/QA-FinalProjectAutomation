package sanity;

import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlowsUnitConverter;

//@Listeners(utilities.Listeners.class)
public class UnitConverterMobile extends CommonOps {

    @Test(description = "Test01 - Convert length")
    @Description("Fill the fields with length of {length} and it converts the length to some scales")
    public void test01_convertLenth(){
        MobileFlowsUnitConverter.convertByLength("5","mm");
        //System.out.println("testss"+basicUnitConverter.kmValue.getText());
       // Verifications.verifyTextMobileElemenet(basicUnitConverter.kmValue,"0.000005");
    }

    @Test(description = "Test02 - Convert currency")
    @Description("Entering a value of a currency and converting the value to several values of other currencies")
    public void test02_convertCurrency(){
        MobileFlowsUnitConverter.convertCurrency("60","USD");
        Verifications.verifyTextMobileElemenet(livingUnitConverter.eurCurrencyValue,"54.24");

    }
    @Test(description = "Test03 -Change misc favorites with swipe (appium method)")
    @Description("Using swip methos of appium  change misc favorites")
    public void test03_switchToMisc(){
        MobileFlowsUnitConverter.swipe();
        Verifications.verifyMobileElemenetIsDisplay(miscUnitConverter.awgBtn);
    }




}
