package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver){ this.driver = driver; }

    public SignUpPage openSignInPage() {
        WebElement element = driver.findElement(By.xpath("//a[@class='login']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        return new SignUpPage(driver);

    }

    public DressesPage openDresses() {
        WebElement element = driver.findElement(By.xpath("//a[@title='Dresses']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        return new DressesPage(driver);
    }


}
