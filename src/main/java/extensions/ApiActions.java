package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps {

    @Step("Get data from server ")
    public static Response get(String paramsValue){
        response=request.get(paramsValue);
       response.prettyPrint();
        return response;
    }
    @Step("Extrac value from json ")
    public static String extracFromJson(Response response,String path){
        jp=response.jsonPath();
       return jp.get(path).toString();
    }

    @Step("Post data to server")
    public static void post(JSONObject dataToAdd,String path){
        request.body(dataToAdd.toJSONString());
        response = request.post(path);
        System.out.println(response.getBody().asString());
    }
    @Step("Update data to server according to that of teamid: {teamId}")
    public static int put(JSONObject dataToUpdate,String path){
        request.body(dataToUpdate.toJSONString());
        request.body(dataToUpdate.toJSONString());
        response=request.put(path);
        System.out.println(response.getBody().asString());
        return response.getStatusCode();
    }

    @Step("Delete data to server according to that of  teamid: {teamId}")
    public static void delete(String path){
        response=request.delete(path);
        System.out.println(response.getBody().asString());
    }
}
