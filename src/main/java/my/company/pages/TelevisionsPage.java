package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;

public class TelevisionsPage extends BasePage {

    private WebElement element;
    private String firstElement;

    public TelevisionsPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(id = "glf-pricefrom-var")
    WebElement priceFrom;

    @FindBy(xpath = "//*[@class='checkbox__label']")
    WebElement brand;

    @FindBy(xpath = "//span[contains(.,'Все фильтры')]")
    WebElement button_allFilters;

    @FindBy(xpath = "//*[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']")
    WebElement button_ShowAppropriate;

   @FindBy(xpath = "//button[contains(.,'Показывать по 48')]")
    WebElement button_AmmountOfElements;

    @FindBy(xpath = "//div[5]/div[2]/div/div/span")
    WebElement button_ShowTwelve;

    @FindBy(xpath = "//h3[@class='n-snippet-card2__title']")
    WebElement listOfElements;

    @FindBy(id = "header-search")
    WebElement searchInput;

    @FindBy(xpath = "//*[@class='search2__button']/button")
    WebElement button_Search;

    public void setPriceFrom(String value){
        fillField(priceFrom, value, driver);
    }

    public void chooseOfBrandName(String value){
   element = brand.findElement(By.xpath("//*[@class='checkbox__label'][text()='"+value+"']"));
   waitToBeClickable(driver, element);
    }

    public void pressButton(String value) {
        if (value == "кнопка Все фильтры") {
            waitUntilElementsAppear();
            button_allFilters.click();
        }
        else if (value == "кнопка Показать подходящие"){
            button_ShowAppropriate.click();
        }
        else if (value == "Выбрать фильтр Показывать по 12") {
          try {
              button_AmmountOfElements.click();
              button_ShowTwelve.click();
          }catch (Exception e) {
              System.out.println("Уже выбран фильтр на отображение 12 элементов "+e); }
          }
        }

    public int countElements(int value) {
        int count = 0;
        waitUntilElementsAppear();
        try {
            count = driver.findElements(By.xpath("//h3[@class='n-snippet-card2__title']")).size();
            assertEquals(value, count);
        }catch (Exception e) {
            e.printStackTrace();
            return count;
        }
        return count;
    }

    public void findFirstElement(){
        firstElement = findFirstElement("//h3[@class='n-snippet-card2__title']");
    }

    public void searchThing(){
        searchThing(searchInput, firstElement, button_Search);
    }

    public void comparisonSearchResult(){
        checkName(listOfElements, firstElement);
    }
}
