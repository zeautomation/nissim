package sel5;

import org.openqa.selenium.WebElement;

import autoCourse2.automation.WebDriverWrapper;

public class PageObjects {
	public static class startPage extends genericPageObjects { 
		public static WebDriverWrapper driverWrapper;
		
		public static class vroomHomePage extends genericPageObjects {
			
			public static void openHomePage() {
				
				driverWrapper.openUrl("https://www.vroom.com/");
			}
			
			public static void searh (String text) {
				
				WebElement searh = driverWrapper.getElementByType("herro-searh-input","id");
				
				if (searh != null) {
					searh.sendKeys(text);
				}
				else {
					System.out.println("Element Not Found");
				}
			}
		}
	}

}
