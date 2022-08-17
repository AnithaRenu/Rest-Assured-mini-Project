package Reusable;

import org.testng.annotations.BeforeClass;

import Resource_Reuse.Routes;
import io.qameta.allure.restassured.AllureRestAssured;
//import static Resource_Reuse.Routes.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
	
   // static String token="BQAXj6JwTWV-2TVkEs9i7BPJ59_8vVoOnmHvwN7c8qi4cDcaxwMiUjTcZBfx0IA-NPupjx-TPZax7gfJXEW8On9xyN1iNIY7Gaz5OJ9wIOWNHr0tXZ-PM9ZWrwnPJgKmeaoNjNlaStbc2K6HelZDczCkwEY0isEJQf2YoKKNayD39n_ofP80Uyv4sFBN1nGKJVNQep0TVsQYpMU1ktT_aXlZrwdED2oJIdLBO5ZEvg9VWfkj-TQE6J1CZUup8_1uyVCjFUr4YAMFiqQL";
    
        public static RequestSpecification getRequestSpec()
         {
                    return new RequestSpecBuilder().
                    setBaseUri("https://api.spotify.com").
                    setBasePath(Routes.Base_uri).
                   // addHeader("Authorization","Bearer "+token).
                    setContentType(ContentType.JSON).
                    addFilter(new AllureRestAssured()).
                    log(LogDetail.ALL).
                  build();
  
         }
        
        public static RequestSpecification getAccountRequestSpec()
        {
                   return new RequestSpecBuilder().
                   setBaseUri("https://accounts.spotify.com").
                  
                  // addHeader("Authorization","Bearer "+token).
                   setContentType(ContentType.URLENC).
                   addFilter(new AllureRestAssured()).
                   log(LogDetail.ALL).
                   build();
 
        }
        
    public static ResponseSpecification getResponseSpec()
       {
    	 return new ResponseSpecBuilder().
        expectContentType(ContentType.JSON).
        log(LogDetail.ALL).
         build();
    }
    
    
}
