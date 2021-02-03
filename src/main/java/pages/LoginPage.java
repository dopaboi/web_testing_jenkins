package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import entities.User;
import utils.ConfigProperties;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(ConfigProperties.getProperties("login.url"));
    }


    @FindBy(id = "j_username")
    private WebElement fieldLogin;

    @FindBy(name = "j_password")
    private WebElement fieldPassword;

    @FindBy(name = "Submit")
    private WebElement buttonLogin;

    @FindBy(linkText = "выход")
    private WebElement linkLogIn;

    @FindBy(linkText = "войти")
    private WebElement linkLogOut;

    public boolean isLoggedIn() {
        return isElementPresent(linkLogOut);

    }public boolean isLoggedOut() {
        return isElementPresent(linkLogIn);
    }

    public void login(User admin) {

        fieldLogin.clear();
        fieldPassword.clear();
        type(fieldLogin, admin.getLogin());
        type(fieldPassword, admin.getPassword());
        buttonLogin.click();
    }

    public void logout() {
        linkLogIn.click();
    }

}
