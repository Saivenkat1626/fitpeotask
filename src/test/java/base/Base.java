package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class Base {
	public static WebDriver driver;
	 @BeforeClass
	 @Parameters({"browser","URL"})
	 public void openBrowser(String br,String url) {
		 if(br.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		 }
		 else if(br.equalsIgnoreCase("firefox")) {
			 driver=new FirefoxDriver();
		 }
		 else if(br.equalsIgnoreCase("edge")) {
			 driver=new EdgeDriver();
		 }
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		 driver.get(url);
		 driver.manage().window().maximize();
	 }
	 @AfterClass
	 public void close() {
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		 driver.close();
	 }
}
