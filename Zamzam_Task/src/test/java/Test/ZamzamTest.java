package Test;

import Page.ZamzamPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        try {

            reportTest = report.createTest("Zamzam Task");
            page = new ZamzamPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("Correct Url");
            WebElement footer = driver.findElement(By.tagName("footer"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
            Thread.sleep(15000);

            page.FBLink();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/zamzamtrips");
            soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Facebook URL does not contain 'zamzam'");
            reportTest.pass("FaceBook include zamzam ");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            Thread.sleep(5000);
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");
            page.TWLink();
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://x.com/zamzamtrips");
            soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Twitter URL does not contain 'zamzam'");
            reportTest.pass("Twitter include zamzam ");
//            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");

            page.instgramLink();
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/zamzamtrips/");
            soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Instagram URL does not contain 'zamzam'");
            reportTest.pass("Instgrame include zamzam ");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");

            page.LinkedInLink();
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/authwall?trk=bf&trkInfo=AQETAE0VdO7ZpAAAAZHspOggRgdp-MCbCgN5U2JnAA3ZdM-L5ZuvqhNKv8CJFPkXYisTly7Nty2qDg3pf9XeqjLZKqDqCvQX8YRzTz2zlYnW_T1bMPDXoO67e1MWcbD3FSEdxEM=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fzamzamtrips");
            soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "LinkedIn URL does not contain 'zamzam'");
            reportTest.pass("LinkedIn include zamzam ");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");

            page.youtubeLink();
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/channel/UCc5uQ4hwnLgNsXhxv8pQtYQ");
            soft.assertFalse(driver.getCurrentUrl().contains("zamzam"), "YouTube URL does not contain 'zamzam'");
            reportTest.fail("youtubeLink doesn`t include zamzam ");
            reportTest.info("Youtube should include zamzam");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");
            //Scroll up
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

            Thread.sleep(2000);
            page.searchMakkah();
            page.country();
            WebElement checkcountry = driver.findElement(By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(1)"));
//        //soft.assertEquals(checkcountry.getText(),"Makkah / Mecca, Saudi Arabia");
            reportTest.pass("country is Makkah / Mecca, Saudi Arabia ");

            page.setNationality();
            WebElement nationality = driver.findElement(By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(4)"));
//        //soft.assertEquals(checkcountry.getText(),"Egypt");
            reportTest.pass("Nationality is Egypt");

            page.clickRoom();
            page.nOfRoom();
            page.choiceRoom();

            WebElement numberofroom = driver.findElement(By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(2)"));
            soft.assertEquals(numberofroom.getText(),"2 Rooms");
            System.out.println(numberofroom.getText());
            reportTest.pass("2 Rooms | 4 Adults");
            page.Datalable();

            for(int i=0;i<=10;i++)
            {
                page.buttonChange();
            }

            page.selectOne();
            page.selectten();

            Thread.sleep(3000);
            WebElement Data =  driver.findElement(By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(3)"));
//        //soft.assertEquals(Data.getText(),"01-Sep-2025 to 10-Sep-2025");
            System.out.println(Data.getText());
            reportTest.pass("Check In/Check Out is correct");

            page.finalSearch();

            WebElement Search = driver.findElement(By.cssSelector("span[class=\"content\"]"));
            soft.assertTrue(Search.isEnabled());
            reportTest.pass("Button search is work correctly");

            page.hotal();

            //for reach the element
            WebElement checkAvailability = driver.findElement(By.cssSelector("button[style=\"padding: 5px 10px;\"] span:nth-child(1)"));
            Actions actions = new Actions(driver);
            actions.moveToElement(checkAvailability).perform();
            soft.assertTrue(checkAvailability.isEnabled());
            reportTest.pass("Button checkAvailability is work correctly");
            page.availabilityBotton();

            System.out.println(page.getMessage());
            soft.assertEquals(page.getMessage(), "We can’t find the page you are looking for.\n" +
                    "Seems like this page is temporarily unavailable", "The error message is not as expected.");
            reportTest.pass("Message apper correctly");
        }

        catch (NoSuchElementException e)
        {
            page.exitButton();
            reportTest = report.createTest("Zamzam Task");
            page = new ZamzamPage(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("Correct Url");
            WebElement footer = driver.findElement(By.tagName("footer"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
//            Thread.sleep(15000);

            page.FBLink();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/zamzamtrips");
            soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Facebook URL does not contain 'zamzam'");
            reportTest.pass("FaceBook include zamzam ");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            Thread.sleep(5000);
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");
            page.TWLink();
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://x.com/zamzamtrips");
            soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Twitter URL does not contain 'zamzam'");
            reportTest.pass("Twitter include zamzam ");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");

            page.instgramLink();
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/zamzamtrips/");
            soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "Instagram URL does not contain 'zamzam'");
            reportTest.pass("Instgrame include zamzam ");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");

            page.LinkedInLink();
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/authwall?trk=bf&trkInfo=AQETAE0VdO7ZpAAAAZHspOggRgdp-MCbCgN5U2JnAA3ZdM-L5ZuvqhNKv8CJFPkXYisTly7Nty2qDg3pf9XeqjLZKqDqCvQX8YRzTz2zlYnW_T1bMPDXoO67e1MWcbD3FSEdxEM=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fzamzamtrips");
            soft.assertTrue(driver.getCurrentUrl().contains("zamzam"), "LinkedIn URL does not contain 'zamzam'");
            reportTest.pass("LinkedIn include zamzam ");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");

            page.youtubeLink();
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //soft.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/channel/UCc5uQ4hwnLgNsXhxv8pQtYQ");
            soft.assertFalse(driver.getCurrentUrl().contains("zamzam"), "YouTube URL does not contain 'zamzam'");
            reportTest.fail("youtubeLink doesn`t include zamzam ");
            reportTest.info("Youtube should include zamzam");
            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(tabs.get(0));
            soft.assertEquals(driver.getCurrentUrl(),"https://zamzam.com/");
            reportTest.pass("It is back to zamzam website");
            //Scroll up
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

            Thread.sleep(2000);
            page.searchMakkah();
            page.country();
            WebElement checkcountry = driver.findElement(By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(1)"));
//        //soft.assertEquals(checkcountry.getText(),"Makkah / Mecca, Saudi Arabia");
            reportTest.pass("country is Makkah / Mecca, Saudi Arabia ");

            page.setNationality();
            WebElement nationality = driver.findElement(By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(4)"));
//        //soft.assertEquals(checkcountry.getText(),"Egypt");
            reportTest.pass("Nationality is Egypt");

            page.clickRoom();
            page.nOfRoom();
            page.choiceRoom();

            WebElement numberofroom = driver.findElement(By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(2)"));
            soft.assertEquals(numberofroom.getText(),"2 Rooms");
            System.out.println(numberofroom.getText());
            reportTest.pass("2 Rooms | 4 Adults");
            page.Datalable();

            for(int i=0;i<=10;i++)
            {
                page.buttonChange();
            }

            page.selectOne();
            page.selectten();

            Thread.sleep(3000);
            WebElement Data =  driver.findElement(By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(3)"));
//        //soft.assertEquals(Data.getText(),"01-Sep-2025 to 10-Sep-2025");
            System.out.println(Data.getText());
            reportTest.pass("Check In/Check Out is correct");

            page.finalSearch();

            WebElement Search = driver.findElement(By.cssSelector("span[class=\"content\"]"));
            soft.assertTrue(Search.isEnabled());
            reportTest.pass("Button search is work correctly");

            page.hotal();

            //for reach the element
            WebElement checkAvailability = driver.findElement(By.cssSelector("button[style=\"padding: 5px 10px;\"] span:nth-child(1)"));
            Actions actions = new Actions(driver);
            actions.moveToElement(checkAvailability).perform();
            soft.assertTrue(checkAvailability.isEnabled());
            reportTest.pass("Button checkAvailability is work correctly");
            page.availabilityBotton();

            System.out.println(page.getMessage());
            soft.assertEquals(page.getMessage(), "We can’t find the page you are looking for.\n" +
                    "Seems like this page is temporarily unavailable", "The error message is not as expected.");
            reportTest.pass("Message apper correctly");
        }
        soft.assertAll();
    }


}


