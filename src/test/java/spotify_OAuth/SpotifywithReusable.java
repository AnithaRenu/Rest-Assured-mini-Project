package spotify_OAuth;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static Reusable.SpecBuilder.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Createapi;

public class SpotifywithReusable {
	
	@Test
    public void CreatPlaylist()
      {
   	 Createapi obj=new Createapi().
		
		    setName("New Playlist").
			setDescription("New playlist description").
			setPublic(false);
			
	

      	 Createapi obj2=given(getRequestSpec()).
          body(obj).
          when().
          post("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists").
          then().spec(getResponseSpec()).
          assertThat().
          statusCode(201).
          extract().
          response().
          as(Createapi.class);
         

      }
  

	 @Test
    public void getplaylist()
    {
		 Createapi obj=new Createapi().
					
				    setName("New Playlist").
					setDescription("New playlist description").
					setPublic(false);
					
			

		      	 Createapi obj2=given(getRequestSpec()).
		          body(obj).
		          when().
		          get("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists").
		          then().spec(getResponseSpec()).
		          assertThat().
		          statusCode(201).
		          extract().
		          response().
		          as(Createapi.class);
    }
}
