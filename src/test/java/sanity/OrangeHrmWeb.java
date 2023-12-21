package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlowsOrangeHRM;

import java.util.concurrent.TimeUnit;

//@Listeners(utilities.Listeners.class)
public class OrangeHrmWeb extends CommonOps {

    @BeforeClass
    public void setup(){
//        WebFlowsOrangeHRM.login(getData("UserName"),getData("Password"));
        WebFlowsOrangeHRM.loginWithDbCredentials();

    }

//    @Test(description = "Test01 - Login")
//    @Description("Login test login and verify the main header")
//    public void test01_verifyLogin(){
//        Verifications.verifyTextElemenet(mainPageOrangeHRM.mainPageHeader, "Dashboard");
//
//    }
    @Test(description = "Test01 - Login with db credentials")
    @Description("Login test login and verify the main header")
    public void test01_verifyLogin(){
        Verifications.verifyTextElemenet(mainPageOrangeHRM.mainPageHeader, "Dashboard");

    }

    @Test(description = "Test02 - Verify dashboard element")
    @Description("Verify in dashboard page is all dashboard elements is display")
    public void test02_verifyDashboardElements(){
        Verifications.verifyVisibiltyOfElements(mainPageOrangeHRM.dashboardItems);
    }


    @Test(description = "Test03 - Adding new employee")
    @Description("Adding new employee and verify employee has be added")
    public void test03_addEmployee(){
        WebFlowsOrangeHRM.addEmployee("Almog","","Sara");
        WebFlowsOrangeHRM.verifySuccessAddingEmployee("Almog Sara");
    }


    @Test(description = "Test04 - Search employee  by employeeId",dataProvider = "data-provider-employeesId",dataProviderClass = utilities.ManageDDT.class)
    @Description("Search emplyee  in employees list by his employeeId get data from csv file")
    public void test04_searchEmployeeById(String employeeId,String expectedListSize){
        WebFlowsOrangeHRM.searchEmployeeById(employeeId,Integer.parseInt(expectedListSize));
    }

    @Test(description = "Test05 - Delete Employee")
    @Description("Delete employee by his employee id ")
    public void test05_deleteEmployeeById(){

        WebFlowsOrangeHRM.deleteEmployeeById("0290");

    }
    @Test(description = "Test06 - Verify logo image")
    @Description("Verify OrangeHRM logo image by using sikuli")
    public void test06_VerifyLogoImage() {

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Verifications.visualElement("OrangeHrmLogo");
    }


}
