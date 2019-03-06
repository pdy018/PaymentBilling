import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class patmentbilingTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL("https://selenium.devops.sparkflow.top/wd/hub"), capabilities);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void simpleTest() {
        driver.navigate().to("http://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
    @Test
    public void LoginTest() throws InterruptedException {
    	
        driver.navigate().to("http://goodv1.us-west-2.elasticbeanstalk.com/PaymentBilling-0.0.1-SNAPSHOT/");
       // wait(10);
        driver.findElement(By.xpath("//body/div/div[@id=\"main\"]/center/a/font")).click();
        driver.findElement(By.xpath("//*[@id=\"box\"]/form/table/tbody/tr[3]/td[2]/input")).sendKeys("sonoo");
        driver.findElement(By.xpath("//*[@id=\"box\"]/form/table/tbody/tr[5]/td[2]/input")).sendKeys("jaiswal");
        driver.findElement(By.xpath("//*[@id=\"box\"]/form/table/tbody/tr[7]/td[2]/input")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"banner\"]/div/h2/a/font")).getText(), "LOG OUT");
		
    }
}
