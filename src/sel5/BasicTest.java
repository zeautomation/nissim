package sel5;

import java.net.MalformedURLException;

import org.junit.Before;

import autoCourse2.automation.WebDriverWrapper;

public class BasicTest {
	
	
	WebDriverWrapper driverWrapper;
	
	@Before
	public void before() throws MalformedURLException {
		
		driverWrapper = new WebDriverWrapper();
		driverWrapper.init("http://localhost:4444/wd/hub");
		
		genericPageObjects.setWebDriver(driverWrapper);
	}

}
