package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage extends BasePage{

    private WebElement element;

    public ElectronicsPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS']")
    WebElement sideMenu;

    public void goToSideMenu(String value){
        waitUntilElementsAppear();
        element = sideMenu.findElement(By.xpath("//*[@class='_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS'][text()='"+value+"']"));
        waitToBeClickable(driver, element);
    }
}
