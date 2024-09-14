package Test;

import Page.ZamzamPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class ZamzamTest extends TestBase
{
    ZamzamPage page;
    SoftAssert soft = new SoftAssert();
    WebDriverWait wait;

    @Test
    public void TC1() throws InterruptedException
    {
        reportTest = report.createTest("Zamzam Task");
        page = new ZamzamPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //page.productLink();
        soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
        reportTest.pass("Correct Url");
        WebElement footer = driver.findElement(By.tagName("footer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        Thread.sleep(15000);
//        page.exitButton();

        page.FBLink();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //soft.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/zamzamtrips");
        soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Facebook URL does not contain 'zamzam'");
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(tabs.get(0));
        Thread.sleep(5000);
        soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
        page.TWLink();
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //soft.assertEquals(driver.getCurrentUrl(),"https://x.com/zamzamtrips");
        soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Twitter URL does not contain 'zamzam'");
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(tabs.get(0));
        soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
        page.instgramLink();
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //soft.assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/zamzamtrips/");
        soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Instagram URL does not contain 'zamzam'");
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(tabs.get(0));
        soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
        page.LinkedInLink();
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //soft.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/authwall?trk=bf&trkInfo=AQETAE0VdO7ZpAAAAZHspOggRgdp-MCbCgN5U2JnAA3ZdM-L5ZuvqhNKv8CJFPkXYisTly7Nty2qDg3pf9XeqjLZKqDqCvQX8YRzTz2zlYnW_T1bMPDXoO67e1MWcbD3FSEdxEM=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fzamzamtrips");
        soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "LinkedIn URL does not contain 'zamzam'");
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(tabs.get(0));
        soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
        page.youtubeLink();
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //soft.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/channel/UCc5uQ4hwnLgNsXhxv8pQtYQ");
        ////soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "YouTube URL does not contain 'zamzam'");
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(tabs.get(0));
        soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
        //Scroll up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        Thread.sleep(2000);
        page.searchMakkah();
        page.country();
        page.setNationality();
        //soft.assertEquals(page.getCheckNationality(), "Egypt", "The nationality is not 'Egypt'");
        page.clickRoom();
        page.nOfRoom();
        page.choiceRoom();
        page.Datalable();

        for(int i=0;i<=10;i++)
        {
            page.buttonChange();
        }


        page.selectOne();
        page.selectten();
        page.finalSearch();
        page.hotal();

        //for reach the element
        WebElement checkAvailability = driver.findElement(By.cssSelector("button[style=\"padding: 5px 10px;\"] span:nth-child(1)"));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkAvailability).perform();

        System.out.println(page.getMessage());

        soft.assertAll();
    }


}


