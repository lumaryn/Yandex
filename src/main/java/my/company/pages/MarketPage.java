package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPage extends BasePage {

    private WebElement element;

    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='n-w-tab n-w-tab_type_navigation-menu']")
    WebElement marketMenu;

    public void goToTypeOfProducts(String value){
        try {
            element = marketMenu.findElement(By.xpath("//*[@class='n-w-tab__control-caption'][text()='" + value + "']"));
           element.click();
        }catch (Exception e){
            e.printStackTrace();
            element = driver.findElement(By.xpath("//*[@class='n-w-tab__control-caption'][text()='" + value + "']"));
            element.click();
        }
    }
}
