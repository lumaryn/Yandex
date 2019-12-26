package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        WebDriver driver = BaseSteps.getDriver();
        this.driver=driver;
    }

    public void waitToBeClickable(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void fillField (WebElement element, String value, WebDriver driver) {
        try {
            waitToBeClickable(driver, element);
            element.clear();
        }catch (Exception e) {
            System.out.println("Данный элемент невозможно очистить "+e);
        }
        element.sendKeys(value);
    }

    public void  waitUntilElementsAppear(){
        new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }

    public String findFirstElement(String xpath){
       String s = driver.findElement(By.xpath(xpath+"[1]")).getText();
       return s;
    }

    public void searchThing(WebElement element, String name, WebElement button){
        element.sendKeys(name);
        waitToBeClickable(driver, button);
    }

    public static void checkName(WebElement element, String value){
        assertEquals(value, element.getText());
    }

    protected void openNewWindow (){
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    protected void clicks(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void checkFillField(String value, By locator) {
        assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waiting() throws InterruptedException {
        int a = 2000;
        int b = 5000;
        int random = a + (int) (Math.random() * b);
        Thread.sleep(random);
    }
}

