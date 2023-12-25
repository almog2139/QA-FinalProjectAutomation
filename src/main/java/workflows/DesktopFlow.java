package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.stringtemplate.v4.ST;
import utilities.CommonOps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        operationsElementMap.put("nine", mainPageCalculator.getNineBtn());
        operationsElementMap.put("plus", mainPageCalculator.plusBtn);
        operationsElementMap.put("minus", mainPageCalculator.minusBtn);
        operationsElementMap.put("divide", mainPageCalculator.divideBtn);
        operationsElementMap.put("percent", mainPageCalculator.percentBtn);
        operationsElementMap.put("mult", mainPageCalculator.multBtn);
        operationsElementMap.put("equals", mainPageCalculator.equalsBtn);
        operationsElementMap.put("right parenthesis", mainPageCalculator.rightParenthesis);
        operationsElementMap.put("left parenthesis", mainPageCalculator.leftParenthesis);

    }

    @Step("Calculat Invoicing operations")
    public static String calculatAction(String equation) {
        initialOperationMap();
        UIActions.click(mainPageCalculator.menu);
        UIActions.click(mainPageCalculator.scientificBtn);
        for (int i=0;i<equation.length();i++){
            String charToEnter=convertOperatorToString(equation.charAt(i));
            UIActions.click(operationsElementMap.get(charToEnter.toLowerCase()));
        }
        UIActions.click(mainPageCalculator.equalsBtn);
        String results=mainPageCalculator.calcResults.getText().split(" ")[2];
        return results;

   }

    @Step("Convert operator to a word ")
    public static String convertOperatorToString(char digit){

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
            case '+':
                digitString= "plus";
                break;
            case '-':
                digitString= "minus";
                break;
            case '/':
                digitString= "divide";
                break;
            case '%':
                digitString= "percent";
                break;
            case '*':
                digitString= "mult";
                break;
            case '=':
                digitString= "equals";
                break;
            case '(':
                digitString= "left parenthesis";
                break;
            case ')':
                digitString= "right parenthesis";
                break;
            default:
                System.out.println("Invalid number !");
                break;
        }
        return digitString;
    }


    @Step("Clear calculator data")
    public static void clearResults() {
        UIActions.click(mainPageCalculator.clearBtn);
    }
}
