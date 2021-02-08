package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import utils.ConfigProperties;

public class ViewJobPage extends Page {

    @FindBy(linkText = "Настроить вид")
    private WebElement settingsView;

    @FindBy(linkText = "view number three")
    private WebElement viewName;

    @FindBy(name = "name")
    private WebElement renameView;

    @FindBy(name = "description")
    private WebElement description;

    @FindBy(id = "yui-gen29-button")
    private WebElement buttonSaveDesk;

    @FindBy(css = "#main-panel > h1")
    private WebElement errorRename;

    @FindBy(css = "#description > div")
    private WebElement viewDescription;

    @FindBy(linkText = "Удалить вид")
    private WebElement deleteView;

    @FindBy(id = "yui-gen3-button")
    private WebElement buttonDelete;


    public ViewJobPage(WebDriver driver) {
        super(driver);
    }

    public boolean isViewDeleted() {
        return isElementPresent(viewName);
    }

    public boolean isRenameFailed() {
        return isElementPresent(errorRename);
    }

    public boolean isAddedDesk() {
        return isElementPresent(viewDescription);
    }


    public void RenameViewFailed() {
        settingsView.click();
        renameView.clear();
        type(renameView, ConfigProperties.getProperties("view.name"));
        buttonSaveDesk.click();
    }

    public void DeleteSecondView() {
        settingsView.click();
        deleteView.click();
        buttonDelete.click();
    }

    public void AddDesk() {
        settingsView.click();
        description.clear();
        type(description, ConfigProperties.getProperties("view.desc"));
        buttonSaveDesk.click();
    }


    public void DeleteView() {
        settingsView.click();
        deleteView.click();
        buttonDelete.click();
    }


    @Override
    public void open() {
        driver.get(ConfigProperties.getProperties("view.url") + ConfigProperties.getProperties("view.name"));
    }

    public void openSecondView() {
        driver.get(ConfigProperties.getProperties("view.url") + ConfigProperties.getProperties("wrong.name"));
    }
}
