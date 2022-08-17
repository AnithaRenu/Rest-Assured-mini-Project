package utilities;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class PropertUtility {
	
	public static Properties propertyLoader(String filepath)
	{
		Properties properties=new Properties();
		BufferedReader reader;
		try
		{
			reader= new BufferedReader(new FileReader(filepath));
		
		try {
			properties.load(reader);
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Failed to load Proerties files" + filepath);
			
		}
	}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Failed to load Proerties files" + filepath);
			
		}
		return properties;
		
	}

}
