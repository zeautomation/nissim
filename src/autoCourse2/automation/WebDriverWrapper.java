
package autoCourse2.automation;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;



import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.j2objc.annotations.ReflectionSupport.Level;

public class WebDriverWrapper {

	RemoteWebDriver remoteWebDriver;
	
	

	public void init(String remoteUrl) throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		remoteWebDriver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

		remoteWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public LogEntries getConsoleLogs() {
		return remoteWebDriver.manage().logs().get(LogType.BROWSER);

	}
	
	public void printConsoleLogs() {
		List<LogEntry> consoleLogEtries=getConsoleLogs().getAll();
		for(int i=0;i<consoleLogEtries.size();i++) {
			
			LogEntry entry=consoleLogEtries.get(i);
			
			
			
			System.out.println(entry.getMessage() + " : " + entry);
			
			//consoleLogEtries.get(i)
		}
		
	}

	public void DesiredCapabilities() throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		remoteWebDriver = new RemoteWebDriver(capabilities);
		
	
//		LoggingPreferences loggingPreferences = new LoggingPreferences();
//		loggingPreferences.enable(logType, Log);
//		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
		this.remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

	}

	public void openUrl(String url) {
		remoteWebDriver.get(url);
	}

	public WebElement getElementByType(String value, String type) {
		return getElementByType(value, type, "visible");
	}

	public WebElement getElementByType(String value, String type, String condition) {

		WebElement element = null;

		By by = null;

		if (type.equals("xpath")) {
			by = By.xpath(value);
		} else if (type.equals("id")) {
			by = By.id(value);
		}

		try {
			WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 20, 1000);

			if (condition.equals("clickable")) {
				element = driverWait.until(ExpectedConditions.elementToBeClickable(by));
			} else if (condition.equals("visible")) {
				element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}

		} catch (TimeoutException e) {
			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (element == null) {
			Assert.fail();
		}

		return element;

	}

	public WebElement get_Element(By by) {
		WebElement element = remoteWebDriver.findElement(by);

		if (element != null) {
			return element;
		} else
			return null;

	}

	public void quit() {
		remoteWebDriver.quit();
	}

	public void init2() {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		remoteWebDriver = new RemoteWebDriver(capabilities);
	}

	public int getElemenetsByXpath(String xpath) {
		WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 20, 1000);

		List<WebElement> elementsList = driverWait
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), 1));

		if (elementsList != null) {
			return elementsList.size();
		} else
			return 0;
	}

}


/*package sel5;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper {

	RemoteWebDriver remoteWebDriver;

	public void init(String remoteUrl) throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		remoteWebDriver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

		remoteWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void init() {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		remoteWebDriver = new RemoteWebDriver(capabilities);
	}

	public void openUrl(String url) {
		remoteWebDriver.get(url);
	}

	public WebElement getElementByType(String value, String type) {
		return getElementByType(value, type, "visible");
	}

	public WebElement getElementByType(String value, String type, String condition) {

		WebElement element = null;

		By by = null;

		if (type.equals("xpath")) {
			by = By.xpath(value);
		} else if (type.equals("id")) {
			by = By.id(value);
		}

		try {
			WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 20, 1000);

			if (condition.equals("clickable")) {
				element = driverWait.until(ExpectedConditions.elementToBeClickable(by));
			} else if (condition.equals("visible")) {
				element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}

		} catch (TimeoutException e) {
			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (element == null) {
			Assert.fail();
		}

		return element;

	}

	public WebElement get_Element(By by) {
		WebElement element = remoteWebDriver.findElement(by);

		if (element != null) {
			return element;
		} else
			return null;

	}

	public void quit() {
		remoteWebDriver.quit();
	}

	public void init2() {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		remoteWebDriver = new RemoteWebDriver(capabilities);
	}

	public int getElemenetsByXpath(String xpath) {
		WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 20, 1000);

		List<WebElement> elementsList = driverWait
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), 1));

		if (elementsList != null) {
			return elementsList.size();
		} else
			return 0;
	}
	
	public List<WebElement> findListOfElements (String xpath){
		WebDriverWait driwerWait = new WebDriverWait (remoteWebDriver, 20, 1000);
		List<WebElement> elementList = null;
		
		try {
			elementList = driwerWait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return elementList;	
		}
	}
*/