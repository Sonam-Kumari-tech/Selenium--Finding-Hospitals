package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToElement {
	//scrolling down
	WebDriver driver;
	JavascriptExecutor js;
			
	//constructor
	public ScrollToElement(WebDriver driver){
		this.driver=driver;
	}		   
	public void scroll(WebElement element)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments [0].scrollIntoView();",element);
	}

}
