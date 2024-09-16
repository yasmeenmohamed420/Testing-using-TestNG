package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZamzamPage extends PageBase
{

    public ZamzamPage(WebDriver driver)
    {
        super(driver);
    }

    //Locator
    private By exitButton = By.cssSelector("button[id=\"linkLeadCaptureClose\"]");
    private By FBLocator = By.cssSelector("a[href=\"https://www.facebook.com/zamzamtrips\"]");
    private By TWLocator = By.id("linkTwitter");
    private By LinkedInLocator = By.id ("linkLinkedin");
    private By youtubeLocator = By.id("linkYoutube");
    private By instgramLocator = By.id("linkInstagram");
    private By Search = By.cssSelector("div[class=\"search_form form-motif\"] form div div div div:nth-child(2) input[id=\"HotelCity\"]");
    private By country =By.cssSelector("ul[class=\"ui-menu ui-widget ui-widget-content ui-autocomplete ui-front tpmAutocomplete\"] ");
    private By Nationality = By.cssSelector("select[class=\"form_control iconInput inptl\"] option[value=\"EG\"]");
    private By checkNationality = By.cssSelector("div[class=\"search_form form-motif\"] form div div div div:nth-child(4)");
    private By clickRoom = By.cssSelector("div[class=\"search_form form-motif\"] form div div div div:nth-child(3) div[class=\"inp_group\"]");
    private By nOfRoom = By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select");
    private By room = By.cssSelector("div[class=\"col-12 col-md-8 col-lg-8\"] div select option:nth-child(2)");
    private By Datalable = By.id("hotelStayDates");
    private By selectOne = By.cssSelector("div[class=\"dayContainer\"]:nth-child(2) span:nth-child(2)");
    private By selectten = By.cssSelector("div[class=\"dayContainer\"]:nth-child(2) span:nth-child(11)");
    private By buttonChange = By.cssSelector("span[class=\"flatpickr-next-month\"] svg");
    private By finalSearch = By.cssSelector("span[class=\"content\"]");
    private By hotal = By.cssSelector("span[data-hotelname=\"Al Noor Hotel\"]");
    private By checkAvailability = By.cssSelector("button[style=\"padding: 5px 10px;\"] span:nth-child(1)");
    private By errorMessage = By.cssSelector("h5[class=\"pt-3 pb-3\"]");
    //Method
    public void exitButton()
    {
        click(exitButton);
    }
    public void FBLink()
    {
        click(FBLocator);
    }
    public void TWLink()
    {
        click(TWLocator);
    }
    public void LinkedInLink()
    {
        click(LinkedInLocator);
    }
    public void youtubeLink()
    {
        click(youtubeLocator);
    }
    public void instgramLink()
    {
        click(instgramLocator);
    }
    public void searchMakkah()
    {
        write(Search,"makkah");
    }
    public void country()
    {
        click(country);
    }
    public void setNationality()
    {
        click(Nationality);
    }

    public String getCheckNationality()
    {
        return readData(checkNationality);
    }

    public void clickRoom()
    {
        click(clickRoom);
    }
    public void Datalable()
    {
        click(Datalable);
    }

    public void nOfRoom()
    {
        click(nOfRoom);
    }
    public void choiceRoom()
    {
        click(room);
    }

    public void selectOne()
    {
        click(selectOne);
    }
    public void selectten()
    {
        click(selectten);
    }
    public void buttonChange()
    {
        click(buttonChange);
    }
    public void finalSearch()
    {
        click(finalSearch);
    }

    public void hotal()
    {
        click(hotal);
    }

    public void availabilityBotton()
    {
        click(checkAvailability);
    }

    public String getMessage()
    {
        return  readData(errorMessage);
    }
}
