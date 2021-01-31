package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigProperties;

public class ViewJobPage extends Page {

    @FindBy(linkText = "Настроить вид")
    private WebElement settingsView;

    @FindBy(linkText = "view number three")
    private WebElement viewName;


    @FindBy(name = "description")
    private WebElement description;

    @FindBy(id = "yui-gen37-button")
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

    public boolean isViewNotDeleted() {
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
