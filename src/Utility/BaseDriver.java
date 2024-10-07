package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.tools.Tool;
import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void BaslangicIslemleri()
    {
       driver=new ChromeDriver();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       wait=new WebDriverWait(driver,Duration.ofSeconds(20));
       Login();
    }
    @AfterClass
    public void kapanisIslemleri()
    {
      Tools.Bekle(3);
      driver.quit();


    }
    public void Login()
    {
        driver.get("https://openmrs.org/");
        Tools.Bekle(2);

    }
}
