package my.company.steps;

import my.company.pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketPageSteps extends MarketPage {

    @Step("Открыт раздел Электроника")
    public void goToTypeOfProductsStep(String value){
        goToTypeOfProducts(value);
    }
}
