package GitHub.GitHubRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewRepoPageObject {
	WebDriver driver;
	public NewRepoPageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".btn.btn-sm.btn-primary")
	WebElement newrepobtn;
	
	public String getPageTitle(){
		String title=this.driver.getTitle();
		return title;
	}
	
	public RepoNamePageObject newRepoClick(){
		newrepobtn.click();
		return new RepoNamePageObject(this.driver);
	}

}
