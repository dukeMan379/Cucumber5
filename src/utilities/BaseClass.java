package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

		
	private static WebDriver driver;
		
	public BaseClass() throws IOException{
	FileInputStream fis = new FileInputStream("C:\\Users\\Duke\\eclipseworkspace\\CucumberBDD\\src\\ConfigurationTest\\env.properties");
	Properties prop = new Properties();
	prop.load(fis);
	
	String myURL = prop.getProperty("url");
	String myBrowser =  prop.getProperty("browser");
	
	
	//WebDriverManager.chromedriver().setup();
	//ChromeOptions options = new ChromeOptions();
	//options.addArguments("--guest");
	//driver = new ChromeDriver(options);

	

         

	        if(myBrowser.equalsIgnoreCase("chrome")){
	            WebDriverManager.chromedriver().setup();
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--guest");
	            driver = new ChromeDriver(options);
	        } else if(myBrowser.equalsIgnoreCase("Edge")){
	            WebDriverManager.edgedriver().setup();
	            EdgeOptions options = new EdgeOptions();
	            options.addArguments("--guest");
	            driver = new EdgeDriver();
	        } else if(myBrowser.equalsIgnoreCase("firefox")){
	            WebDriverManager.firefoxdriver().setup();
	            FirefoxOptions options= new FirefoxOptions();
	            options.addArguments("--guest");
	            driver = new FirefoxDriver(options);
	        } else if(myBrowser.equalsIgnoreCase("safari")){
	            WebDriverManager.safaridriver().setup();
	            driver = new SafariDriver();
	        }

	        //driver.manage().window().maximize();

	    }

	    public static WebDriver getDriver() {
	        return driver;
	    }

	    public static void setDriver() throws IOException {
	        BaseClass obj= new BaseClass();
		

	}
	}
