package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Page {

    String url="https://search.pathmotion.io/206/search?indexes[]=discussions&facetsDistribution[discussions]&q=Team&limit=25";
    Response response;



    public void gettingSearchListSize(){

         response= given()
                .contentType(ContentType.JSON)
                .log().all().
                        when()
                .get(url)
                 .prettyPeek()
         ;

        List searchList= response.jsonPath().getList("discussions.hits");
        System.out.println("Result : "+ searchList.size());


    }
    public void verifyCategory(){
        response = given()
                .contentType(ContentType.JSON).
                log().all().
                        when()
                .get(url);

        String expectedCategory="internal career mobility";
        String actualCategory=response.jsonPath().getString("discussions.hits[0].category");

        Assert.assertEquals(actualCategory,expectedCategory,"Category does not match");

    }
    public void verifyId(){
        response=given()
                .contentType(ContentType.JSON)
                .log().all()
                        .when()
                .get(url);

        String expectedId="91008";
        String actualId=response.jsonPath().get("discussions.hits[0].id");

        Assert.assertEquals(actualId,expectedId,"Id does not match");
    }

}
