package utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;



public class CommonUtility extends BaseClass{

    static TakesScreenshot ss;
    static JavascriptExecutor js;

    public CommonUtility() throws IOException {

    }

    public static void screenshot(String fileName) throws IOException {
    	String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

    	File screenshotFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenshotFile, new File("C:\\Users\\conne\\IdeaProjects\\Practice\\src\\test\\ScreenShots"+fileName+timeStamp+".png"));

    }

    public static String readPropertiesFile(String property) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Duke\\eclipseworkspace\\CucumberBDD\\src\\ConfigurationTest\\env.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String myProperty = prop.getProperty(property);
        return myProperty;

    }

    public static void scrollHeight() {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    public static void scrollByNumber(int horizontalScroll, int verticalScroll){
        js.executeScript("window.scrollBy("+horizontalScroll+","+verticalScroll+")");

    }

    public static void scrollIntoView(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();",element);

    }

    public static void elementToBeClickable(WebDriver driver, int waitTime, WebElement element){
        WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void customBrowserSize(int width, int height){
        //JavascriptExecutor js = (JavascriptExecutor) driver;          //This method is not supported for all Browser
        //js.executeScript("window.resizeTo("+width+","+height+")");


        Dimension customWindowSize = new Dimension(width, height);
        BaseClass.getDriver().manage().window().setSize(customWindowSize);


	}

}
