package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TempAPI {
    RequestSpecification httpRequest;
    Response response;
    String url = "https://reqres.in";

    @Test
    public void testingAPI(){
    RestAssured.baseURI = url;
    httpRequest = RestAssured.given();

    //Get Request
//    response = httpRequest.get("/employees");
    response = httpRequest.get("/api/users");

//    //Post + Put Request
//        JSONObject params = new JSONObject();
//        params.put("name", "shachar molner");
//        params.put("job", "999");
//        httpRequest.header("Content-Type", "application/json");
//                httpRequest.body(params.toJSONString());
//                response = httpRequest.post("/api/users");

//                response = httpRequest.put("/api/users/533");

//        response = httpRequest.delete("/api/users/533");

        response.prettyPrint();
    }
}
