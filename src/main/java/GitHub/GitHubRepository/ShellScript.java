package GitHub.GitHubRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShellScript {

	File file;
	public FileWriter fw;
	public PrintWriter write;
	WebDriver driver;
	public String sys_user;
	//public String batfilepath;
	public String sys;
	public Process p;
	public ShellScript(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".form-control.js-git-clone-help-field.url-field.js-zeroclipboard-target")
	WebElement cloneurl;
	
	public void createShellFile() throws IOException{
		file = new File("executor.sh");
		file.createNewFile();
	    file.setExecutable(true);
	    file.setWritable(true);
		fw = new FileWriter(file.getAbsoluteFile());
		write = new PrintWriter(fw);		
		sys_user=System.getProperty("user.name");
	    System.out.println(sys_user);
	   // batfilepath=Utility.getConfigValue("batfile");
	    sys=System.getProperty("os.name");
	    System.out.println(sys);
	}
	public void execute() throws IOException, InterruptedException{
		 if(sys.equalsIgnoreCase("Linux"))
		 {
		String repname=Utility.getConfigValue("repository");
		String url=cloneurl.getAttribute("value");
		String user=Utility.getConfigValue("usernamescript");
		String pass=Utility.getConfigValue("passwordscript");
		System.out.println(file.canWrite());
		System.out.println(file.canExecute());
		System.out.println(url);
		write.println("#!/bin/bash");
		write.println("cd ~");
		write.println("git clone "+url);
		write.println("cd "+repname);
		write.println("gedit >'Hello'");
		write.println("git status");
		write.println("git add .");
		write.println("git commit -m'First Commit'");
		write.println("git status");
		write.println("git push http://"+user+":"+pass+"@github.com/"+user+"/"+repname+".git master");
		write.close();
	}
		 else
		 {
			 	PrintWriter writer;
		    	file = new File("executor.bat");
		    	file.createNewFile();
		        file.setExecutable(true);
		        file.setWritable(true);
		    	fw = new FileWriter(file.getAbsoluteFile());
		    	writer = new PrintWriter(fw);
		    	String repname=Utility.getConfigValue("repository");
				String url=cloneurl.getAttribute("value");
				String user=Utility.getConfigValue("usernamescript");
				String pass=Utility.getConfigValue("passwordscript");
		    	writer.println("C:");
		    	writer.println("cd users");
		        writer.println("cd "+sys_user);
		        writer.println("cd Desktop");
		        writer.println("git clone "+url);
		        writer.println("cd "+repname);
		        writer.println("type nul > hello");
		        writer.println("git add .");
		        writer.println("git status");
		        writer.println("git commit -m 'First Commit'");
		        writer.println("git status");
		        writer.println("git push http://"+user+":"+pass+"@github.com/"+user+"/"+repname+".git");
		        writer.close();	
		        p=new ProcessBuilder("./executor.bat").start();
		        p.waitFor();
		    }
	}
	
	}