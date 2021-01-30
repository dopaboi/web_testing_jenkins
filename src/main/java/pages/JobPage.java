package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigProperties;

public class JobPage extends Page {

    @FindBy(linkText="Создать Item")
    private WebElement create;

    @FindBy(css ="h1.job-index-headline.page-headline")
    private WebElement jobName;

    @FindBy(css = "#description > div")
    private WebElement jobDescription;

    @FindBy(linkText = "Настройки")
    private WebElement linkSettings;

    @FindBy(name = "description")
    private WebElement inputDesc;

    @FindBy(id="yui-gen27-button")
    private WebElement buttonSave;

    @FindBy(linkText = "Rename")
    private WebElement linkRename;

    @FindBy(name = "newName")
    private WebElement newName;

    @FindBy(id="yui-gen3-button")
    private WebElement buttonRename;

    @FindBy(linkText = "Собрать сейчас")
    private WebElement linkCreateBuild;


    @FindBy(linkText = "job for testing")
    private WebElement linkJob;

    @FindBy(linkText = "Удалить Проект")
    private WebElement linkDelete;

    public JobPage(WebDriver driver) {
        super(driver);
    }


    public String getJobName() {
        return jobName.getText();
    }

    public String getJobDescription() {
        return jobDescription.getText();
    }

    public boolean isJobNotDeleted() {
        return isElementPresent(jobName);
    }

    public boolean isJobRename()
    {
        return isElementPresent(jobName);
    }
    public boolean isJobUpdate()
    {
        return isElementPresent(jobDescription);
    }


    public void renameJob()
    {
        linkRename.click();
        newName.clear();
        newName.click();
        type(newName, ConfigProperties.getProperties("job.newname"));
        buttonRename.click();
    }

    public BuildPage createBuild()
    {
     linkCreateBuild.click();
     return PageFactory.initElements(driver, BuildPage.class);
    }

    public void updateJob()
    {
        linkSettings.click();
        type(inputDesc, ConfigProperties.getProperties("job.description"));
        buttonSave.click();

    }

    public void deleteJob()
    {
        linkDelete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperties("job.url") + ConfigProperties.getProperties("job.name"));
    }
}