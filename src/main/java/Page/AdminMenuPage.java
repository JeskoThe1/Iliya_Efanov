package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AdminMenuPage extends Page{
    public AdminMenuPage(WebDriver webDriver) {
        super(webDriver);
    }
    private static By jobMenuButton = By.xpath("//*[text() = 'Job ']");
    private static By jobTitlesButton = By.xpath("//*[text() = 'Job Titles']");
    private static By addJobButton = By.xpath("//button[text() = ' Add ']");
    private static By acceptDeleteButton = By.xpath("//button[text() = ' Yes, Delete ']");

    public AdminMenuPage jobButton()
    {
        Waiting.waitElement(driver, jobMenuButton);
        driver.findElement(jobMenuButton).click();
        return this;
    }

    public AdminMenuPage jobTitlesButton()
    {
        driver.findElement(jobTitlesButton).click();
        return this;
    }

    public AddJobPage addJobButton()
    {
        Waiting.waitElement(driver, addJobButton);
        driver.findElement(addJobButton).click();
        return new AddJobPage(driver);
    }

    public AdminMenuPage deleteJob(String str)
    {
        By deleteJob = By.xpath("//div[text() = " +"\"" + str + "\"" +"]/parent::div/following-sibling::div/following-sibling::div/child::div/child::button");
        Waiting.waitElement(driver, deleteJob);
        driver.findElement(deleteJob).click();
        driver.findElement(acceptDeleteButton).click();
        return this;
    }

    public Boolean isElementExist(String str)
    {
        try
        {
            driver.findElement(By.xpath("//div[text() = " +"\"" + str + "\"" + "]"));
            return true;
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }
    }
}
