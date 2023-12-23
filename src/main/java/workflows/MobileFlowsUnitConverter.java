package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import extensions.Verifications;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;


public class MobileFlowsUnitConverter extends CommonOps {
    @Step("fill field and convert some length with value of {value}")
    public  static  void convertByLength(String value,String selectValue){
        MobileActions.click(mainPageUnitConverter.basicBtn);
        MobileActions.click(basicUnitConverter.lengthBtn);
        MobileActions.click(basicUnitConverter.valueInput);
        MobileActions.click(basicUnitConverter.dynamicCalcElement(value));
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
        MobileActions.tap(basicUnitConverter.okBtn);
        MobileActions.click(basicUnitConverter.dropDown);
        MobileActions.click(basicUnitConverter.dynamicElement(selectValue));


    }

     @Step("Convert currency")
    public  static void convertCurrency(String value,String currency){
        MobileActions.click(mainPageUnitConverter.livingBtn);
        MobileActions.click(livingUnitConverter.CurrencyBtn);
        MobileActions.click(livingUnitConverter.valueInput);
        if(value.length()>1){
            for (int i = 0; i < value.length(); i++) {
                char digit = value.charAt(i);
                String digitString = String.valueOf(digit);
                MobileActions.click(livingUnitConverter.dynamicCalcElement(digitString));

            }
        }
        MobileActions.click(livingUnitConverter.okBtn);
        MobileActions.click(livingUnitConverter.dropDown);
        MobileActions.click(livingUnitConverter.dynamicCurrency(currency));

    }
//    @Step("swipe  {count} times")
//    public static void swipe(int count){

//        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
       // MobileActions.tap( mainPageUnitConverter.popupDismissBtn);
      //  MobileActions.click(mainPageUnitConverter.popupDismissBtn);
//        for(int i=0;i<count;i++){
//            MobileActions.swipe(MobileActions.Direction.LEFT);
//        }
       // Verifications.verifyTextElemenet(mainPageUnitConverter.miscBtn,"MISC.");
//    }


    @Step("swipe action")
    public static void swipe(){
        MobileActions.click(mainPageUnitConverter.miscBtn);
        MobileActions.click(miscUnitConverter.favoriteIcon);
        MobileActions.click(miscUnitConverter.cookingCheckbox);
        MobileActions.swipe(MobileActions.Direction.UP);
        Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
        MobileActions.click(miscUnitConverter.awgCheckbox);
        Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
        MobileActions.click(miscUnitConverter.backBtn);


    }


}
