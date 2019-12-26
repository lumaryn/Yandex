import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import my.company.steps.BaseSteps;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/"}, glue = {"my.company"},
        plugin = {
                "my.company.util.AllureReporter",
        }
)
public class CucumberRunner extends BaseSteps {
}