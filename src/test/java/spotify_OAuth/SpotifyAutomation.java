package spotify_OAuth;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import  io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;


public class SpotifyAutomation {
	

	
		
	RequestSpecification reqspec;
    ResponseSpecification resspec;
    String access_token="BQAWgg0OSbaTmdHeChWFeKV7YBojktJO2UFhI1PSEPyGkiDn-2IpZjeDBJyQQgKL_SxUMtgJkNoutjgPv3MKR7Un41LBuCiURMM4ArLEViP7pWAbXQQ7O58zeaP84nNje9aXWLufV6E8PHCebaSV6Wodg67ETKi6B5CY0yyrBI2A446k93ZPhCpSIQyWrIgqT4zGtmXjpCQBvnhMsTUBzy0WRyQzHMmaFaODADneIBgHvpG9vlOiT_zzbFMDSLyE0y67cS_wp1ANryzk";
    @BeforeClass
        public void beforeClass(){
            RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                    setBaseUri("https://api.spotify.com").
                    setBasePath("/v1").
                    addHeader("Authorization","Bearer "+access_token).
                    setContentType(ContentType.JSON).
                    log(LogDetail.ALL);
            reqspec = requestSpecBuilder.build();

            ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                    expectContentType(ContentType.JSON).
                    log(LogDetail.ALL);
            resspec= responseSpecBuilder.build();
        }
     @Test
     public void CreatPlaylist()
       {
           String payload="{\r\n"
                   + "    \"name\":\"New Playlist\",\r\n"
                   + "    \"description\":\"New Playlist description\",\r\n"
                   + "    \"public\":false\r\n"
                   + "\r\n"
                   + "}";

     given(reqspec)
           .body(payload)
           .when()
           .post("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists")
           .then().spec(resspec)
           .assertThat()
           .statusCode(201);

       }
     @Test
     public void Getpalylist()
 	{
 		
 		given(reqspec).
 		   
 		    when().get("/playlists/2THrJLESPZsFQhjs4Y3guQ").
 		    then().spec(resspec).
 		    assertThat().
 		    statusCode(200).
 		    log().all();
 			
 	}
     
}