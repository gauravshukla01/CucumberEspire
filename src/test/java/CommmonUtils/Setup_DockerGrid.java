package CommmonUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class Setup_DockerGrid {

	@BeforeClass

	public void startGrid() throws Exception
	{
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");

		Thread.sleep(30000);
	}

	@AfterSuite

	public void stopGrid() throws Exception
	{
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");

		Thread.sleep(5000);

//		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	}


}
