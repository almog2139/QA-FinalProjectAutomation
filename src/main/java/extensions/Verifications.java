package extensions;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

public class Verifications extends CommonOps {


    @Step("Verify text in  element")
    public static void verifyTextElemenet(WebElement elem,String expectedText){
        wait.until(ExpectedConditions.textToBePresentInElement(elem,expectedText));
        Assert.assertEquals(elem.getText(),expectedText,"The text  is not as expected");

    }
    @Step("Verify number of elements")
    public static void verifyNumberOfElements(List<WebElement> elements, int expectedNumber) {
        if (elements.isEmpty()) {
            // Handle the case where the list is empty (size is 0)
            Assert.assertEquals(0, expectedNumber, "The list is empty");
        } else {
            // Wait until the size of the list becomes equal to 1 using lambda expression
            wait.until(d -> elements.size() == expectedNumber);
            Assert.assertEquals(elements.size(), expectedNumber, "The size of the list is not as expected");
        }
    }

    @Step("Verify visibilty of elements with using soft-asserion")
    public static void verifyVisibiltyOfElements(List<WebElement>elements){
        for (WebElement element:elements){
            softAssert.assertTrue(element.isDisplayed(),element.getText()+"  not exsits!");
        }
        softAssert.assertAll("some elements are not displayed");
    }

    @Step("Verify text of elements with using soft-asserion")
    public static void verifyElementsText(List<String >elements,String expectedText){
        for (String element:elements){
            softAssert.assertEquals(element,expectedText," The Text not as expectes!");
        }
        softAssert.assertAll("some Text are not as expected");
    }
    @Step("verify element visually")
    public static void visualElement(String expectedImageName)  {
        try {
            screen.find(getData("ImageRepo") + expectedImageName+ ".png");
        } catch (FindFailed findFailed) {
            throw new RuntimeException("faield"+findFailed);

        }

    }
    //Mobile verification
    @Step("Verify element is display")
    public static void verifyMobileElemenetIsDisplay(MobileElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertTrue(elem.isDisplayed(),"Element" +elem.getText()+" not display");

    }
    @Step("Verify text in  mobile element")
    public static void verifyTextMobileElemenet(MobileElement elem,String expectedText){
        wait.until(ExpectedConditions.textToBePresentInElement(elem,expectedText));
        Assert.assertEquals(elem.getText(),expectedText,"The text  is not as expected");

    }
    @Step("Verify 2 text check if its equals")
    public static void verifyText(String actual,String expected){
        Assert.assertEquals(actual,expected);

    }
}

