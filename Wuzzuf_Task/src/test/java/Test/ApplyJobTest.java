package Test;

import Pages.ApplyJobPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class ApplyJobTest extends BaseTest
{
    ApplyJobPage page;
    SoftAssert soft = new SoftAssert();
    WebDriverWait wait;
    Faker fake;
    Select select;

    @Test
    public void TC1() throws InterruptedException
    {
        reportTest = report.createTest("Wuzzuf Task");
        page = new ApplyJobPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //page.productLink();
        fake = new Faker();

        soft.assertEquals(driver.getCurrentUrl(), "https://zamzam.com/");
        reportTest.pass("Correct Url");
        page.searchLabel();
        page.searchButton();
        Thread.sleep(1000);
        page.dataPosted();
        page.pastWeek();
        Thread.sleep(3000);
        String Result = page.numberOfJob();
        System.out.println(Result);
        page.firstJob();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());
        page.applyJob();
        page.firstName();
        page.lastName();
        page.Email();
        page.Pass();
        page.login();
        page.choice1();
        page.choice2();
        page.choice3();
        page.choice4();
        page.choice5();
        page.continueButton();
        page.setGender();
//        page.setPhoneNumber();
    }
}
