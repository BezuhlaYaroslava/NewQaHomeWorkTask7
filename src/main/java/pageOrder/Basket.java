package pageOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import help.*;

public class Basket {

    private WebDriver driver;

    public Basket(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement quantity;

    public String getQuantity(){
        return quantity.getText();

    }

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalPrice;

    public String getTotalPrice(){
        return totalPrice.getText();

    }
    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalProducts;

    public String getTotalProducts(){
        return totalProducts.getText();
    }

    @FindBy(xpath = "//span[@id='total_product_price_5_19_0']")
    private WebElement sale;

    public String getSale() {
        return sale.getText();
    }

    @FindBy(xpath = "(//i[@class='icon-chevron-right right'])[3]")
    private WebElement clickAuthoriz;

    public Authoriz canClickAuthoriz() {
        NewHelper.waitUnEl();
        clickAuthoriz.click();
        return new Authoriz(driver);
    }
}
