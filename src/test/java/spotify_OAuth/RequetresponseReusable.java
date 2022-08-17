package spotify_OAuth;

import static Reusable.SpecBuilder.getRequestSpec;


import static Reusable.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import Reusable.RestResource;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import io.restassured.response.Response;
import pojo.Createapi;

@Epic("Spotify Outh 2.0")
@Feature("PlayList Api")

public class RequetresponseReusable {
	
	
	
	

	public Createapi playlistBuilder(String name,String discription,Boolean _Public)
	{
       return Createapi.builder().
				
			    name(name).
				description(discription).
				_public(_Public).
				build();
		
		
//		Createapi createapi=new Createapi(); //(this is for implemrntation without builder)
//		createapi.setName(name);
//		createapi.setDescription(discription);
//		createapi.set_public(_Public);
//		return createapi;
		
//		return new Createapi().
//				
//			    setName(name).
//				setDescription(discription).
//				setPublic(_Public);
	}
	@Story("Create a plalist story")
	@Link("https://example.org")
	@Link(name = "allure", type = "mylink")
	@TmsLink("12345")
	@Issue("1234")
	
	@Description("This is the added discription")
	
	  @Test(description="Create playList Test")
	   public void CreatPlaylist()
	      {
	   	 Createapi obj=playlistBuilder("New Playlist","New playlist description",false);
			Response response=RestResource.post(obj);
		    assertThat(response.statusCode(),is(equalTo(201)));
		    Createapi obj1=response.as(Createapi.class);

	     assertThat(obj.getName(), equalTo(obj1.getName()));
	     assertThat(obj.getDescription(), equalTo(obj1.getDescription()));
	     assertThat(obj.get_public(), equalTo(obj1.get_public()));
	         

	      }
	  
	@Story("Create a plalist story")
		 @Test
	    public void getplaylist()
	    {
			 
	    	Createapi obj=playlistBuilder("New Playlist","New playlist description",false);
						
			 Response response=RestResource.get("2THrJLESPZsFQhjs4Y3guQ");
				assertThat(response.statusCode(),is(equalTo(200)));
				Createapi obj1=response.as(Createapi.class);
				
				 
			
				

			      	
	    }
	}


//	@Test
//   public void CreatPlaylist()
//      {
//   	 Createapi obj=new Createapi().
//		
//		    setName("New Playlist").
//			setDescription("New playlist description").
//			setPublic(false);
//			Response response=RestResource.post(obj);
//	    assertThat(response.statusCode(),is(equalTo(201)));
//	    Createapi obj1=response.as(Createapi.class);
//
//     assertThat(obj.getName(), equalTo(obj1.getName()));
//     assertThat(obj.getDescription(), equalTo(obj1.getDescription()));
//     assertThat(obj.getPublic(), equalTo(obj1.getPublic()));
//         
//
//      }
//  
//
//	 @Test
//    public void getplaylist()
//    {
//		 Createapi obj=new Createapi().
//					
//				    setName("New Playlist").
//					setDescription("New playlist description").
//					setPublic(false);
//					
//		 Response response=RestResource.get("2THrJLESPZsFQhjs4Y3guQ");
//			assertThat(response.statusCode(),is(equalTo(200)));
//			Createapi obj1=response.as(Createapi.class);
//		
//			
//
//		      	
//    }
//}
