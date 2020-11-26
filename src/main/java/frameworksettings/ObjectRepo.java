package frameworksettings;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import frameworkinterfaces.IconfigReader;

public class ObjectRepo {
	
	public static WebDriver driver;
	public static IconfigReader reader;
	public static Map<String, Object> data = new LinkedHashMap<String, Object>();
	
}

