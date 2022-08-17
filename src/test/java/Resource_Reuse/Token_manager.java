package Resource_Reuse;

import static Reusable.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

import java.time.Instant;
import java.util.HashMap;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigLoader;

public class Token_manager {
	private static String access_token;
	private static Instant expiry_time;
	
	public static String getToken()
	{
		
		
	  try
	  {
		  if(access_token == null || Instant.now().isAfter(expiry_time))
		  {
			  
			  System.out.println("Renewing Token .......");
	  
		      Response response=renewToken();
		      access_token=response.path("access_token");
		      int expirydurationSec=response.path("expires_in");
		      expiry_time=Instant.now().plusSeconds(expirydurationSec-300);
		  }
	        else
	         {
		       System.out.println("Token is good to use..."); 
		  
		  
	         }
	  }
	  catch(Exception e) {
	  
		  throw new RuntimeException("Abort !!! Failed to get Token");
	  }
	  
  return access_token;
		
	}
	
	
	
	public static Response renewToken()
	{
		HashMap<String,String> formparams=new HashMap<String,String>();
		formparams.put("client_id", ConfigLoader.getInstance().getClientId());
		formparams.put("client_secret", ConfigLoader.getInstance().getClientSecretId());
		formparams.put("refresh_token", ConfigLoader.getInstance().getRefreshtoken());
		formparams.put("grant_type", ConfigLoader.getInstance().getGranttype());
		
		Response response=Resource_for_RestResource.Postaccount(formparams);
		if(response.statusCode() !=200) {
			throw new RuntimeException("ABORT!!! Renew Token failed");
		
		}
		return response;
		   
	}

}
