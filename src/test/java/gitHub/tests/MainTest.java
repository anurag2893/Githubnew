package gitHub.tests;

import org.testng.annotations.Test;

import GitHub.GitHubRepository.ExecuteCommands;
import GitHub.GitHubRepository.GeneralActions;
import GitHub.GitHubRepository.HomePageObject;
import GitHub.GitHubRepository.LoginPageObject;
import GitHub.GitHubRepository.NewRepoPageObject;
import GitHub.GitHubRepository.RepoNamePageObject;
import GitHub.GitHubRepository.ShellScript;
import GitHub.GitHubRepository.Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class MainTest {
	public WebDriver driver;

	HomePageObject homepage;
	LoginPageObject loginpage;
	NewRepoPageObject newrepository;
	RepoNamePageObject reponame;
	
	@BeforeClass
	public void browserAndUrl() throws IOException {
		
		GeneralActions actions = new GeneralActions();
		driver = actions.getDriver(Utility.getConfigValue("browser"));
		actions.setDriver(driver);
		actions.getURL(Utility.getConfigValue("url"));

	}

	@Test
	public void homeSignIn() throws IOException {
	
		System.out.println(driver);
		homepage=new HomePageObject(driver);
		loginpage=homepage.clickHomeSignInbtn();
	}
	
	@Test(dependsOnMethods={"homeSignIn"})
	public void loginPage() throws InterruptedException, IOException{
		Assert.assertEquals(loginpage.getPageTitle(),"Sign in to GitHub · GitHub");
		newrepository=loginpage.enterCredentials();
	}
	
	@Test(dependsOnMethods={"loginPage"})
	public void newRepo()
	{
		Assert.assertEquals(newrepository.getPageTitle(), "GitHub");
		reponame=newrepository.newRepoClick();
	}
	
	@Test(dependsOnMethods={"newRepo"})
	public void repoName() throws IOException, InterruptedException{
	Assert.assertEquals(reponame.getPageTitle(), "Create a New Repository");
	reponame.enterNameAndClickCreate();
	}
	
	@Test(dependsOnMethods={"repoName"})
	public void shellCommands() throws IOException, InterruptedException
	{
		ShellScript script=new ShellScript(this.driver);
		script.createShellFile();
		script.execute();
		
	}
	
	@Test(dependsOnMethods={"shellCommands"})
	public void executeCommands()
	{
		ExecuteCommands exec=new ExecuteCommands();
		exec.execute();
		System.out.println("done");
	}
}
