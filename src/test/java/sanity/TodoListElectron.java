package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import java.util.concurrent.TimeUnit;
@Listeners({utilities.Listeners.class})

public class TodoListElectron extends CommonOps {
    @Test(description = "test01 - Add and Verify new Task")
    @Description("this test adds task to the list, and verifies task added")
    public void test01_AddAndVerifyNewTask(){
//        ElectronFlows.addNewTask("Drill for 2 Photos in Living Room");
//        ElectronFlows.addNewTask("Buy Milk");
//        ElectronFlows.addNewTask("Clean Bathroom");
    int currentNumberOfTasks = ElectronFlows.getNumberOfTasks();
    ElectronFlows.addNewTask("Throw Garbage");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), currentNumberOfTasks+1);
    }

    @Test(description = "test01 - Add and Verify new Tasks")
    @Description("this test add tasks to the list, and verifies tasks added")
    public void test02_AddAndVerifyNewTasks(){
        int currentNumberOfTasks = ElectronFlows.getNumberOfTasks();
        ElectronFlows.addNewTask("Drill for 2 Photos in Living Room");
        ElectronFlows.addNewTask("Buy Milk");
        ElectronFlows.addNewTask("Clean Bathroom");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), currentNumberOfTasks+3);
    }
}
