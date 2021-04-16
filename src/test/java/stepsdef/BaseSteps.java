package stepsdef;

import io.cucumber.java.en.Given;
import pages.BasePage;

import java.io.IOException;

public class BaseSteps {

    BasePage basePage = new BasePage();

    @Given("I navigate to menu item {string}")
    public void i_navigate_to_menu_item(String menuItem) throws IOException {
        basePage.clickMenuItem(menuItem);
    }

}
