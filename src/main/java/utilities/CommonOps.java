package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import extensions.UIActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.DesktopFlow;
import workflows.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    /*
    Method Name:startSession
    Method Description:method that start before class test case start,get platform name and calls the appropriate initialization function
    Method Parameters:
    Method Return:
     */

    //    @BeforeSuite
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String platformName) throws MalformedURLException, SQLException, ClassNotFoundException {
        platform = platformName;
        if (platform.equalsIgnoreCase("web")) {
            initBrowser(getData("BrowserName"));
            ManageDB.openConnection(getData("dbUrl"), getData("dbUserName"), getData("dbPassword"));
        }
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initRestApi();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
        screen = new Screen();
        // wait=new WebDriverWait(driver,Long.parseLong(getData("Timeout")));

    }

    /*
  Method Name:closeSession
  Method Description:method that start when class test case end ,and calls a function that performs certain actions according to the platform
   */
    @AfterClass
    public void closeSession() {
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile")){
                driver.quit();
                if(platform.equalsIgnoreCase("web"))
                    ManageDB.closeConnection();

            }
            else
                mobileDriver.quit();
        }


    }

    /*
Method Name:afterMethod
Method Description:method that start after any method ,and calls a function that performs certain actions according to the platform
 */
    @AfterMethod
    public void afterMethod() {
        //TODO:IMPROVE THE CODE
        if (platform.equalsIgnoreCase("mobile"))
            mobileDriver.resetApp();
        else if (platform.equalsIgnoreCase("electron")) {
             ElectronFlows.clearTaskList();

        } else if (platform.equalsIgnoreCase("desktop")) {
            DesktopFlow.clearResults();
            Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
            //UIActions.click(mainPageCalculator.clearBtn);
//            mainPageCalculator.clearBtn.click();
//            driver.findElement(By.name("Clear")).click();
        } else if (platform.equalsIgnoreCase("web")) {
            driver.get(getData("MainPageUrl"));

        }


    }


    /*
     Method Name:initBrowser
     Method Description:A method that receives the browser type and by using a switch case calls the appropriate initialization function
     Method Parameters:String
      */
    public void initBrowser(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFireFoxDriver();
                break;

            case "opera":
                driver = initOperaDriver();
                break;
            case "microsoft edge":
                driver = initMicrosoftEdgeDriver();
                break;

            default:
                throw new RuntimeException("Invalid Browser Type");
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));

        //to our website
        driver.get(getData("Url"));
        ManagePages.initOrangeHRM();
    }

    /*
     Method Name:initChromeDriver
     Method Description:A method that initializes the driver for Chrome
     */
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;

    }

    /*
     Method Name:initFireFoxDriver
     Method Description:A method that initializes the driver for FireFox
     */
    public static WebDriver initFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;

    }

    /*
     Method Name:initOperaDriver
     Method Description:A method that initializes the driver for Opera
     */
    public static WebDriver initOperaDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        return driver;

    }

    /*
     Method Name:initMicrosoftEdgeDriver
     Method Description:A method that initializes the driver for Microsoft Edge
     */
    public static WebDriver initMicrosoftEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;

    }   /*
    Method Name:initMobile
    Method Description:A method that initializes all the variables for using  Mobile app
     */

    public static void initMobile() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        // Initialize TouchAction
        touchAction = new TouchAction(mobileDriver);
//        if(mobileDriver.isDeviceLocked()){
//            Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
//            mobileDriver.unlockDevice();
        ManagePages.initUnitConverter();
        MobileActions.tap(mainPageUnitConverter.popupDismissBtn);
    }

    /*
        Method Name:initRestApi
        Method Description:A method that initializes all the variables for using rest api
         */
    public static void initRestApi() {
        RestAssured.baseURI = getData("UrlApi");
        request = RestAssured.given().auth().preemptive().basic(getData("UserNameApi"), getData("PasswordApi"));
        request.header("Content-Type", "application/json");
    }

    /*
        Method Name:initElectron
        Method Description:A method that initializes all the variables for using electron app
    */
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions options = new ChromeOptions();
        options.setBinary(getData("ElectronAppPath"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", options);
        capabilities.setBrowserName("chrome");
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
        ManagePages.initTodo();
    }

    /*
          Method Name:initDesktop
          Method Description:A method that initializes all the variables for using desktop app
      */
    public static void initDesktop() throws MalformedURLException {
        dc = new DesiredCapabilities();
        dc.setCapability("app", getData("CalculatorApp"));
        driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        //call manage pages for desktop
        ManagePages.initDesktop();
    }
  /*
    Method Name:getData
    Method Description:This method get data from xml configuration file
    Method Parameters:String
    Method Return:String
     */

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
}
