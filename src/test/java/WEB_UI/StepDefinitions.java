package WEB_UI;

import Model.Job;
import Model.User;
import Page.*;
import io.cucumber.java.en.*;


import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    private WebDriver driver;
    User user = new User();
    Job job = new Job();
    @Given("I navigate to site")
    public void givenNavigateToSite()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }

    @Given("I log in to site")
    public void givenLoginToSite()
    {
        LoginMenuPage page = new LoginMenuPage(driver);
        page.logIn(user);
    }

    @Given("I navigate to site's section")
    public void givenINavigateToSitesSection()
    {
        SideBarMenuPage page = new SideBarMenuPage(driver);
        page.adminButton().jobButton().jobTitlesButton().addJobButton();
    }

    @When("I add job verify whether the job is added")
    public void whenIAddJobInformation()
    {
        AddJobPage page = new AddJobPage(driver);
        if (page.addJob(job).isElementExist(job.getJobName()))
            throw new InvalidArgumentException("Does not exist");
    }

    @Then("I delete added job and verify the job is deleted")
    public void thenIDeleteAddedJob()
    {
        AdminMenuPage page = new AdminMenuPage(driver);
        page.deleteJob(job.getJobName());
        if (page.isElementExist(job.getJobName()))
            throw new InvalidArgumentException("Does exist");
    }
}
