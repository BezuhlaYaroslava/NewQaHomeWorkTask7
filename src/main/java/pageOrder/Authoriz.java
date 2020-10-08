package pageOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageOrder.AddressPage;

public class Authoriz {

    private WebDriver driver;

    public Authoriz(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    public AddressPage writeEmail() {
        WebElement element = driver.findElement(By.xpath("//input[@id='email']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        element.sendKeys("byaw@ukr.net");
        return new AddressPage(driver);
    }
    public AddressPage writePass() {
        WebElement element = driver.findElement(By.xpath("//input[@id='passwd']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        element.sendKeys("password");
        return new AddressPage(driver);
    }
    public AddressPage clickBtn() {
        WebElement element = driver.findElement(By.xpath("//i[@class='icon-lock left']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        return new AddressPage(driver);
    }
    public AddressPage allAuthoriz(){
        writeEmail();
        writePass();
        clickBtn();
        return new AddressPage(driver);
    }


}
