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
        //DesktopFlow.clearResults();

    }
//    @Test
//    public void test01_a(){
//        String actual=DesktopFlow.calculatAction("2+5");
//        Verifications.verifyText(actual,"7");
//    }


}
