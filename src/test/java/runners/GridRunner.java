package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/resources",
        glue= {"stepdefinitions","hooks"},
        tags= "@grid_features", //Çalışsacak scenarioları belirtir.
        dryRun= false //true yaparsak eksik step definitions arar sadece. test çalışmaz. Bu sebeple false yapıyoruz.
)

public class GridRunner {

}
