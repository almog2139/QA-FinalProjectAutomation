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

### OrangeHrm: Web Testing with Selenium WebDriver - [OrangeHrm Web Tests Video]()

#### Web - Login to OrangeHrm with credentials pulled from an external Database
Verify login was successful

![alt text]( "OrangeHrm Login")

#### Web - Verify Presentation of elements in dashboard page

![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaCheckUser.gif "Grafana Users")

#### Web - Adding new employee and verify employee has be added
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaAddUser.gif "Grafana Add NEW User")

```java
 WebFlowsOrangeHRM.addEmployee("Almog","","Sara");
```
```java
WebFlowsOrangeHRM.verifySuccessAddingEmployee("Almog Sara");
```
#### Web - Search employee  by employeeId Data Driven Testing using a data provider for multiple users & expected results
![alt text]()

#### Web - Delete employee by his employee id
![alt text]( "OrangeHrm Delete employee")
```java
WebFlowsOrangeHRM.deleteEmployeeById("0257");
```

#### Web - Verify  logo image is located on screen by Visual lookup
Verify this image:  ![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaAvatar.png "Grafana Visual Search") is located on screen by looking at pixels' colors


