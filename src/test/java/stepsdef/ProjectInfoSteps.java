package stepsdef;

import businessobjects.Project;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import configuration.AppConfig;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProjectInfoPage;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;


public class ProjectInfoSteps {

    Project project;
    ProjectInfoPage projectInfoPage = new ProjectInfoPage();

    @When("Enter project info")
    public void enter_project_info(DataTable projectInfoData) {
        Map<String, String> data = projectInfoData.transpose().asMap(String.class, String.class);
        project = new Project(data.get("ProjectNo"), data.get("ProjectName"), data.get("SerialNo"));
        projectInfoPage.enterProjectInfo(project);
    }

    @When("Click Save")
    public void click_save() {
        Condition clickable = Condition.and("clickable", Condition.visible, Condition.enabled);
        projectInfoPage.save_button.shouldBe(clickable, AppConfig.AJAXTIMEOUT).click();
    }

    @Then("I should see project saved successfully")
    public void i_should_see_project_saved_successfully() throws IOException {
        projectInfoPage.success_messsage.should(Condition.text("Data saved successfully. "), AppConfig.AJAXTIMEOUT);
    }

}
