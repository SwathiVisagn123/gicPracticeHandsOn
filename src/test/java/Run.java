import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//annotations should be outside run class:


@RunWith(Cucumber.class)
@CucumberOptions(features=".",dryRun =false,tags="@addProducts")

public class Run {






}
