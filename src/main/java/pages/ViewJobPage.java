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

    @FindBy(name = "description")
    private WebElement description;

    @FindBy(id = "yui-gen29-button")
    private WebElement buttonSaveDesk;

    @FindBy(css = "#description > div")
    private WebElement viewDescription;

    @FindBy(linkText = "Удалить вид")
    private WebElement deleteView;

    @FindBy(id="yui-gen3-button")
    private WebElement buttonDelete;


    public ViewJobPage(WebDriver driver) {
        super(driver);
    }

    public boolean isViewDeleted() {
        return isElementPresent(viewName);
    }

    public boolean isAddedDesk() {
        return isElementPresent(viewDescription);
    }



    public void AddDesk() {
        settingsView.click();
        description.clear();
        type(description, ConfigProperties.getProperties("view.desc"));
        buttonSaveDesk.click();
    }




    public void DeleteView()
    {
        settingsView.click();
        deleteView.click();
        buttonDelete.click();
    }




    @Override
    public void open() {
        driver.get(ConfigProperties.getProperties("view.url") + ConfigProperties.getProperties("view.name"));
    }
}
