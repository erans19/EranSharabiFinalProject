package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task to the List")
    public static void addNewTask(String taskName){
        UIActions.updateText(todoMain.createTaskField, taskName);
        UIActions.sendKeys(todoMain.createTaskField, Keys.RETURN);
    }

    @Step("Count Number of Tasks in List, and Returns")
    public static int getNumberOfTasks(){
       return todoMain.list_tasks.size();
    }

    @Step("Empty List of Tasks")
    public static void emptyList(){
        for (int i=0; i<getNumberOfTasks(); i++){
            UIActions.mouseHover(todoMain.clear_task_xButton);
        }
    }

}
