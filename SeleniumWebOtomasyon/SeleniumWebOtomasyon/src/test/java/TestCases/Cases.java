package TestCases;

import Pages.BasketOperations;
import Pages.HomePageOperations;
import Pages.LoginPageOperations;
import Pages.ProductOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cases {
    WebDriver driver;

    @Before
    public void setup(){
        //burayı düzelt!!111

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }


    @Test
    public void openWebSite(){

        HomePageOperations homePage = new HomePageOperations(driver);
        /* ilgili site açılır. */
        homePage.openWebsite();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/");
        /* Ana sayfanın açıldığı kontrol edilir. Siteye login olunur. */


        LoginPageOperations loginPage = new LoginPageOperations(driver);

        loginPage.openLoginPage();

        loginPage.setEmail("ahmetsevi93@gmail.com");
        loginPage.setPass("ntttuj123");
        loginPage.loginWebSite();

        /* kullanıcı ismi ile Login işlemi kontrol edilir. */
        Assert.assertEquals(loginPage.loginControl(),"atilsevi538986");


        ProductOperations productOperations = new ProductOperations(driver);
        /* Bilgisayar kelimesi aratılır*/
        productOperations.setSearchWord("bilgisayar");
        productOperations.sendAndClickSearch();
        /* Arama sonuçları sayfasından 2.sayfa açılır. */
       productOperations.secondPage(2);
        /* 2.sayfanın açıldığı kontrolü. */
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");


        /* Rastgele bir ürün seçilir. */
        int random =(int)(Math.random()*48);
        productOperations.productSelect(random);


        //fiyat karşılaştırması
        // String actualPrice= productOperations.getActualPrice(random);
        // String basketPrice= productOperations.getBasketPrice();
        // Assert.assertEquals(actualPrice,basketPrice,"fiyat uyumsuzluğu!");


        BasketOperations basketOperations=new BasketOperations(driver);
        /* Sepete gidilir */
        basketOperations.goToBasket();
        /* Sepet boşaltılır */
        basketOperations.productDelete();

    }




}





