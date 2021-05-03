package stepsdef;

import com.codeborne.selenide.Configuration;
import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class Hooks{

    public static String SCENARIO_NAME;
    private TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scenario){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("https://emrb-dev01.azurewebsites.net/Account/LogIn");
        SCENARIO_NAME = scenario.getName();
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }
}
