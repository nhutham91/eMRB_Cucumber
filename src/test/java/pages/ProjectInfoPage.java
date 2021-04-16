package pages;

import businessobjects.Project;
import com.codeborne.selenide.SelenideElement;
import org.jsoup.Connection;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class ProjectInfoPage extends BasePage {

    public SelenideElement projectNo_textbox = $("#ProjectNo");
    public SelenideElement projectName_textbox = $("#ProductName");
    public SelenideElement serialNo_textbox = $("#UnitNo");
    public SelenideElement save_button = $(byAttribute("title", "Save this project"));
    public SelenideElement success_messsage = $(byAttribute("class","alert alert-success info-panel"));
    public SelenideElement error_message = $(byAttribute("class","alert alert-error error-panel"));

    public void enterProjectInfo(Project project){
        projectNo_textbox.sendKeys(project.getProjectNo());
        projectName_textbox.sendKeys(project.getProjectName());
        serialNo_textbox.sendKeys(project.getSerialNo());
    }

}
