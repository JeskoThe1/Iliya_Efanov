package Page;

import lombok.Data;
import org.openqa.selenium.WebDriver;
@Data
public class Page {
    protected final WebDriver driver;
    public Page(WebDriver webDriver){
        this.driver = webDriver;
    }
}
