package Page;

import Model.Job;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddJobPage extends Page{
    public AddJobPage(WebDriver webDriver) {
        super(webDriver);
    }

    private static By addJobName = By.xpath("//div[2]/input[@class = 'oxd-input oxd-input--active' ]");
    private static By addJobDescription = By.xpath("//textarea[@placeholder = 'Type description here']");
    private static By addNode = By.xpath("//textarea[@placeholder = 'Add note']");
    private static By saveButton = By.xpath("//button[text() = ' Save ']");


    public AddJobPage addJobName(String  str)
    {
        Waiting.waitElement(driver, addJobName);
        driver.findElement(addJobName).sendKeys(str);
        return this;
    }

    public AddJobPage addJobDescription(String  str)
    {
        driver.findElement(addJobDescription).sendKeys(str);
        return this;
    }

    public AddJobPage addNote(String  str)
    {
        driver.findElement(addNode).sendKeys(str);
        return this;
    }

    public AdminMenuPage saveJob()
    {
        driver.findElement(saveButton).click();
        return new AdminMenuPage(driver);
    }

    public AdminMenuPage addJob(Job job)
    {
        addJobName(job.getJobName());
        addJobDescription(job.getJobDescription());
        addNote(job.getNote());
        return saveJob();
    }

}
