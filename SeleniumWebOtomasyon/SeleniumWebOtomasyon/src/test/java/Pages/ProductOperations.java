package Pages;
import TestCases.Cases;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;


public class ProductOperations {

    WebElement result;
    JavascriptExecutor jse;
    WebDriver driver;
    private static Logger log = Logger.getLogger(Cases.class);
    By Search = By.cssSelector("input[data-cy='header-search-input']");
    By Button = By.cssSelector("button[data-cy='search-find-button']");

    private String word = "bilgisayar";

    public ProductOperations(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchWord(String searchWord) {
        this.word = searchWord;
    }

    public void sendAndClickSearch() {
        log.debug("sendAndClickSearch metodu başladı");
        try {

            driver.findElement(Search).sendKeys(word);
            driver.findElement(Button).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void secondPage(int pageNo) {
        log.debug("secondPage metodu başladı");
        try {
            //  driver.findElement(By.xpath("//a[text()='"+pageNo+"']")).click();

            driver.get(" https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=" + pageNo);
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void productSelect(int random) {
        log.debug("productSelect metodu başladı");
        try {

            WebElement productPage = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[3]/div[2]/ul/li[" + random + "]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productPage);

            Actions actions = new Actions(driver);
            actions.moveToElement(productPage).build().perform();
            WebElement buttonBasket = driver.findElement(By.xpath("//body/div[5]/div[2]/div[1]/div[2]/div[3]/div[2]/ul[1]/li[" + random + "]/a[1]/div[1]/div[1]/div[1]/div[3]/button[1]"));
            buttonBasket.click();
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getActualPrice(int random) {

        log.debug("getActualPrice metodu başladı");

        String actualPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[2]/div[3]/div[2]/ul[1]/li[" + random + "]/a[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]")).getText();
        return actualPrice;


    }


    public String getBasketPrice() {

        WebElement basket=driver.findElement(By.xpath("//body/div[@id='topContainer']/div[@id='GGHeaderWrapper']/div[@id='header_wrapper']/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[2]/p[3]/span[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(basket).build().perform();

        String basketPrice=driver.findElement(By.xpath("//body/div[@id='topContainer']/div[@id='GGHeaderWrapper']/div[@id='header_wrapper']/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[2]/p[3]/span[1]")).getText();
        return basketPrice;


    }





}