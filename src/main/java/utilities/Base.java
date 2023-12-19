package utilities;

import com.google.gson.JsonObject;
import io.appium.java_client.TouchAction;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObjects.orangeHRM.*;


import org.sikuli.script.Screen;
import io.appium.java_client.AppiumDriver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {


    //General
    protected  static WebDriverWait wait;
    protected static SoftAssert softAssert;
    protected static Actions action;
     protected static Screen screen;
     protected static String platform;

    //Web
    protected static WebDriver driver;
     //Mobile
    protected  static  AppiumDriver mobileDriver;
    protected static TouchAction touchAction;
     protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Page object variable declaration - web
    protected static LoginPage loginOrangeHRM;
    protected static pageObjects.orangeHRM.MainPage mainPageOrangeHRM;
    protected static PimPageAddEmployee pimPageAddEmployee;
    protected static PimHeader pimHeader;
    protected static MenuSideBar sideBar;
    protected static PimPagePersonalDetails pimPagePersonalDetails;

    protected static PimPageEmployeeInformation pimPageEmployeeInformation;

    //Page object variable declaration - mobile
    protected static pageObjects.unitConverter.MainPage mainPageUnitConverter;
    protected static pageObjects.unitConverter.Basic basicUnitConverter;
    protected static pageObjects.unitConverter.Living livingUnitConverter;
    protected static pageObjects.unitConverter.Misc miscUnitConverter;

    //Rest Api
    protected  static Response response;
    protected  static RequestSpecification  request;
    protected static JsonPath jp;

    //Electron
    protected  static  pageObjects.todo.MainPage mainPageTodo;


    //Desktop
    protected  static pageObjects.calculator.MainPage mainPageCalculator;

    //DataBase
    protected  static Connection con;
    protected  static ResultSet rs;
    protected  static Statement stmt;

}
