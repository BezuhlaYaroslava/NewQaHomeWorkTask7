package Task7Test;

import fields.Registration;
import fields.RegistrationBuild;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;
import pageOrder.*;

public class Task7Test {

    private SignUpPage signUpPage;
    private Registration registration;
    private RegistrationPage registrationPage;
    private WebDriver driver;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    String actualResult;
    String expectedResult;
    private DressesPage dressesPage;
    private Basket basket;
    private Authoriz authoriz;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/");
    }

    @Before
    public void date(){
    registration = new RegistrationBuild()
            .withTitle("Mrs.")
            .withEmail("byaw@ukr.nett")
            .withOneFirstName("Юзер")
            .withOneLastName("User")
            .withPassword("password")
            .withBirthdayDay("27")
            .withBirthdayMonth("9")
            .withBirthdayYear("1998")
            .withFirstName("Юзер")
            .withLastName("User")
            .withCompany("Company")
            .withOneAddress("oneAddress")
            .withTwoAddress("twoAddress2")
            .withCity("City")
            .withState("Alaska")
            .withZipCode("04001")
            .withPhoneMobile("099000000")
            .withPhoneHome("088000000")
            .withAliasAddress("alias")
            .build();
        homePage = new HomePage(driver);
    }

    @Test
    public void canOpenPage() {
        signUpPage = homePage.openSignInPage();
        registrationPage = signUpPage.writeEmailAndClick(registration);
        myAccountPage = registrationPage.writeRegistrationAndClick(registration);
        actualResult = myAccountPage.getNewAccount();
        expectedResult = "Юзер User";

        Assert.assertEquals("Юзер User", expectedResult, actualResult);
    }

    @Test
    public void canSearch() {
        dressesPage = homePage.openDresses();
        dressesPage.canDresses();

        actualResult = basket.getQuantity();
        expectedResult = "Your shopping cart contains: 2 Products";

        Assert.assertEquals("Your shopping cart contains: 2 Products", expectedResult, actualResult);

    }

    @Test
    public void correctTotal() {
        dressesPage = homePage.openDresses();
        dressesPage.canDresses();
        basket = dressesPage.clickProceedCheckout();

        actualResult = basket.getTotalPrice();
        expectedResult = basket.getTotalProducts();
        Assert.assertEquals("Error correctTotal", expectedResult, actualResult);

    }

    @Test
    public void correctSale() {
        dressesPage = homePage.openDresses();
        dressesPage.canDresses();
        basket = dressesPage.clickProceedCheckout();

        actualResult = basket.getSale();
        expectedResult = "$28.98";
        Assert.assertEquals("Error correctSale", expectedResult, actualResult);

    }

    @Test
    public void correctAddress() {
        dressesPage = homePage.openDresses();
        dressesPage.canDresses();
        basket = dressesPage.clickProceedCheckout();
        authoriz = basket.canClickAuthoriz();
        addressPage = authoriz.allAuthoriz();

        actualResult = addressPage.getYourDeliveryAddress();
        expectedResult = addressPage.getYourBillingAddress();
        Assert.assertEquals("Error correctAddress", expectedResult, actualResult);
    }
    @Test
    public void correctShipping() {
        dressesPage = homePage.openDresses();
        dressesPage.canDresses();
        basket = dressesPage.clickProceedCheckout();
        authoriz = basket.canClickAuthoriz();
        addressPage = authoriz.allAuthoriz();
        shippingPage = addressPage.canClickShippingPage();
        paymentPage = shippingPage.canClickTwo();

        actualResult = paymentPage.getActual();
        expectedResult = "$56.98";
        Assert.assertEquals("Error correctShipping", expectedResult, actualResult);

    }
    @After
    public void clean(){ this.driver.quit(); }


}
