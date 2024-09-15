package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void write(By locator , String text)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void read(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(locator);
    }

    public String readData(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

}
