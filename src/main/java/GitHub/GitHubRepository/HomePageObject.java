package GitHub.GitHubRepository;


//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class HomePageObject {

	WebDriver driver;
	public HomePageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".btn.site-header-actions-btn.mr-2")
	 WebElement homesigninbtn;
	
	public LoginPageObject clickHomeSignInbtn()
	{
		//ystem.out.println(this.driver);
		
		homesigninbtn.click();
		return new LoginPageObject(this.driver);
	}
	
	
}
