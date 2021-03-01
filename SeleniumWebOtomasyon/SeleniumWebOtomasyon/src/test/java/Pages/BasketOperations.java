package Pages;

import TestCases.Cases;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasketOperations {

    WebDriver driver;
    private static Logger log = Logger.getLogger(Cases.class);

    By ButtonPlus=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[4]/div/span[2]");

    By ButtonDelete=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[3]/div/div[2]/div/a[1]");
    //By MsgBox=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[2]/h2");
    //By ButtonBasket=By.xpath("//a[contains(text(),'Sepete Git')]");

    public BasketOperations(WebDriver driver){
        this.driver = driver;
    }

    public void productIncreasing() {
        log.debug("productIncreasing metodu başladi");
        try {

            Select dpCounter=new Select(driver.findElement(By.className("gg-input gg-input-select")));
            dpCounter.deselectByVisibleText("2");
//            Thread.sleep(2000);
//            driver.findElement(ButtonPlus).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


    public void productDelete()  {
        log.debug("productDelete metodu başladi");
        try {
            Thread.sleep(2000);
            driver.findElement(ButtonDelete).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

    public void goToBasket() {
        log.debug("goToBasket metodu basladi");
        try {

            Thread.sleep(1000);
            driver.get("https://www.gittigidiyor.com/sepetim");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}


