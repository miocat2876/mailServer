package common.mailServer.util;

import common.mailServer.context.ApplicationContextServe;
import org.springframework.context.ApplicationContext;

public class PropertyUtil {

	public static String getProperty(String propertyName) {
		ApplicationContext applicationContext = ApplicationContextServe.getApplicationContext();
		if (applicationContext.getEnvironment().getProperty(propertyName) != null) {
			return applicationContext.getEnvironment().getProperty(propertyName);
		}
		return "";
	}
}