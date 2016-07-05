package GitHub.GitHubRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeneralActions {
	
	public WebDriver driver;
	
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}
	
	public void getURL(String url){
		this.driver.get(url);
	}
	
	public WebDriver getDriver(String browserName){
		if(browserName.equals("firefox")){
			return new FirefoxDriver();
		}
		else if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/home/anuraggarg/Downloads/chromedriver");
			return new ChromeDriver();
		}
		return null;
		
	}

}
