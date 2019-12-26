package my.company.steps;

import my.company.pages.ElectronicsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ElectronicsPageSteps extends ElectronicsPage {

    @Step("Открыт подраздел")
    public void goToSideMenuStep(String value){
        goToSideMenu(value);
    }
}
