package page;

import help.NewHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageOrder.Basket;

public class DressesPage {
    private WebDriver driver;

    public DressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement listView;

    public void clickListView() {
        NewHelper.waitUnEl();
        listView.click();}

    @FindBy(xpath = "//input[@name='layered_id_attribute_group_3']")
    private WebElement filterL;

    public void clickFilterL() {
        filterL.click();}

    private void selectSort(String sort) {
        WebElement stateDropDown = driver.findElement(By.id("selectProductSort"));
        Select value = new Select(stateDropDown);
        value.selectByVisibleText("Price: Lowest first");
    }

    public void addToCartTwo() {
        WebElement element_one = driver.findElement(By.xpath("(//a[@title='Add to cart'])[1]"));
        WebElement close = driver.findElement(By.xpath("//span[@title='Close window']"));
        WebElement element_two = driver.findElement(By.xpath("(//a[@title='Add to cart'])[3]")); //на сайте не работает сортировка, добавила товар со скидкой
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element_one);
        NewHelper.waitUnEl();
        js.executeScript("arguments[0].click()", close);
        NewHelper.waitUnEl();
        js.executeScript("arguments[0].click()", element_two);
    }

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement ProceedCheckout;

    public Basket clickProceedCheckout() {
        NewHelper.waitUnEl();
        ProceedCheckout.click();
        return new Basket(driver);
    }


    public void canDresses() {
        clickListView();
        clickFilterL();
        selectSort("Price: Lowest first");
        addToCartTwo();
       // clickProceedCheckout();
        }





}


