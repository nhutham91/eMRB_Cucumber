package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConfig;
import stepsdef.Hooks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.source;

public class BasePage {

    HashMap<String, SelenideElement> menu_bar = new HashMap<String, SelenideElement>();
    public SelenideElement loading_mask = $(byAttribute("class","k-loading-mask"));

    public BasePage(){
        menu_bar.put("Administration", $("#menu-admin"));
        menu_bar.put("Projects", $("#sub-menu-project-index"));
    }

    public String getTitle(){
        return Selenide.title();
    }

    public void clickMenuItem(String menuItem){
        int separateIndex = menuItem.lastIndexOf("->");
        String menu = menuItem.substring(0, separateIndex);
        String item = menuItem.substring(separateIndex + 2);
        System.out.print(menu + " " + item);
        menu_bar.get(menu).click();
        menu_bar.get(item).click();
        loading_mask.shouldNot(Condition.exist, AppConfig.AJAXTIMEOUT);
    }

    public void writePageSource(String filepath) throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\PageSource\\" + Hooks.SCENARIO_NAME + ".txt");
        fileWriter.write(source());
    }
}
