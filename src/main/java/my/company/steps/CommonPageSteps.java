package my.company.steps;

import my.company.pages.CommonPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CommonPageSteps extends CommonPage {

    @Step("Открыт Яндекс.Маркет")
    public void goToItemOfMenuStep(String value){
        goToItemOfMenu(value);
    }
}
