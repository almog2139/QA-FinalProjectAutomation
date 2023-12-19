package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.stringtemplate.v4.ST;
import utilities.CommonOps;

import java.util.HashMap;
import java.util.Map;

public class DesktopFlow extends CommonOps {

    private static final Map<String, WebElement> operationsElementMap = new HashMap<>();

    @Step("Creating a map of operations and initialization")
    public static void initialOperationMap() {

        operationsElementMap.put("zero", mainPageCalculator.getZeroBtn());
        operationsElementMap.put("one", mainPageCalculator.getOneBtn());
        operationsElementMap.put("two", mainPageCalculator.getTwoBtn());
        operationsElementMap.put("three", mainPageCalculator.getThreeBtn());
        operationsElementMap.put("four", mainPageCalculator.getFourBtn());
        operationsElementMap.put("five", mainPageCalculator.getFiveBtn());
        operationsElementMap.put("six", mainPageCalculator.getSixBtn());
        operationsElementMap.put("seven", mainPageCalculator.getSevenBtn());
        operationsElementMap.put("eight", mainPageCalculator.getEightBtn());
        operationsElementMap.put("nine", mainPageCalculator.getNineBtnBtn());
        operationsElementMap.put("plus", mainPageCalculator.plusBtn);
        operationsElementMap.put("minus", mainPageCalculator.minusBtn);
        operationsElementMap.put("divide", mainPageCalculator.divideBtn);
        operationsElementMap.put("percent", mainPageCalculator.percentBtn);
        operationsElementMap.put("mult", mainPageCalculator.multBtn);

    }

    @Step("Calculat Invoicing operations")
    public static String calculatAction(String num1, String num2, String operation) {
        initialOperationMap();
        //Enter first number
        if (num1.length() > 1) {
            clickDigits(num1);
        } else {
            String wordNumber=convertDigitToString(num1.charAt(0));
            UIActions.click(operationsElementMap.get(wordNumber.toLowerCase()));
        }
        // Perform the operation
        UIActions.click(operationsElementMap.get(operation));
        //Enter second number
        if (num2.length() > 1) {
           clickDigits(num2);
        } else {
            String wordNumber=convertDigitToString(num2.charAt(0));
            UIActions.click(operationsElementMap.get(wordNumber.toLowerCase()));
        }
        UIActions.click(mainPageCalculator.equalsBtn);
        String results=mainPageCalculator.calcResults.getText().split(" ")[2];
        System.out.println("res"+results);
        return results;

    }
    @Step("Convert digit of number to a word ")
    public static String convertDigitToString(char digit){
        String digitString = null;
        switch (digit) {
            case '0':
                digitString= "zero";
                break;
            case '1':
                digitString= "one";
                break;
            case '2':
                digitString= "two";
                break;
            case '3':
                digitString= "three";
                break;
            case '4':
                digitString= "four";
                break;
            case '5':
                digitString= "five";
                break;
            case '6':
                digitString= "six";
                break;
            case '7':
                digitString= "seven";
                break;
            case '8':
                digitString= "eight";
                break;
            case '9':
                digitString= "nine";
                break;
            default:
                System.out.println("Invalid number !");
                break;
        }
        return digitString;
    }

    @Step("Function that receives a number and checks if it is two digits or higher and divides it into factors")
    private static void clickDigits(String numberString) {

        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);

//            int num = Integer.parseInt(number);
//        while (num > 0) {
//            String lastDigit = Integer.toString(num % 10);
            String digitString=convertDigitToString(digitChar);
            UIActions.click(operationsElementMap.get(digitString.toLowerCase()));
//            num /=10;
        }

    }

    @Step("Clear calculator data")
    public static void clear() {
        UIActions.click(mainPageCalculator.clearBtn);
    }
}
