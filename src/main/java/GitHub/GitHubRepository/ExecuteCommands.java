package GitHub.GitHubRepository;

//import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
//import org.apache.commons.exec.ExecuteException;


public class ExecuteCommands {
	
	int iExitValue;
	
	/*public void runScript(String command) {
		CommandLine oCmdLine = CommandLine.parse(command);
		DefaultExecutor oDefaultExecutor = new DefaultExecutor();
		oDefaultExecutor.setExitValue(0);
		try {
			iExitValue = oDefaultExecutor.execute(oCmdLine);
			System.out.println(iExitValue);
		} catch (ExecuteException e) {
			System.err.println("Execution failed.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(iExitValue);
			System.err.println("permission denied.");
			e.printStackTrace();
		}
	}*/

	public void execute() {
		DefaultExecutor oDefaultExecutor = new DefaultExecutor();
		CommandLine oCmdLine = new CommandLine("./executor.sh");
		try {
			oDefaultExecutor.execute(oCmdLine);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
