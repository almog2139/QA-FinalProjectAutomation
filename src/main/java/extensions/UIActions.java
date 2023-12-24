package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;
import java.util.Set;

public class UIActions extends CommonOps {



    @Step("Click on element ")
    public static void click(WebElement elem){
        System.out.println("elem"+elem);
        //befor click actions wait 5 second to element be clickable
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("Update text element")
    public static void updateField(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step("Get input value")
    public static String getInputAttributeValue(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        return elem.getAttribute("value");
    }
    //Actions
    @Step("Update dropdown elememt (select)  by his visible text")
    public static void updateDropDownByVisibleText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown=new Select(elem);
        dropDown.selectByVisibleText(text);

    }
    @Step("Update dropdown elememt (select)  his value")
    public static void updateDropDownByValue(WebElement elem,String value){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown=new Select(elem);
        dropDown.selectByValue(value);

    }
    @Step("Update dropdown elememt (select) deselect by visible text")
    public static void updateDropDownDeselectByVisibleText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown=new Select(elem);
        dropDown.deselectByVisibleText(text);

    }
    @Step("Insert keyboard keys")
    public static void insertKeys(WebElement element, Keys key){
        element.sendKeys(key);
    }
    @Step("Mouse hover action ")
    public static void mouseHover(WebElement element){
        action.moveToElement(element).build().perform();
    }
    @Step("Mouse hover action and click on element ")
    public static void mouseHoverAndClick(WebElement element){
        action.moveToElement(element).click().build().perform();
    }
    @Step("Scrool until find text")
    public  static void scroolElemetn(WebElement element){
        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        Assert.assertEquals(driver.findElement(By.id("scrolled_element")).getText(), "This Element is Shown When Scrolled");

    }

    @Step("Select multi elements")
    public static void selectMultiElements(List<WebElement> list){
        action.clickAndHold(list.get(1)).clickAndHold(list.get(2)).build().perform();
    }
    @Step("Doule click action")
    public static void doubleClick(WebElement elem){
        action.doubleClick(elem).build().perform();
    }
    @Step("Drag and drop action")
    public static void dragAndDrop(WebElement draggable,WebElement droppable){
        action.dragAndDrop(draggable,droppable).build().perform();
    }
    //Alert
    @Step("Get alert and doing some action be give it in parameter")
    public  static void alertHandling(String action){
        Alert alert=driver.switchTo().alert();
        if(action.equalsIgnoreCase("accept"))
            alert.accept();
        else
            alert.dismiss();

    }
   //Iframe
   @Step("Get focus on iframe")
   public static void getIframeFocus(WebElement iframe) {
       driver.switchTo().frame(iframe);
   }
    @Step("Return focus to default content")
    public  static void getDefultFocus(WebElement iframe) {
        driver.switchTo().defaultContent();
    }



}
