package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.DbActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static extensions.DbActions.getCredentials;

public class WebFlowsOrangeHRM extends CommonOps {

    public static   String employeeid;

    @Step("Generate randome string by getting string length")
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
    @Step("Login username: {username} ,password: {password}")
    public static void login(String username, String password){
        UIActions.updateField(loginOrangeHRM.username,username);
        UIActions.updateField(loginOrangeHRM.password,password);
        UIActions.click(loginOrangeHRM.login_btn);

    } @Step("Login with credentials from database")
    public static void loginWithDbCredentials(){
        String sqlQuery="SELECT `user_name`, `password` FROM `employess` WHERE comments='correct'";
        List<String>credentials =getCredentials(sqlQuery);
        UIActions.updateField(loginOrangeHRM.username,credentials.get(0));
        UIActions.updateField(loginOrangeHRM.password,credentials.get(1));
        UIActions.click(loginOrangeHRM.login_btn);

    }
    @Step("Adding employee firstName: {firstName} ,middleName: {middleName} lastName: {lastName}")
    public static void addEmployee(String firstName,String middleName, String lastName){
        UIActions.click(sideBar.sideMenuPinBtn);
        UIActions.click(pimHeader.addEmployeebtn);
        UIActions.updateField(pimPageAddEmployee.firstNameField, firstName);
        UIActions.updateField(pimPageAddEmployee.middleNameField, middleName);
        UIActions.updateField(pimPageAddEmployee.lastNameField, lastName);
       // employeeid=UIActions.getInputAttributeValue(pimPageAddEmployee.employeeId);
        UIActions.click(pimPageAddEmployee.createLoginPageCheckBox);
        UIActions.updateField(pimPageAddEmployee.username,generateRandomString(5));
       UIActions.updateField(pimPageAddEmployee.passwords.get(0),"almog1234");
       UIActions.updateField(pimPageAddEmployee.passwords.get(1),"almog1234");
        UIActions.click(pimPageAddEmployee.saveBtn);


    }
    @Step("Verify the success of adding an employee")
    public static void verifySuccessAddingEmployee(String expectedEmployeName){

        Verifications.verifyTextElemenet(pimPagePersonalDetails.employeeName, expectedEmployeName);

    }

    @Step("Search employeeget data from csv file search employee with employeeId {employeeId} and expected to find {expectedListSize} results ")
    public static void searchEmployeeById(String employeeId,int expectedListSize){
        UIActions.click(sideBar.sideMenuPinBtn);
//        UIActions.click(pimHeader.employeeListbtn);
        UIActions.updateField(pimPageEmployeeInformation.employeeId,employeeId);
        UIActions.click(pimPageEmployeeInformation.searchBtn);
       Verifications.verifyNumberOfElements(pimPageEmployeeInformation.employees,expectedListSize);
    }
    @Step("Delete employee by employeeId and verify  the success of deleting be search his employee id and check the list items is empty")
    public static void deleteEmployeeById(String employeeId){
        UIActions.click(sideBar.sideMenuPinBtn);
        searchEmployeeById(employeeId,1);
        UIActions.click(pimPageEmployeeInformation.deleteBtn);
        UIActions.click(pimPageEmployeeInformation.btnConfirmDeleteEmployee);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Verifications.verifyNumberOfElements(pimPageEmployeeInformation.employees,0);
    }
//    @Step("back to main page")
//    public static void backToLoginPage(){
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//    }


}
