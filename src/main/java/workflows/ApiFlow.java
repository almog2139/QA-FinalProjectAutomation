package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import utilities.CommonOps;


public class ApiFlow extends CommonOps {

    @Step("Get all teams list and search this json property by {jsPath}")
    public static String getTeamProperty(String jsPath){
       response= ApiActions.get("api/teams/search");
       return ApiActions.extracFromJson(response,jsPath);
    }
    @Step("Get team by id : {teamId}")
    public static int getTeamById(int teamId){
        response=ApiActions.get("/api/teams/"+teamId);
        return response.getStatusCode();
    }
    @Step("Create new team to grafana")
    public static void createTeam(String teamName,String email){
        JSONObject teamObject = new JSONObject();
        teamObject.put("name", teamName);
        teamObject.put("email", email);
        ApiActions.post(teamObject,"api/teams");

    }
    @Step("Update existing team data")
    public static int updateTeam(String teamName,String email,int teamId){
        JSONObject teamObject = new JSONObject();
        teamObject.put("name", teamName);
        teamObject.put("email", email);
        int statusCode=ApiActions.put(teamObject,"api/teams/"+teamId);
        return  statusCode;
    }
    @Step("Delete team")
    public static void deleteTeam(int teamId){
        ApiActions.delete("/api/teams/"+teamId);
    }
}
