package pageOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import help.NewHelper;

public class AddressPage {
    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = "(//li[@class='address_address1 address_address2'])[1]")
    private WebElement yourBillingAddress;

    public String getYourBillingAddress() {
        NewHelper.waitUnEl();
        return yourBillingAddress.getText();
    }

    @FindBy(xpath = "(//li[@class='address_address1 address_address2'])[2]")
    private WebElement yourDeliveryAddress;

    public String getYourDeliveryAddress() {
        NewHelper.waitUnEl();
        return yourDeliveryAddress.getText();
    }

    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement clickShippingPage;

    public ShippingPage canClickShippingPage() {
        clickShippingPage.click();
        return new ShippingPage(driver);
    }
}
