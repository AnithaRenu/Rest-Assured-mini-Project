package Resource_Reuse;

import static Reusable.SpecBuilder.getRequestSpec;
import static Reusable.SpecBuilder.*;
import static Reusable.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import Reusable.SpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Createapi;

public class Resource_for_RestResource {
	
	
	 public static Response post(String path,String token,Object obj)
	 {
		return given(getRequestSpec()).
		          body(obj).
		          auth().oauth2(token).
		         // header("Authorization","Bearer "+token).
		          when().
		          post(path).
		          then().spec(getResponseSpec()).
		         
		          extract().
		          response();
		         
	 }
	 public static Response Postaccount(HashMap<String,String> formparams)
	 {
		 return given(getAccountRequestSpec()).
				  
				   formParams(formparams).
				   when().post(Routes.API + Routes.Token).
				   then().spec(getResponseSpec()).
				   extract().
				   response();
	 }
	 public static Response get(String path,String token)
	 {
		 
		 return given(getRequestSpec()).
				 auth().oauth2(token).
				 //header("Authorization","Bearer "+ token).
		          
		          when().
		          get(path).
		          then().spec(getResponseSpec()).
		        
		          extract().
		          response();
		         
	 }


}
