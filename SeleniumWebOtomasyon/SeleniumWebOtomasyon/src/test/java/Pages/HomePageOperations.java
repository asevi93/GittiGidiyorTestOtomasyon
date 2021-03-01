package Pages;

import TestCases.Cases;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePageOperations {

    WebDriver driver;
    private static Logger log = Logger.getLogger(Cases.class);
    public HomePageOperations(WebDriver driver){
        this.driver = driver;
    }

    public void openWebsite(){
        log.debug("openWebsite metodu başladi");
        driver.get("https://www.gittigidiyor.com/");
    }

}
