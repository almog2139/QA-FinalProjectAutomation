package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(name="Zero")
    private WebElement zeroBtn;
    @FindBy(name="One")
    private WebElement oneBtn;

    @FindBy(name="Two")
    private WebElement twoBtn;
    @FindBy(name="Three")
    private WebElement threeBtn;
    @FindBy(name="Four")
    private WebElement fourBtn;

    @FindBy(name="Five")
    private WebElement fiveBtn;
    @FindBy(name="Six")
    private WebElement sixBtn;

    @FindBy(name="Seven")
    private WebElement sevenBtn;

    @FindBy(name="Eight")
    private WebElement eightBtn;
    @FindBy(name="Nine")
    private WebElement nineBtn;
    @FindBy(name="Minus")
    public WebElement minusBtn;
    @FindBy(name="Plus")
    public WebElement plusBtn;

    @FindBy(xpath = "//*[@AutomationId='multiplyButton']")
    public WebElement multBtn;

    @FindBy(xpath = "//*[@AutomationId='divideButton']")
    public WebElement divideBtn;
    @FindBy(name="Precent")
    public WebElement percentBtn;
    @FindBy(name="Equals")
    public WebElement equalsBtn;

    @FindBy(name="Backspace")
    public WebElement removeBtn;


    @FindBy(name = "Clear")
    public WebElement clearBtn;
    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement calcResults;

    public WebElement getZeroBtn(){
        return zeroBtn;
    }
    public WebElement getOneBtn(){
        return oneBtn;
    }
    public WebElement getTwoBtn(){
        return twoBtn;
    }
    public WebElement getThreeBtn(){
        return threeBtn;
    }
    public WebElement getFourBtn(){
        return fourBtn;
    }
    public WebElement getFiveBtn(){
        return fiveBtn;
    }
    public WebElement getSixBtn(){
        return sixBtn;
    }
    public WebElement getSevenBtn(){
        return sevenBtn;
    }
    public WebElement getEightBtn(){
        return eightBtn;
    }
    public WebElement getNineBtn(){
        return nineBtn;
    }

}
