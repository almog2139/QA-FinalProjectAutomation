# QA Automation Testing

This project utilizes a 'smart' automation infrastructure for multi-platform quality assurance automated testing to demonstrate my knowledge & capabilities in QA Automation.

## About

This project is built to serve as an automation infrastructure with a TestNG framework and a Page-Object-Model for testing applications on multiple platforms.
The infrastructure provides an easy, simple and quick way to add new tests, and is easily expandable & maintained.

Jenkins is used to schedule executions of the Test Suites profiles for each platform (more profiles can be easily added to create different test scenarios) linked into a pipeline.

Allure Report system is used as the main reporting system.

---
## Overview

This project performs automated testing of various applications:
* Web based application
* Web API
* Mobile application
* Electron application
* Desktop application
### Infrastructure includes:

* Layers (utilities, extensions, workflows...)
* Page object model design pattern
* External files Support
* Failure mechanisms
* Electron driver
* Reporting system (including video recordings & screenshots)
* Support for different client browsers
* API support
* Visual testing
* Database support
* CI & CD support
### Applications tested:

* [OrangeHrm](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login) - Web based application tested with WebDriver
* Grafana API - Web API tested with REST Assuard
* [Unit Converter](https://play.google.com/store/apps/details?id=kr.sira.unit&hl=en_GB&gl=US) - Mobile application tested with Appium
* [TodoList](https://github.com/blaadje/Todolist) Desktop application tested with ElectronDriver
* Windows Calculator - Desktop application tested with WinAppDriver
### Tools & Frameworks:

* [TestNG](https://testng.org/) Framework
* Listenrs interface for Logs & Customizable TestNG Reports
* [Monte Screen Recorder](https://github.com/sbtqa/monte-media/blob/master/src/main/ru/sbtqa/monte/screenrecorder/ScreenRecorder.java) for Video Recordings
* [Selenium](https://www.selenium.dev/) Java & API
* [REST Assured](https://rest-assured.io/) for API Testing
* [SikuliX API](http://sikulix.com/) for Visual Testing
* [Appium Studio](https://digital.ai/continuous-testing/eclipse-intellij-plugins) & Java-Appium for Mobile Testing
* [MySQL Database](https://www.freemysqlhosting.net/) free sql hosting to store Login Credentials
* [OpenCSV](http://opencsv.sourceforge.net/) for CSV file parsing
* [Jenkins](https://www.jenkins.io/) for Automating Test executions & Test Pipelines
* [Allure Reports](http://allure.qatools.ru/) - Reporting System 


---
## Tests Overview

### OrangeHrm: Web Testing with Selenium WebDriver - [OrangeHrm Web Tests Video](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository//FullProjectWeb%20(1).gif)

#### Web - Login to OrangeHrm with credentials pulled from an external Database
Verify login was successful

![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/loginWeb.gif "OrangeHrm Login")

#### Web - Verify Presentation of elements in dashboard page

```java
   @Test(description = "Test02 - Verify dashboard element")
    @Description("Verify in dashboard page is all dashboard elements is display")
    public void test02_verifyDashboardElements(){
        Verifications.verifyVisibiltyOfElements(mainPageOrangeHRM.dashboardItems);
    }
    @Step("Verify visibilty of elements with using soft-asserion")
    public static void verifyVisibiltyOfElements(List<WebElement>elements){
        for (WebElement element:elements){
            softAssert.assertTrue(element.isDisplayed(),element.getText()+"  not exsits!");
        }
        softAssert.assertAll("some elements are not displayed");
    }
```
#### Web - Adding new employee and verify employee has be added
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/addingEmployee.gif "OrangeHrm Add new employee")

```java
 WebFlowsOrangeHRM.addEmployee("Almog","","Sara");
```
```java
WebFlowsOrangeHRM.verifySuccessAddingEmployee("Almog Sara");
```
#### Web - Search employee by employeeId using Data Driven Testing - data provider for multiple users & expected results and verify the expected results
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/searchEmployees.gif "OrangeHrm DDT")
```java
 WebFlowsOrangeHRM.searchEmployeeById(employeeId,Integer.parseInt(expectedListSize));
```
```java
0221,1
0267,1
0821,0
```

#### Web - Delete employee by his employee id and verify by using searchEmploeeyById method
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/deleteEmployee.gif "OrangeHrm Delete employee")
```java
WebFlowsOrangeHRM.deleteEmployeeById("0070");
```

#### Web - Verify  logo image is located on screen by Visual lookup
Verify this image:  ![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/OrangeHrmLogo.png "OrangeHrm Visual Search") is located on screen by looking at pixels' colors

#### API - Verify HTTP response property (GET), Create new Team (POST), Update Team data (PUT), Delete Team by team ID (DELETE)
```java
ApiFlow.getTeamProperty("teams[1].name");
ApiFlow.createTeam(teamName,email);
ApiFlow.updateTeam(teamName,email,7);
ApiFlow.deleteTeam(8);
```
### Unit Converter: Mobile Testing with Appium Studio & Appium Driver
#### Test01 - Convert length
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/test01.gif "Convert Length")
#### Test02 - Convert currency
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/test02.gif "Convert Currency")
```java
 MobileFlowsUnitConverter.convertCurrency("60","USD");
Verifications.verifyTextMobileElemenet(livingUnitConverter.eurCurrencyValue,"54.24");
@Step("Convert currency")
public  static void convertCurrency(String value,String currency){
        MobileActions.click(mainPageUnitConverter.livingBtn);
        MobileActions.click(livingUnitConverter.CurrencyBtn);
        MobileActions.click(livingUnitConverter.valueInput);
        if(value.length()>1){
        for (int i = 0; i < value.length(); i++) {
        char digit = value.charAt(i);
        String digitString = String.valueOf(digit);
        MobileActions.click(livingUnitConverter.dynamicCalcElement(digitString));

        }
        }
        MobileActions.click(livingUnitConverter.okBtn);
        MobileActions.click(livingUnitConverter.dropDown);
        MobileActions.click(livingUnitConverter.dynamicCurrency(currency));

        }
```
#### Test03 - Change misc favorites with swipe (appium method)
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/test03.gif "Change Misc Favorites")
* verify results/changes after any test


---

### Todolist: Testing with Electron Driver
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/electron.gif "Electron Todo App")
* Add new todo item with a color tag and verify number of elements 
* Add new todos and mark task as completed
* Clear the list after any test case
* Add new items ,sort task by color

---

### Windows Calculator: Testing with WinAppDriver

#### Simple Calculation - Based on pre-built methods
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/calc.gif "Calculator Desktop App")
* Using a dynamic function allows multiple operations to be implemented in the code using only 1 line of code & 1 String as an input,verify expected results
```java
String actual=DesktopFlow.calculatAction("2+5*10-5+9");
Verifications.verifyText(actual,"56");


```
---

### Jenkins & Allure Reports

#### Jenkins Basic & Blue Ocean Dashboards

![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/jenkins.gif "Jenkins")
#### Running several jobs at the same time that depend on build after other job are built 
### Allure Reports
![alt text](https://raw.githubusercontent.com/almog2139/QA-FinalProjectAutomation/master/ImageRepository/allure.gif "Allure Report")
The reports show the 'steps' in each test, with info such as: description, duration, history, parameters & values, verification values, screenshots and more.