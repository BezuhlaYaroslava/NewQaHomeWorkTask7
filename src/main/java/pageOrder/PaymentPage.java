package pageOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//td[@class='cart_total']/span[@class='price'])[1]")
    private WebElement totalPriceOne;

    public int getTotalPriceOne() {
        return Integer.parseInt(totalPriceOne.getText());

    }

    @FindBy(xpath = "(//td[@class='cart_total']/span[@class='price'])[2]")
    private WebElement totalPriceTwo;

    public int getTotalPriceTwo() {
        return Integer.parseInt(totalPriceTwo.getText());
    }

    @FindBy(xpath = "(//span[@id='total_price'])")
    private WebElement actual;

    public String getActual(){
        return actual.getText();
    }


}
