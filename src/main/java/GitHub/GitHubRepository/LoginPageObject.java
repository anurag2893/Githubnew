package GitHub.GitHubRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class LoginPageObject {
	WebDriver driver;
	public LoginPageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#login_field")
	public WebElement username;
	
	@FindBy(css="#password")
	public WebElement password;
	
	@FindBy(css=".btn.btn-primary.btn-block")
	public WebElement loginbutton;
	
	public String getPageTitle(){
		String title=this.driver.getTitle();
		return title;
	}
	public NewRepoPageObject enterCredentials() throws InterruptedException, IOException
	{
		String user=Utility.getConfigValue("username");
		String pass=Utility.getConfigValue("password");
		System.out.println(user);
		username.sendKeys(user);
		password.sendKeys(pass);;
		loginbutton.click();
		//return new BeforeSearchObject(this.driver);
		return new NewRepoPageObject(this.driver);
	}

}
