package stepsdef;

import businessobjects.Account;
import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProjectPage;

public class ProjectSteps {

    ProjectPage projectPage = new ProjectPage();
    TestContext testContext;

    public ProjectSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I click Add New")
    public void i_click_add_new() {
        projectPage.addNew_button.click();
    }
    @When("I search {string}")
    public void i_search(String projectNo) {
        projectPage.search(projectNo);
    }

    @When("click Delete icon on that project {string}")
    public void click_delete_icon_on_that_project(String projectNo) {
        projectPage.delete(projectNo);
    }

    @Then("I should not see the project")
    public void i_should_not_see_the_project() {
        Assert.assertEquals(0,projectPage.numOfProjects());
    }

    @Then("I should see the project {string}")
    public void i_should_see_the_project(String projectNo) {
        projectPage.checkProjectExist(projectNo);
    }

}
