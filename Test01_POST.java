
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

// DOING PUT POST PATCH DELETE WITH PUBLIC AVAILABLE API
public class Test01_POST{
    Map<String, Object> map=new HashMap<String,Object>();
    @Test
    void test01_post()
    {
        // POST A RESOURCE
        map.put("name","Kobe");
        
        System.out.println(map);
        //convert map to json object
        JSONObject request= new JSONObject(map);
        

        // Another way is to not use a map
        
        request.put("job", "nba");
        request.put("Title", "mamba");
        System.out.println(request);
        
        
        given().body(request.toJSONString())
        .when()
            .post("https://reqres.in/api/users")
            .then().statusCode(201).log().all()
                        ;
    }
    @Test
    void test01_put()
    {
        //PUT IN HTTP
        map.put("name","Zaid");
        
        System.out.println(map);
        //convert map to json object
        JSONObject request= new JSONObject(map);
        

        // Another way is to not use a map
        request.put("job", "bell");
        request.put("Title", "Police");
        System.out.println(request);
        
        
        given()
        .header("Content-type","application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .body(request.toJSONString())
        .when()
            .put("https://reqres.in/api/users/2")
            .then().statusCode(200).log().all()
                        ;
    }
    @Test
    void test01_patch()
    {
        // POST
        map.put("name","Zaid");
        
        System.out.println(map);
        //convert map to json object
        JSONObject request= new JSONObject(map);
        

        // Another way is to not use a map
        request.put("job", "bell");
        request.put("Title", "Niece");
        System.out.println(request);
        
        
        given()
        .header("Content-type","application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .body(request.toJSONString())
        .when()
            .patch("https://reqres.in/api/users/2")
            .then().statusCode(200).log().all()
                        ;
    }
    @Test
    void test01_delete()
    {
        // DELETE DATA 
        
        when()
            .delete("https://reqres.in/api/users/2")
            .then().statusCode(204).log().all()
                        ;
    }


}
