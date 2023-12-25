package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlow;

//@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01-Dynamic function and verify the results")
    @Description("Dynamic function for invoicing operations")
    public void invoicingOperations(){
        String actual=DesktopFlow.calculatAction("2+5*10-5+9");
        Verifications.verifyText(actual,"56");
    }
    @Test
    public void test02(){
        String actual=DesktopFlow.calculatAction("(50/10)*8+1+(5*3)");
        Verifications.verifyText(actual,"56");
    }


}
