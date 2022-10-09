package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners({utilities.Listeners.class})

public class GrafanaAPI extends CommonOps {

    @Test(description = "Test 01: get Team from Grafana")
    @Description("this test verifies teams from Grafana in JSON")
    public void test01_verifyTeam() {
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "A-Team");
    }

    @Test(description = "Test 02: Add Team And Verify")
    @Description("this test posts new team using API, and verifies it")
    public void test02_addTeamAndVerify() {
        ApiFlows.postTeam("elia", "EliKing3@gmail.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "elia");
    }


    @Test(description = "Test 03: Update Team and Verify")
    @Description("this test updates Team's parameters using API, and verifies it")
    public void test03_updateTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("elia", "EliNotKing3@gmail", id);
        System.out.println(ApiFlows.getTeamProperty("teams[1].email"));
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "EliNotKing3@gmail");
    }

    @Test(description = "Delete team in Grafana")
    @Description("this test deletes team and verifies it")
    public void test04_deleteTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }
}
