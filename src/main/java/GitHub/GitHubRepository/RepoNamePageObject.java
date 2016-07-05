package GitHub.GitHubRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoNamePageObject {

	WebDriver driver;
	public RepoNamePageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#repository_name")
	WebElement reponame;
	
	@FindBy(css=".btn.btn-primary.first-in-line")
	WebElement clickcreate;
	
	public String getPageTitle(){
		
		String title=this.driver.getTitle();
		return title;
	}
	
	public void enterNameAndClickCreate() throws IOException, InterruptedException{
		String repositoryname=Utility.getConfigValue("repository");
		reponame.sendKeys(repositoryname);
		Thread.sleep(2000);
		clickcreate.click();
	}
}
