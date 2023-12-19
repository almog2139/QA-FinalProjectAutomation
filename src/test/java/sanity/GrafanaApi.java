package sanity;

import extensions.ApiActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlow;

//@Listeners(utilities.Listeners.class)
public class GrafanaApi extends CommonOps {

    @Test(description = "Test01 - Search property in teams object using jsonPath")
    @Description(" Search property in teams object using jsonPath")
    public void test01_verifyTeamProperty(){
        String teamProperty=ApiFlow.getTeamProperty("teams[1].name");
        Verifications.verifyText(teamProperty,"update");

    }

    @Test(description = "Test02 - Search team by team id")
    @Description("Checking if the search process by teamId has been successfully")
    public void test02_verifySuccessfullySearchTeamById(){
          String actualStatusCode=Integer.toString(ApiFlow.getTeamById(7));
        Verifications.verifyText(actualStatusCode,"200");
    }
    @Test(description = "Test03 - Add a new team ")
    @Description("Adding a new team to grafana server and verify it")
    public void test03_createNewTeam(){
        final String teamName="a new team2";
        final String email="newteam8@gmail.com";
         ApiFlow.createTeam(teamName,email);
         Verifications.verifyText(ApiFlow.getTeamProperty("teams[0].name"),teamName);
    }
    @Test(description = "Test04 - Update existing team ")
    @Description("Update a existing team data to server and verify if action successes")
    public void test04_updateTeam(){
        final String teamName="update";
        final String email="almog55@gmail.com";

                 ApiFlow.updateTeam(teamName,email,7);
         Verifications.verifyText(ApiFlow.getTeamProperty("teams[1].name"),teamName);
//         Verifications.verifyText(Integer.toString(actualStatusCode),"200");
    }

    @Test(description = "Test05 - Delete team ")
    @Description("Delete a existing team data from server and verify if action successes by check count of teams")
    public void test05_deleteTeam(){
        ApiFlow.deleteTeam(8);
        Verifications.verifyText(ApiFlow.getTeamProperty("totalCount"),"2");
    }


}
