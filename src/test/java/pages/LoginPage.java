package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement accept_button = $("#consent");
    public SelenideElement username_textbox = $("#UserName");
    public SelenideElement password_textbox = $("#Password");
    public SelenideElement login_button = $(byAttribute("value", "Login"));

    public void enterUserNamePassword(String username, String password){
        username_textbox.sendKeys(username);
        password_textbox.sendKeys(password);

    }

    public void clickLogin(){
        login_button.click();
    }
}
