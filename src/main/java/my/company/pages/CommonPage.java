package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends BasePage {

    private WebElement element;

public CommonPage() {
            PageFactory.initElements(BaseSteps.getDriver(), this);
        }

        @FindBy(xpath = "//*[@class=\"home-link home-link_blue_yes home-tabs__link home-tabs__search\"]")
        WebElement itemOfMenu;

        public void goToItemOfMenu(String value){
           element = itemOfMenu.findElement(By.xpath("//*[@class=\"home-link home-link_blue_yes home-tabs__link home-tabs__search\"][text()='"+value+"']"));
           waitToBeClickable(driver, element);
        }
    }


