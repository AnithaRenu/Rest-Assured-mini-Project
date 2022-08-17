package Reusable;

import static Reusable.SpecBuilder.getRequestSpec;

import static Reusable.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Resource_Reuse.Resource_for_RestResource;
import Resource_Reuse.Routes;

import static Resource_Reuse.Routes.*;

import static Resource_Reuse.Token_manager.*;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.Createapi;
import spotify_OAuth.Playlist_tests;
import utilities.ConfigLoader;


public class RestResource {
	//static String accsse_token="BQAlEqWVdLB0M0dcrKdBt65qCEtyiluIndCLMszDYKmm84XN5KS-PtUxOc1muqRV1hZzsadMvaAqDxAOEwLQfhVfZQiNxfOXF5XYCtIFxCGybrgWbUg2kU7rjvQyII3uJopvfAe1lTFhJsKbheenDhHW83XkTcJH6VgcHI1LNqX4bJEtD_kJzHGONKXcwIZLsUu5gEZzCDfe59tk_Jn6FLhMDfpVye9LpngU9ArlVXnfAYhikAMSAk9sV_-U3QqvWhFB38XMnKXPXda6";
    
	 public static Response post(Createapi obj)
	 {
		 //return Resource_for_RestResource.post("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists", accsse_token, obj);
		 return Resource_for_RestResource.post(Routes.Users + "/" + ConfigLoader.getInstance().getUserid() + Routes.Playlist,getToken(), obj);
		         
	 }
	 public static Response get(String playlistid)
	 {
		 return Resource_for_RestResource.get("/playlists/2THrJLESPZsFQhjs4Y3guQ",getToken());
		 
		
		         
	 }
	
//	 public static Response post(Createapi obj)
//	 {
//		return given(getRequestSpec()).
//		          body(obj).
//		          header("Authorization","Bearer "+ accsses_token).
//		          when().
//		          post("/users/31deyrdgnqvikmnn6qfjdcy6ajgq/playlists").
//		          then().spec(getResponseSpec()).
//		         
//		          extract().
//		          response();
//		         
//	 }
//	 public static Response get(String playlistid)
//	 {
//		 
//		 return given(getRequestSpec()).
//				 header("Authorization","Bearer "+ accsses_token).
//		          
//		          when().
//		          get("/playlists/"+playlistid).
//		          then().spec(getResponseSpec()).
//		        
//		          extract().
//		          response();
//		         
//	 }

}
