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
        reportTest.pass("Correct Url");
        page.searchLabel();

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class=\"css-ukkbbr e1n2h7jb1\"]")));
        String searchText = search.getAttribute("value");
        soft.assertEquals(searchText, "Software testing");
        reportTest.pass("Correct Search");

        WebElement button = driver.findElement(By.cssSelector("button[class=\"css-11qi1o ezfki8j0\"]"));
        soft.assertTrue(button.isEnabled());
        reportTest.pass("Button work correctly");
        page.searchButton();

        Thread.sleep(3000);
        page.dataPosted();
        page.pastWeek();
        Thread.sleep(3000);
        String Result = page.numberOfJob();
        System.out.println(Result);
        reportTest.pass("Number of job avilable is "+Result);

        page.firstJob();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());
        reportTest.pass("Now in apply job link shown");

        WebElement button2 = driver.findElement(By.cssSelector("button[class=\"css-1m0yk35 ezfki8j0\"]"));
        soft.assertTrue(button2.isEnabled());
        reportTest.pass("Button work correctly");
        page.applyJob();

        page.firstName();

        page.lastName();
        page.Email();
        page.Pass();
        page.login();

        Thread.sleep(3000);
        page.choice1();
        page.choice2();
        page.choice3();
        page.choice4();
        page.enterSalary();
        Thread.sleep(3000);
        page.continueButton();

//        WebElement button1 = driver.findElement(By.cssSelector("button[class=\"css-1wj05oe ezfki8j0\"]"));
//        soft.assertTrue(button1.isEnabled());

        Thread.sleep(3000);
        /************* First page ***********/
        page.setGender();
        page.selectDay();
        page.selectMonth();
        page.selectYear();

        By day = By.cssSelector("div[class=\"css-12119hv exkztdf0\"]  form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1) div[class=\"css-1x21pox e6pv2vl4\"] div[class=\"row\"] div[class=\"col-2-lg col-12\"] div[class=\" css-1dgicot-container\"]");
        By month = By.cssSelector("div[class=\"css-12119hv exkztdf0\"]  form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1) div[class=\"css-1x21pox e6pv2vl4\"] div[class=\"row\"]  div[class=\"col-3-lg col-12\"] div");
        By year = By.cssSelector("div[class=\"css-12119hv exkztdf0\"]  form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1) div[class=\"css-1x21pox e6pv2vl4\"] div[class=\"col-3-lg col-12\"]:nth-child(3) div");

        WebElement checkDay = driver.findElement(day);
        soft.assertEquals(checkDay.getText(),"19");
        reportTest.pass("Day equal 19 ");

        WebElement checkMonth = driver.findElement(month);
        soft.assertEquals(checkMonth.getText(),"September");
        reportTest.pass("Month equal September");

        WebElement checkyear = driver.findElement(year);
//        soft.assertEquals(checkyear.getText(),"1999");
        reportTest.pass("year equal 1999 ");

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
        // page.selectExprince();
        page.setEducationLevel();
        reportTest.pass("Bacherlor`s Degree is selected");
//        page.setFaculty();
//        page.setUniversity();
//        page.setLanguage();

        soft.assertAll();
    }
}
