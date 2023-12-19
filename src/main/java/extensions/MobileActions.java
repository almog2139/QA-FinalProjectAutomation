package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.time.Duration;
import java.util.List;

public class MobileActions extends CommonOps {



    @Step("Click on element ")
    public static void click(MobileElement element){
        //befor click actions wait 5 second to element be clickable
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    @Step("Update text element")
    public static void updateField(MobileElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
    @Step("Tap on element")
    public static void tap(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        touchAction.tap(new TapOptions()
                .withElement(ElementOption.element(element))).perform();


    }
    @Step(" perform multiple taps on a mobile element")
    public static void multiTap(MobileElement elem, int count) {
        touchAction.tap(new TapOptions().withElement(ElementOption.element(elem)).withTapsCount(count))
                .perform();
    }
   @Step("Press and hold on a mobile element for a specified duration")
    public static void press(MobileElement element, int seconds) {
        touchAction.press(new ElementOption().withElement(element)).waitAction(
                WaitOptions.waitOptions(Duration.ofSeconds(seconds))
        ).perform();
    }
    @Step("Long press action")
    public static void longPress(MobileElement element,int duration){
        touchAction.longPress(new LongPressOptions()
                        .withElement(ElementOption.element(element))
                        .withDuration(Duration.ofSeconds(duration)))
                .perform();
    }
    @Step("Drag and drop action")
    public static void dragAndDrop(MobileElement start,MobileElement finish){
        touchAction.press(new ElementOption().withElement(start)).moveTo(new ElementOption().withElement(finish)).release().perform();
    }
    @Step("Perform drag and drop with specified coordinates on a mobile element")
    public  static void dragAndDropWithCoordinate(MobileElement start, int xOffset, int yOffset) {
        touchAction.press(new ElementOption()
                        .withElement(start))
                .moveTo(new PointOption<>().withCoordinates(xOffset, yOffset)).perform();
    }
    @Step("Zoom action")
    public static void zoom(MobileElement element) {
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getX() + element.getSize().getWidth() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                        .withElement(element).withCoordinates(x, y - 10))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y - 100));

        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(element).withCoordinates(x, y + 10))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y + 100));
        MultiTouchAction multiTouchAction = new MultiTouchAction(mobileDriver);
        multiTouchAction.add(finger1).add(finger2).perform();
    }
    @Step("Pinch action")
    // Method to perform pinch gesture on a mobile element
    public static void pinch(MobileElement element) {
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getX() + element.getSize().getWidth() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                        .withElement(element).withCoordinates(x, y - 100))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y - 10));

        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(element).withCoordinates(x, y + 100))
                .moveTo(new ElementOption().withElement(element).withCoordinates(x, y + 10));
        MultiTouchAction multiTouchAction = new MultiTouchAction(mobileDriver);
        multiTouchAction.add(finger1).add(finger2).perform();
    }

    @Step("Swip action")
    public static void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        Point pointStart, pointEnd;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = mobileDriver.manage().window().getSize();

        // init start point = center of screen
        pointStart = new Point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointEnd = new Point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointEnd = new Point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointEnd = new Point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointEnd = new Point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir.toString() + "' NOT supported");
        }

        // execute swipe using TouchAction
        pointOptionStart = PointOption.point(pointStart.x, pointStart.y);
        pointOptionEnd = PointOption.point(pointEnd.x, pointEnd.y);
        System.out.println("swipeScreen(): pointStart: {" + pointStart.x + "," + pointStart.y + "}");
        System.out.println("swipeScreen(): pointEnd: {" + pointEnd.x + "," + pointEnd.y + "}");
        System.out.println("swipeScreen(): screenSize: {" + dims.width + "," + dims.height + "}");
        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }





}
