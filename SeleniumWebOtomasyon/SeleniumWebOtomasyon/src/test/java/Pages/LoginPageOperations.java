package Pages;

import TestCases.Cases;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageOperations {
    private static String email;
    private static String pass;
    private static Logger log = Logger.getLogger(Cases.class);

    WebDriver driver;
    By Email = By.id("L-UserNameField");
    By Password = By.id("L-PasswordField");
    By ButtonLogin = By.id("gg-login-enter");
    By ButtonFrame =By.cssSelector("#main-header > div:nth-child(3) > div > div > div.sc-1yvp483-0.jUYNgf > div.sc-1nx8ums-0.oAQul > div > div:nth-child(1) > div");
    By LoginPage =By.cssSelector("a[data-cy='header-login-button']");
    public LoginPageOperations(WebDriver driver){
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    public void openLoginPage() {
        log.debug("OpenLoginPage metodu başladı");
        try{

            driver.findElement(ButtonFrame).click();
            Thread.sleep(1000);
            driver.findElement(LoginPage).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }



    public void loginWebSite(){
        try {
            driver.findElement(By.id("gg-login-enter")).click();
            Thread.sleep(3500);
            driver.findElement(Email).sendKeys(email);
            driver.findElement(Password).sendKeys(pass);
            driver.findElement(ButtonLogin).click();
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String loginControl(){
        String byLoginControl = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]/span")).getText();
        return byLoginControl;

    }
}

