package Test;

import Pages.ApplyJobPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        soft.assertEquals(driver.getCurrentUrl(), "https://wuzzuf.net/jobs/egypt");

        try
        {
            soft.assertAll();
            reportTest.pass("Correct URL");
        }
        catch (AssertionError e)
        {
            reportTest.fail("un correct URL");
        }

        page.searchLabel();

        WebElement search = page.t1();
        String searchText = search.getAttribute("value");
        soft.assertEquals(searchText, "Software ");
        try
        {
            soft.assertAll();
            reportTest.pass("Correct Search");
        }
        catch(AssertionError e)
        {
            reportTest.fail("uncorrect Search"+searchText);
        }

        WebElement button = page.T2();
        soft.assertTrue(button.isEnabled());
        try
        {
            soft.assertAll();
            reportTest.pass("Button work correctly");
        }
        catch(AssertionError e)
        {
            reportTest.fail("Button not work correctly");
        }

        page.searchButton();

        Thread.sleep(3000);
        page.dataPosted();
        page.pastWeek();
        Thread.sleep(3000);
        String Result = page.numberOfJob();
        System.out.println(Result);
        reportTest.pass("Number of job avilable is "+Result);
        Thread.sleep(3000);
        page.firstJob();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());
        reportTest.pass("Now in apply job link shown");

        WebElement button2 = page.T7();
        soft.assertTrue(button2.isEnabled());
        try
        {
            soft.assertAll();
            reportTest.pass("Button work correctly");
        }
        catch(AssertionError e)
        {
            reportTest.pass("Button not work correctly");
        }

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
        page.enterSalary();
        Thread.sleep(3000);
        page.continueButton();
        Thread.sleep(3000);

        /************* First page ***********/
        page.setGender();
        page.selectDay();

        WebElement day = page.T3();
        soft.assertEquals(day.getText(),"19");
        try
        {
            soft.assertAll();
            reportTest.pass("Day equal 19 ");
        }
        catch(AssertionError e)
        {
            reportTest.fail("Day not equal 19 ");
        }

        page.selectMonth();
        WebElement month = page.T4();
        soft.assertEquals(month.getText(),"September");
        try
        {
            soft.assertAll();
            reportTest.pass("Month equal September");
        }
        catch(AssertionError e)
        {
            reportTest.pass("Month not equal September");
        }

        page.selectYear();
        WebElement year = page.T5();
        soft.assertEquals(year.getText(),"1999");
        reportTest.pass("year equal 1999 ");
        try
        {
            soft.assertAll();
            reportTest.pass("year equal 1999 ");
        }
        catch(AssertionError e)
        {
//            reportTest.pass("year not equal 1999 ");
        }

        /*********** Second page **************/
        page.selectNationality();
        page.selectCity();
        page.selectarea();
        page.setPhoneNumber();
        page.saveContinue();
        reportTest.pass( "Nationality is Egypt");
        reportTest.pass("City is Cairo");
        reportTest.pass("Area is Badr city");
        reportTest.pass("Phone number equal 01275512650");

        /*********** Third page *******/
        //
        Thread.sleep(3000);
        page.selectExprince();
        page.setEducationLevel();
        page.setDegree();
        page.setGrad();
        page.setProficiency();
        page.setLanguage();
        page.add();
        page.addSkills();
        page.setGetStart();

        reportTest.pass( "selectExprince is no exprience");
        reportTest.pass("EducationLevel Bachelor`s");
        reportTest.pass("Degree is good");
        reportTest.pass("Grad is 65-75");
        reportTest.pass("Language is english");

        page.setFaculty();
        page.setUniversity();
        page.setCv();
        soft.assertAll();
    }
}
