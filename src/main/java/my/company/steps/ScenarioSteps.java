package my.company.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import my.company.pages.*;
import ru.yandex.qatools.allure.annotations.Step;

public class ScenarioSteps {
    BasePage basePage = new BasePage();
    CommonPageSteps commonPageSteps = new CommonPageSteps();
    MarketPageSteps marketPageSteps = new MarketPageSteps();
    ElectronicsPageSteps electronicsPageSteps = new ElectronicsPageSteps();
    TelevisionsPageSteps televisionsPageSteps = new TelevisionsPageSteps();

    @Given("Страница загружена")
    public void Test() {
        BaseSteps baseSteps = new BaseSteps();
        baseSteps.getDriver().get(baseSteps.baseUrl + "/");
    }

    @And("Перейти в Яндекс.Маркет")
    public void goToMarket() {
        commonPageSteps.goToItemOfMenuStep("Маркет");
    }

    @And("Перейти в раздел Электроника")
    public void goToTypeOfProducts() {
        marketPageSteps.goToTypeOfProductsStep("Электроника");
    }

    @And("Перейти в раздел Телевизоры")
    public void goToTV() {
        electronicsPageSteps.goToSideMenuStep("Телевизоры");
    }

    @And("Перейти в раздел Наушники и Bluetooth-гарнитуры")
    public void goToEarphones() {
        electronicsPageSteps.goToSideMenuStep("Наушники и Bluetooth-гарнитуры");
    }

    @And("Нажать кнопку Все фильтры")
    public void allFilters() {
        televisionsPageSteps.pressButtonStep("кнопка Все фильтры");
    }

    @And("Установить значение Цена от 20000")
    public void setPriceFrom() {
        televisionsPageSteps.setPriceFromStep("20000");
    }

    @And("Установить значение Цена от 5000")
    public void setPriceFromF() {
        televisionsPageSteps.setPriceFromStep("5000");
    }

    @And("Выбрать производителя Samsung")
    public void chooseOfSamsung() {
        televisionsPageSteps.chooseOfBrandNameStep("Samsung");
    }

    @And("Выбрать производителя LG")
    public void chooseOfLG() {
        televisionsPageSteps.chooseOfBrandNameStep("LG");
    }

    @And("Выбрать производителя Beats")
    public void chooseOfBeats() {
        televisionsPageSteps.chooseOfBrandNameStep("Beats");
    }



    @And("Нажать кнопку Показать подходящие")
    public void showSuitable() {
        televisionsPageSteps.pressButtonStep("кнопка Показать подходящие");
    }

    @And("Выбрать фильтр Показывать по 12")
    public void showTwelve() {
        televisionsPageSteps.pressButtonStep("Выбрать фильтр Показывать по 12");
    }

    @And("Проверить, что на странице 12 элементов")
    public void countElementsTwelve() {
        televisionsPageSteps.countElementsStep(12);
    }

    @And("Проверить, что на странице 17 элементов")
    public void countElementsSixteen() {
        televisionsPageSteps.countElementsStep(17);
    }

    @And("Выбрать первый элемент")
    public void clickOnFirstElement(){
        televisionsPageSteps.findFirstElementStep();
    }

    @And("Найти товар")
    public void searchThing(){
        televisionsPageSteps.searchThingStep();
    }

    @And("Проверить результат поиска")
    public void checkSearchResults(){
        televisionsPageSteps.comparisonSearchResultStep();
    }

                                                /**Delete wait*/

    @And("wait")
    public void waiting() throws InterruptedException {
        basePage.waiting();
    }
}
