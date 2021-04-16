package pages;

import com.codeborne.selenide.*;
import configuration.AppConfig;
import org.junit.Assert;
import webobjects.WebTable;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.confirm;

public class ProjectPage extends BasePage{

    public SelenideElement addNew_button = $("#addNewProject");
    public SelenideElement search_textbox = $("#Keyword");
    public SelenideElement project_table = $("#projectGrid");


    public void search(String keywords){
        search_textbox.clear();
        search_textbox.sendKeys(keywords);
        loading_mask.should(Condition.exist, AppConfig.AJAXTIMEOUT);
        loading_mask.shouldNot(Condition.exist, AppConfig.AJAXTIMEOUT);
    }

    public void delete(String projectName){
        WebTable projectTable = new WebTable(project_table);
        Map<String, Integer> pos = projectTable.getRowColumnIndex(projectName);
        int rowIndex = pos.get("RowIndex");
        SelenideElement delete_icon = projectTable.getCellElementByIndex(rowIndex, 8).$(byAttribute("title", "Delete this project"));
        delete_icon.click();
        confirm();
        loading_mask.should(Condition.exist, AppConfig.AJAXTIMEOUT);
        loading_mask.shouldNot(Condition.exist, AppConfig.AJAXTIMEOUT);
    }

    public int numOfProjects(){
        WebTable projectTable = new WebTable(project_table);
        return projectTable.getNumRows();
    }


    public void checkProjectExist(String projectNo){
        WebTable projectTable = new WebTable(project_table);
        Assert.assertTrue(projectTable.doesCellTextExist(projectNo));
    }
}
