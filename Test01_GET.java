
import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import io.restassured.response.Response;
public  class Test01_GET {
    @Test
    void test_01() {
        //Response res=RestAssured.get("https://reqres.in/api/users?page=1");
        // the above is without using static and without importing all modules in rest assured.

        Response res=get("https://reqres.in/api/users?page=1");
        int code=res.getStatusCode();
        System.out.println(res.getBody().prettyPrint());
        
        System.out.println("Status code is "+code+"\n"+"Response is "+res.asString());
        System.out.println("Response time is "+res.getTime());
        System.out.println("Status line is "+res.getStatusLine());
        Assert.assertEquals(code,200);
    }
    
    @Test
    void test_03()
    {
        RestAssured.given().
            get("https://reqres.in/api/users?page=2").
        then().
            statusCode(200)
            .body("data.id[1]",equalTo(8))
            
            .log().all();
    }
    @Test
    void test_suki()
    {
        String baseURL= "https://web-api-v2.suki-test.com/auth/me";
        String email="suraj+athena@suki.ai"; // email will get url encoded that is + (plus sign) in a URL is encoded as %2B and @ (at symbol) in a URL is encoded as %40
        String organisationId="2600a011-86f1-4af6-95e4-9140eede70d7";
        String userId="e6a4d5d5-99e2-496b-a213-6a3194b6e5f8";
        String bearerToken="eyJraWQiOiJpVkpPMTNwQk00QVpwM1VxdnZya2lJclNUQ2tYRThQU2djT0tZaWVQOEV3IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULlpVc0dQMWJ4b19HeVQ2blk0OFNnaU9xMURCMW1HYnNibWhRMFpYd0NVQXMiLCJpc3MiOiJodHRwczovL3N1a2ktYXBpLm9rdGEuY29tL29hdXRoMi9kZWZhdWx0IiwiYXVkIjoiYXBpOi8vZGVmYXVsdCIsImlhdCI6MTczMzc5OTkxMSwiZXhwIjoxNzMzODQzMTExLCJjaWQiOiIwb2FucjNvMG9DbDFQdDEwTjI5NiIsInVpZCI6IjAwdWxrN3VuMjF5OFZ0UnFPMjk3Iiwic2NwIjpbInByb2ZpbGUiLCJlbWFpbCIsIm9wZW5pZCJdLCJhdXRoX3RpbWUiOjE3MzM3OTk5MDksIm9yZ2FuaXphdGlvbklkIjoiMjYwMGEwMTEtODZmMS00YWY2LTk1ZTQtOTE0MGVlZGU3MGQ3Iiwic3ViIjoiYXV0b21hdGlvbi13ZWJAc3VraS5haSIsInJvbGVzIjpbIlVTRVIiLCJTQ1JJQkUiLCJBRE1JTiJdLCJ1c2VySWQiOiJlNmE0ZDVkNS05OWUyLTQ5NmItYTIxMy02YTMxOTRiNmU1ZjgifQ.DHhfdhHPbRdZ2oIhjpGfejrj90BsS_fv755IlpWTxYPxR9g0A39DZtzxbSXfSFQGHGyLQ1LCLrleTiWzunZvyi81zqqhrOm7wOrHfZgnho868PTeRZCETPfLDGzte5ExPMh22nRIqbuqYmfT3yAWd4jJFGfkdzKihBsalXYitDenf0_NtqiQV5jpfr8A0SZZ_kQf8hOvfheOEZ9i-EEpypTapQ1b45pRbjFmPKxj49Eoehg_o3PQ5_ie-YRa2WdclbHqCyfUZ83cqqVFRNiNjauI0mTiP6hRnst1MmUftoWnDR-chHD3Al7iB3dwxI9vYcfmx112gczhiqQx5jojPw";

        Response res=RestAssured.given()
            .header("Authorization", "Bearer " + bearerToken)
            .queryParam("email",email)
            .queryParam("onLogin", "false")
            .queryParam("organisationId", organisationId)
            .queryParam("userId", userId)
            .get(baseURL)
            ;
        System.out.println("Response Status Code: " + res.getStatusCode());
        System.out.println(res.prettyPrint());
        
    }
}
