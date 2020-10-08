package pageOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import help.NewHelper;

public class ShippingPage {
    private WebDriver driver;

    public ShippingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement clickAgree;

    public ShippingPage canClickAgree() {
        NewHelper.waitUnEl();
        clickAgree.click();
        return new ShippingPage(driver);
    }
    @FindBy(xpath = "(//i[@class='icon-chevron-right right'])[3]")
    private WebElement clickPayment;

    public ShippingPage canClickPayment() {
        NewHelper.waitUnEl();
        clickPayment.click();
        return new ShippingPage(driver);
    }

    public PaymentPage canClickTwo(){
        canClickAgree();
        canClickPayment();
        return new PaymentPage(driver);
    }
}
