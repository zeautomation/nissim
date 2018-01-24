package sel5;

import autoCourse2.automation.WebDriverWrapper;

public class genericPageObjects {
	public static WebDriverWrapper driverWrapper;
	
	public static void setWebDriver(WebDriverWrapper _driverWrapper)
	{
		driverWrapper = _driverWrapper;
	}

}
