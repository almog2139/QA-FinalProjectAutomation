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
        String actual=DesktopFlow.calculatAction("522","7","plus");
        Verifications.verifyText(actual,"529");

    }

}
