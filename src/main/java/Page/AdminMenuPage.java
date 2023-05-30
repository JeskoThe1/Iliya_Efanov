package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminMenuPage extends Page{
    public AdminMenuPage(WebDriver webDriver) {
        super(webDriver);
    }
    private By jobMenuButton = By.xpath("//*[text() = 'Job ']");
    private By jobTitlesButton = By.xpath("//*[text() = 'Job Titles']");
    private By addJobButton = By.xpath("//button[text() = ' Add ']");
    private By acceptDeleteButton = By.xpath("//button[text() = ' Yes, Delete ']");

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
        if(driver.findElements(By.xpath("//div[text() = " + "\"" + str + "\"" + "]")).isEmpty())
            return false;
        return true;
    }
}
