package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ApplyJobPage extends BasePage
{
    private Faker faker;
    Select select;

    public ApplyJobPage(WebDriver driver)
    {
        super(driver);
        faker = new Faker();
    }

    //Locator
    private By searchLabelLocator= By.cssSelector("input[class=\"css-ukkbbr e1n2h7jb1\"]");
    private By searchButtonLocator = By.cssSelector("button[class=\"css-11qi1o ezfki8j0\"]");
    private By dataPostedLocator = By.className("css-1d5tds3");
    private By pastWeekLocator = By.cssSelector("div[class=\"css-ala0zs\"] div[class=\"css-19idom\"]:nth-child(3)");
    private By numberOfJobLocator = By.cssSelector("span[class=\"css-xkh9ud\"] strong");
    private By firstJobLocator = By.cssSelector("div[class=\"css-1gatmva e1v1l3u10\"]:nth-child(1) a[href=\"https://wuzzuf.net/jobs/p/uzMBLlbSWaP1-Software-Testing-Engineer-MTS-IT-Cairo-Egypt\"]");
    private By applyJobLocator = By.cssSelector("button[class=\"css-1m0yk35 ezfki8j0\"]");
    private By firstNameLocator = By.id("firstname");
    private By lastNameLocator = By.cssSelector("input[name=\"lastname\"]");
    private By emailLocator = By.cssSelector("input[id=\"email\"]");
    private By passLocator = By.cssSelector("div[class=\"css-sbn8kg e2hijbg0\"] div[class=\"css-18uqayh er44h621\"] input");
    private By loginLocator = By.cssSelector("button[class=\"css-6lejne ezfki8j0\"]");
    private By choice5Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(5) div[class=\"css-bl1ilx\"] div[class=\"css-1f2c5hb\"] div[class=\"css-150a24d\"] input");
    private By choice1Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1) div:nth-child(3)");
    private By choice2Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(2) div button:nth-child(1)");
    private By choice3Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(3) div button:nth-child(3)");
    private By choice4Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(4) div[class=\"css-1sdnanw ediq4wm2\"] div[class=\"css-1pwt1s8 ediq4wm0\"] div:nth-child(1)");
    private By continueButtonLocator = By.cssSelector("button[class=\"css-1wj05oe ezfki8j0\"]");
    private By gender = By.cssSelector("div[class=\"css-3pwpkg\"] label:nth-child(2) div ");
//    private By phoneNumber = By.className("css-1ldpk49 e1n2h7jb1");

    //Method
    public void searchLabel()
    {
        write(searchLabelLocator,"Software testing");
    }

    public void searchButton()
    {
        click(searchButtonLocator);
    }

    public void dataPosted()
    {
        click(dataPostedLocator);
    }

    public void pastWeek()
    {
        click(pastWeekLocator);
    }

    public String numberOfJob()
    {
       return readData(numberOfJobLocator);
    }

    public void firstJob()
    {
        click(firstJobLocator);
    }

    public void applyJob()
    {
        click(applyJobLocator);
    }

    public void firstName()
    {
        write(firstNameLocator,faker.name().firstName());
    }

    public void lastName()
    {
        write(lastNameLocator,faker.name().lastName());
    }

    public void Email()
    {
        write(emailLocator,faker.internet().safeEmailAddress());
    }

    public void Pass ()
    {
        write(passLocator,faker.internet().password(8,15,true,true,true));
    }

    public void login()
    {
        click(loginLocator);
    }


    public void choice1()
    {
        click(choice1Locator);
    }
    public void choice2()
    {
        click(choice2Locator);
    }
    public void choice3()
    {
        click(choice3Locator);
    }

    public void choice4()
    {
        click(choice4Locator);
    }

    public void choice5()
    {
        int salary = 15000;
        write(choice5Locator,String.valueOf(salary));
    }

    public void continueButton()
    {
        click(continueButtonLocator);
    }

    public void setGender()
    {
        click(gender);
    }

//    public void setPhoneNumber()
//    {
//        long salary = 15000;
//        write(phoneNumber,String.valueOf(salary));
//    }


}
