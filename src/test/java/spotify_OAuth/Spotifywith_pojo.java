package spotify_OAuth;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Createapi;

public class Spotifywith_pojo {
	
	RequestSpecification reqspec;
    ResponseSpecification resspec;
    String access_token="BQAXES8ITySUUi0cvN-vr09O-P3_1lyYGCifTUU0IvQaq8Cv4B4srRAMSX6YRa6ugahyoKB9zr1ef_Y-byZ9djSiAeqmp87ubyPIg26D3ju7UC7gxUTSAElOUUitijJzKURR7Ce2UacSC9ua6Iga6KmCFVOpxAXJIru4xkKa_k4Gz-r_M0nmW76DKZG4dqCjHTRgCUxi8KGZ8cNFnytNhHsiA1WmIHwQ088o6vdzgVzjFu0_j0TDQfG2bihw3RQ4QnkfT-Aagwf2plIc";
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
    // @Test
     public void CreatPlaylist1()
       {
    	 Createapi obj=new Createapi();
			obj.setName("New Playlist");
			obj.setDescription("New playlist description");
			obj.setPublic(false);
			
	

     given(reqspec)
           .body(obj)
           .when()
           .post("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists")
           .then().spec(resspec)
           .assertThat()
           .statusCode(201);

       }
     @Test
     public void getplaylist()
     {
    	 given().spec(reqspec)
        
         .when()
         .get("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists")
         .then().spec(resspec)
         .assertThat()
         .statusCode(200);

     }

}
