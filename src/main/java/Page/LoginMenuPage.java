package Page;

import Model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMenuPage extends Page{
    private static By passwordInputButton = By.xpath("//input[@name = 'password']");
    private static By loginInputButton = By.xpath("//input[@name = 'username']");
    private static By submitButton = By.xpath("//button[@type = 'submit']");
    public LoginMenuPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginMenuPage enterLogin(String login)
    {
        Waiting.waitElement(driver, loginInputButton);
        driver.findElement(loginInputButton).sendKeys(login);
        return this;
    }

    public LoginMenuPage enterPassword(String password)
    {
        driver.findElement(passwordInputButton).sendKeys(password);
        return this;
    }

    public LoginMenuPage submit()
    {
        driver.findElement(submitButton).click();
        return this;
    }

    public SideBarMenuPage logIn(User user)
    {
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        submit();
        return new SideBarMenuPage(driver);
    }

}
