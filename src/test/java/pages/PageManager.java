package pages;

import com.codeborne.selenide.WebDriverRunner;

public class PageManager {

    private BasePage basePage;
    private LoginPage loginPage;
    private ProjectInfoPage projectInfoPage;
    private ProjectPage projectPage;
    private WebDriverRunner webDriverRunner;

    public PageManager(){
        //this.webDriverRunner = webDriverRunner;
    }

    public BasePage getBasePage() {

        if(basePage == null){
            return new BasePage();
        } else return basePage;
        //return (basePage == null) ? basePage = new BasePage(): basePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(): loginPage;
    }

    public ProjectInfoPage getProjectInfoPage() {
        return (projectInfoPage == null) ? projectInfoPage = new ProjectInfoPage(): projectInfoPage;
    }

    public ProjectPage getProjectPage() {
        return (projectPage == null) ? projectPage = new ProjectPage(): projectPage;
    }
}
