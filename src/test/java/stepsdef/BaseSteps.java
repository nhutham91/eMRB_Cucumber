package stepsdef;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import pages.BasePage;

import java.io.IOException;

public class BaseSteps{

    private TestContext testContext;
    BasePage basePage = new BasePage();

    public BaseSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I navigate to menu item {string}")
    public void i_navigate_to_menu_item(String menuItem) throws IOException {
        basePage.clickMenuItem(menuItem);
    }

}
