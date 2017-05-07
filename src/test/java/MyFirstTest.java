import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;


/**
 * Created by Olena on 5/7/2017.
 */
public class MyFirstTest {

    @Test
    public void startWebDriver() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath(".//*[@id=\'content\']/ul/li[18]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath(".//*[@id='login']/button")).click();
        Thread.sleep(5000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("F:\\screenshot\\screenshot.png"));
        Assert.assertTrue("Secure Area",true);

        driver.close();
        driver.quit();

    }



}
