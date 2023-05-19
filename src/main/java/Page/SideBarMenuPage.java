package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SideBarMenuPage extends Page {
    private static By adminButton = By.xpath("//a[@href  = '/web/index.php/admin/viewAdminModule']");
    public SideBarMenuPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AdminMenuPage adminButton()
    {
        Waiting.waitElement(driver, adminButton);
        driver.findElement(adminButton).click();
        return new AdminMenuPage(driver);
    }
}
