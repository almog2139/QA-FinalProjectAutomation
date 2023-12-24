package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElectronFlows extends CommonOps {

    @Step("Add a new task")
    public static void addTask(String taskName,String colorNumber){
        UIActions.click(mainPageTodo.openColorSelectBtn);
        UIActions.updateField(mainPageTodo.createInput, taskName);
       UIActions.click(mainPageTodo.dynamicElement(colorNumber));
       UIActions.click(mainPageTodo.arrowIcon);
        UIActions.insertKeys(mainPageTodo.createInput, Keys.ENTER);


    }
    @Step("Clear task list")
    public static void clearTaskList(){
       if(mainPageTodo.tasks.size()>0){
           for (WebElement task:mainPageTodo.tasks) {
               UIActions.mouseHoverAndClick(mainPageTodo.deleteBtn);
           }

       }
    }

    @Step("Sort tasks by color ")
    public static List<String> sort(String color){
        List<String>colors=new ArrayList<>();
        UIActions.click(mainPageTodo.visiblityToggleBtn);
        UIActions.click(mainPageTodo.dynamicColorToSelect(color));
        if(mainPageTodo.colors.size()>0){
            for (WebElement currColor:mainPageTodo.colors) {
                String actualRgbColor=currColor.getAttribute("style").split("rgb")[1].split(";")[0];
                colors.add(actualRgbColor);
            }
        }
        return  colors;

    }
    @Step("Complete task by name")
    public static void completeTaskByName(String taskName){
        System.out.println("taskName "+taskName);
        if(mainPageTodo.tasks.size()>0){
            for (WebElement task:mainPageTodo.tasks) {
                if(task.getText().substring(11).replaceAll("(?m)^\\s+", "").equalsIgnoreCase(taskName)){
                    UIActions.click(mainPageTodo.completeSvgBtn);
                }
            }

        }
    }
}
