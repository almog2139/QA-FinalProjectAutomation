package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import java.util.concurrent.TimeUnit;

//@Listeners(utilities.Listeners.class)
public class TodoElectron extends CommonOps {

    @Test(description = "Test01-Adding a new task")
    @Description("Adding a new task to list and verify the count of task list")
    public void test01_addTask(){
        ElectronFlows.addTask("Learn React",getData("RgbBlue"));
        Verifications.verifyNumberOfElements(mainPageTodo.tasks,1);

    }

 @Test(description = "Adding some tasks and complete task by name")
    public void test02_addTasksAndCompleteTask(){
        ElectronFlows.addTask("Learn Java",getData("RgbBlue"));
        ElectronFlows.addTask("Learn C#",getData("RgbRed"));
        ElectronFlows.addTask("Learn Python",getData("RgbYellow"));
        ElectronFlows.completeTaskByName("Learn Java");
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        Verifications.verifyNumberOfElements(mainPageTodo.tasks,3);
    }
    @Test(description = "Test03-Add new tasks with some color ")
    @Description("Adding tasks with color, sorting by color and verifying the success of the sorting")
    public void test03_sortByColor(){
        ElectronFlows.addTask("Learn Python",getData("RgbYellow"));
        ElectronFlows.addTask("Learn React",getData("RgbBlue"));
        ElectronFlows.addTask("Learn React",getData("RgbYellow"));
       Verifications.verifyElementsText(ElectronFlows.sort(getData("RgbYellow")),getData("RgbYellow"));
    }
}
