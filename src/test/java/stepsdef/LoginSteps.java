package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasePage;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Given("sign in page is open")
    public void sign_in_page_is_open() {
        loginPage.accept_button.click();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUserNamePassword(username, password);
    }

    @When("I click login")
    public void i_click_login() {
        loginPage.clickLogin();
    }

    @Then("I should see Home page")
    public void i_should_see_home_page() {
        Assert.assertEquals(":: eMRB - Dashboard ::", basePage.getTitle());
    }

}
