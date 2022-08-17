package utilities;

import java.util.Properties;

public class ConfigLoader {
	private final Properties properties;
	private static ConfigLoader configloader;
	
	private ConfigLoader()
	{
		properties=PropertUtility.propertyLoader("src/test/resources/config.properties");
	}
	
   public static ConfigLoader getInstance()
   {
	   if(configloader == null) 
	   {
		   configloader=new ConfigLoader();
	   }
	   return configloader;
	   
   }
   public String getClientId()
   {
	   String prop=properties.getProperty("client_id");
	   if(prop != null) 
		   return prop;
	   else 
		   throw new RuntimeException("Property ClientId is not specified in the Config.Propertis file");
   }
   public String getClientSecretId()
   {
	   String prop=properties.getProperty("client_secret");
	   if(prop != null) 
		   return prop;
	   else 
		   throw new RuntimeException("Property Clientsecret is not specified in the Config.Propertis file");
    }
   public String getRefreshtoken()
   {
	   String prop=properties.getProperty("refresh_token");
	   if(prop != null) 
		   return prop;
	   else 
		   throw new RuntimeException("Property refresh token is not specified in the Config.Propertis file");
    }
   public String getGranttype()
   {
	   String prop=properties.getProperty("grant_type");
	   if(prop != null) 
		   return prop;
	   else 
		   throw new RuntimeException("Property granttype is not specified in the Config.Propertis file");
    }
   public String getUserid()
   {
	   String prop=properties.getProperty("user_id");
	   if(prop != null) 
		   return prop;
	   else 
		   throw new RuntimeException("Property userid is not specified in the Config.Propertis file");
    }
   }
