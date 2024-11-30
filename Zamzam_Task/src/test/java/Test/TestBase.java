package Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class TestBase
{
    protected static ExtentReports report;
    protected static ExtentTest reportTest;

    protected WebDriver driver;
    //protected SoftAssert soft;


    @BeforeSuite
    public void setUp()
    {
        report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(new File("Reports/report.html"));
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Zamzam Website");
        report.attachReporter(spark);
    }
    @BeforeTest
    public void beforeTest() throws InterruptedException {
//        ChromeOptions option = new ChromeOptions();
//        option.addExtensions(new File("src/main/resources/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_6_9_0_0.crx"));
//        driver = new ChromeDriver(option);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        driver.get("https://zamzam.com/");
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        driver.close();
//        driver.switchTo().window(tabs.get(0));

    }

    @AfterTest
    public void after() throws InterruptedException {
//        soft.assertAll();
        Thread.sleep(2000);
        driver.quit();
    }

    @AfterSuite
    public void tearDown() throws IOException {
        report.flush();
        Desktop.getDesktop().open(new File("Reports/report.html"));
    }
}
