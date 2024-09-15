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
    private By choice1Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1) div:nth-child(3)");
    private By choice2Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(2) div button:nth-child(1)");
    private By choice3Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(3) div button:nth-child(3)");
    private By choice4Locator = By.cssSelector("div[class=\"css-1b3ykmn emyle0o0\"] div[class=\"css-12119hv exkztdf0\"] form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(4) div[class=\"css-1sdnanw ediq4wm2\"] div[class=\"css-1pwt1s8 ediq4wm0\"] div:nth-child(1)");
    private By salaryLocator = By.cssSelector("input[name=\"minimumSalary\"]");
    private By continueButtonLocator = By.cssSelector("button[class=\"css-1wj05oe ezfki8j0\"]");

    private By gender = By.cssSelector("div[class=\"css-3pwpkg\"] label:nth-child(2) div ");
    private By phoneNumber = By.name("primaryPhone");
    private By day = By.cssSelector("div[class=\"css-12119hv exkztdf0\"]  form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1) div[class=\"css-1x21pox e6pv2vl4\"] div[class=\"row\"] div[class=\"col-2-lg col-12\"] div[class=\" css-1dgicot-container\"]");
    private By dayOption = By.xpath("//div[text()='19']");

    private By month = By.cssSelector("div[class=\"css-12119hv exkztdf0\"]  form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1) div[class=\"css-1x21pox e6pv2vl4\"] div[class=\"row\"]  div[class=\"col-3-lg col-12\"] div");
    private By monthOption = By.xpath("//div[text()='September']");

    private By year = By.cssSelector("div[class=\"css-12119hv exkztdf0\"]  form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1) div[class=\"css-1x21pox e6pv2vl4\"] div[class=\"col-3-lg col-12\"]:nth-child(3) div");
    private By yearOption = By.xpath("//div[text()='1999']");

    private By nationality = By.cssSelector("div[class=\"css-12119hv exkztdf0\"]  form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(1)  div[class=\"css-rpi6b5 e6pv2vl4\"]:nth-child(6) div[class=\"css-1d3w5wq\"] div[class=\" css-1dgicot-container\"]");
    private By nationalityOption = By.xpath("//div[text()='Egypt']");

    private By city =By.cssSelector("div[class=\"css-12119hv exkztdf0\"]  form div[class=\"section-validation-error css-6hend0 e1v1l3u10\"]:nth-child(2) div[class=\"css-rpi6b5 e6pv2vl4\"]:nth-child(3) div[class=\" css-1dgicot-container\"]");
    private By cityOption = By.xpath("//div[text()='Cairo']");

    private By area = By.cssSelector("div[class=\"css-12119hv exkztdf0\"] form div[class=\" css-6hend0 e1v1l3u10\"]:nth-child(2) div[class=\"css-rpi6b5 e6pv2vl4\"]:nth-child(4) div[class=\"css-1d3w5wq\"] div[class=\" css-1dgicot-container\"]");
    private By areaOption = By.xpath("//div[text()='Badr City']");
    private By saveContinue = By.cssSelector("button[class=\"css-1wj05oe ezfki8j0\"]");
    private By exprince = By.cssSelector("div[class=\" css-ypbzk3-control\"]");
    private By exprinceOption = By.xpath("//div[text()='Less than 1 year'");

    private By educationLevel = By.cssSelector("div[name=\"currentEducationLevel\"] div:nth-child(1)");
    private By faculty = By.cssSelector("div[class=\"css-1heugwa ek82ord1\"]");
    private By university = By.cssSelector("div[class=\"css-1fttcpj e6pv2vl2\"] div[class=\"css-10m6313 e6pv2vl3\"] div[class=\" css-1dgicot-container\"] div[class=\" css-ypbzk3-control\"]");
    private By language = By.cssSelector("div[class=\"css-6hend0 e1v1l3u10\"] div[class=\"section-validation-error\"] div[class=\"css-1xrefku e6pv2vl1\"] div[class=\"css-911kv1 e6pv2vl0\"]:nth-child(1) div[class=\"css-1d3w5wq\"] div[class=\" css-1dgicot-container\"]");
    private By languageOption = By.xpath("//div[text()='Arabic']");


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

    public void enterSalary()
    {
        write(salaryLocator,"15000");
    }

    public void continueButton()
    {
        click(continueButtonLocator);
    }

    public void setGender()
    {
        click(gender);
    }

    public void setPhoneNumber()
    {
        write(phoneNumber,"01275512650");
    }

    public void selectDay()
    {
        click(day);
        click(dayOption);
    }

    public void selectMonth()
    {
        click(month);
        click(monthOption);
    }

    public void selectYear()
    {
        click(year);
        click(yearOption);
    }

    public void selectNationality()
    {
        click(nationality);
        click(nationalityOption);
    }

    public void selectCity()
    {
        click(city);
        click(cityOption);
    }

    public void selectarea()
    {
        click(area);
        click(areaOption);
    }

    public void saveContinue()
    {
        click(saveContinue);
    }

    public void selectExprince()
    {
        click(exprince);
        click(exprinceOption);
    }

    public void setEducationLevel()
    {
        click(educationLevel);
    }
    public void setFaculty()
    {
        write(faculty,"Faculty of emginnering");
    }

    public void setUniversity()
    {
        write(university,"Zagazig university");
    }

    public void setLanguage()
    {
        click(language);
        click(languageOption);
    }
}
