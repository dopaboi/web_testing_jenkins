package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigProperties;

public class BuildPage extends Page{



    public BuildPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#description > div")
    private WebElement buildDescription;

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[5]/span/a")
    private WebElement linkEdit;

    @FindBy(name = "displayName")
    private WebElement displayName;

    @FindBy(name = "description")
    private WebElement description;


    @FindBy(xpath = "//*[@id=\"main-panel\"]/h1/text()")
    private WebElement nameBuild;

    @FindBy(id="hoverNotification")
    private WebElement creationNotification;

    @FindBy(id="yui-gen1-button")
    private WebElement buttonAccept;

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[6]/span/a")
    private WebElement deleteBuild;

    @FindBy(id = "yui-gen3-button")
    private WebElement buttonDelete;

    @FindBy(id="yui-gen4-button")
    private WebElement buttonSave;

    @FindBy(xpath = "//*[@id=\"buildHistory\"]/div[2]/table/tbody/tr[2]/td")
    private WebElement lastBuild;


    public boolean isUpdateBuild(){
        return isElementPresent(buildDescription);
    }

    public boolean isBuildCreated() {
        return isElementPresent(creationNotification);
    }

    public boolean isBuildNotDeleted() {return isElementPresent(lastBuild);}

    public void UpdateBuild()
    {
        linkEdit.click();
        displayName.clear();
        type(displayName, ConfigProperties.getProperties("build.name"));
        type(description, ConfigProperties.getProperties("build.description"));
        buttonAccept.click();
        buttonSave.click();
    }



    public void DeleteBuild()
    {
      deleteBuild.click();
      buttonDelete.click();
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperties("job.url") + ConfigProperties.getProperties("job.newname") + "/lastBuild");
    }
}
