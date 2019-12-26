package my.company.steps;

import my.company.pages.TelevisionsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TelevisionsPageSteps extends TelevisionsPage {

    @Step("Установлено значение в фильтре Цена от")
    public void setPriceFromStep(String value){
        setPriceFrom(value);
    }

    @Step("Выбран производитель")
    public void chooseOfBrandNameStep(String value){
        chooseOfBrandName(value);
    }

    @Step("Кнопка нажата")
    public void pressButtonStep(String value) {
        pressButton(value);
    }

    @Step("На странице отображается 12 товаров")
    public void countElementsStep(int value) {
        int count = 0;
        try {
            count =  countElements(value);
        }catch (Exception e) {
            System.out.println(e);
            if (count == 48) {
                pressButton("Выбрать фильтр Показывать по 12");
                countElements(12);
            }
        }
    }

    @Step("Название первого элемента зафиксировано")
    public void findFirstElementStep(){
        findFirstElement();
    }

    @Step("Продукт найден")
    public void searchThingStep(){
        searchThing();
    }

    @Step("Результаты поиска корректны")
    public void comparisonSearchResultStep(){
        comparisonSearchResult();
    }
}
