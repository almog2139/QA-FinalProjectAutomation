package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.orangeHRM.PimPageAddEmployee;
import pageObjects.orangeHRM.PimPageEmployeeInformation;

public class ManagePages extends Base {

     /*
      Method Name:initOrangeHRM
      Method Description: A method that initializes all the different page objects OrangeHrm (web)
       */

    public static void initOrangeHRM() {
        loginOrangeHRM = PageFactory.initElements(driver, pageObjects.orangeHRM.LoginPage.class);
        mainPageOrangeHRM = PageFactory.initElements(driver, pageObjects.orangeHRM.MainPage.class);
        pimPageAddEmployee = PageFactory.initElements(driver, PimPageAddEmployee.class);
        pimHeader = PageFactory.initElements(driver, pageObjects.orangeHRM.PimHeader.class);
        pimPagePersonalDetails = PageFactory.initElements(driver, pageObjects.orangeHRM.PimPagePersonalDetails.class);
        pimPageEmployeeInformation = PageFactory.initElements(driver, PimPageEmployeeInformation.class);
        sideBar = PageFactory.initElements(driver, pageObjects.orangeHRM.MenuSideBar.class);
    }

     /*
      Method Name:initUnitConverter
      Method Description: A method that initializes all the different page objects for UnitConverter(mobile)
       */

    public static void initUnitConverter() {
        mainPageUnitConverter = new pageObjects.unitConverter.MainPage(mobileDriver);
        basicUnitConverter = new pageObjects.unitConverter.Basic(mobileDriver);
        livingUnitConverter = new pageObjects.unitConverter.Living(mobileDriver);
        miscUnitConverter = new pageObjects.unitConverter.Misc(mobileDriver);
    }

    /*
     Method Name:initTodo
     Method Description: A method that initializes all the different page objects for Todos app(electron)
      */
    public static void initTodo() {
        //create object from mainpage and send the driver
        mainPageTodo = new pageObjects.todo.MainPage(driver);
    }

    /*
     Method Name:initDesktop
     Method Description: A method that initializes all the different page objects for Calculator(desktop)
      */
    public static void initDesktop() {
        mainPageCalculator = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
