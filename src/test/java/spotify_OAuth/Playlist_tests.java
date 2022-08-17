package spotify_OAuth;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import  io.restassured.specification.ResponseSpecification;
import pojo.Createapi;
import pojo.Createapi1;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;







public class Playlist_tests {
	
	RequestSpecification requestspecification;
	ResponseSpecification responsespecification;
	String accesstoken="BQAWgg0OSbaTmdHeChWFeKV7YBojktJO2UFhI1PSEPyGkiDn-2IpZjeDBJyQQgKL_SxUMtgJkNoutjgPv3MKR7Un41LBuCiURMM4ArLEViP7pWAbXQQ7O58zeaP84nNje9aXWLufV6E8PHCebaSV6Wodg67ETKi6B5CY0yyrBI2A446k93ZPhCpSIQyWrIgqT4zGtmXjpCQBvnhMsTUBzy0WRyQzHMmaFaODADneIBgHvpG9vlOiT_zzbFMDSLyE0y67cS_wp1ANryzk";
	
	@BeforeClass
	public void beforeclass()
	{
		RequestSpecBuilder requestspecbuilder=new RequestSpecBuilder();
		setBaseUri("https://api.spotify.com").
		//requestspecbuilder.setBaseUri("https://api.spotify.com").
		setBasePath("/V1").
		//addHeader("Authorization","Bearer BQBA9pYwmO4j2X91LuLn-5xXt6iSdIlBu3VQE6h9gGVg2DiRhVSMDW1nXgpHPXzx0zL8bF3xg705vnOkqCHNAcRJxwXLCevoluKvTVtkmiQaCbWrBm91OunShGXSh72QJCgwOgI_BQC8mu8OnrP9QSAgqvBK0CeXsmblTvV2j40vxLZEKBsBck3aNON8FJFuOFfSaBsnt58_SdeKLVmR-5KODQP6BzOlLHkyerbaL44I8vN8qgmyAdddxlRXy8W7l-1hyqkvYaUs65kl").
		addHeader("Authorization","Bearer "+accesstoken).
		setContentType(ContentType.JSON).
		
		log(LogDetail.ALL);
		requestspecification=requestspecbuilder.build();
		
		ResponseSpecBuilder responsespecbuilder=new ResponseSpecBuilder();
		responsespecbuilder.expectContentType(ContentType.JSON).
		//expectStatusCode(201).
		log(LogDetail.ALL);
		responsespecification=responsespecbuilder.build();
		
	}
	
	
	
	
	
	

	private RequestSpecBuilder setBaseUri(String string) {
		// TODO Auto-generated method stub
		return null;
	}







	@Test
	public void createpalylist()
	{
		String payload="{\r\n"
				+ "  \"name\": \"New Playlist\",\r\n"
				+ "  \"description\": \"New playlist description\",\r\n"
				+ "  \"public\": false\r\n"
				+ "}";
		given().spec(requestspecification).
		    body(payload).
		    when().post("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists").
	        then().spec(responsespecification).
            assertThat().
		    statusCode(201).
	        log().all();
	}
		//@Test
		public void createpalylist1()
		{
			Createapi obj=new Createapi();
			obj.setName("New Playlist");
			obj.setDescription("New playlist description");
			obj.setPublic(false);
			
	given(requestspecification)
    .body(obj)
    .when()
    .post("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists")
    .then().spec(responsespecification);
//  .assertThat()
//    .statusCode(201);

	
}
	//@Test
	public void Getpalylist()
	{
		
		given(requestspecification).
		   
		    when().get("/playlists/2THrJLESPZsFQhjs4Y3guQ").
		    then().spec(responsespecification).
		    assertThat().
		    statusCode(200).
		    log().all();
			
	}
	
	
	
	


}
