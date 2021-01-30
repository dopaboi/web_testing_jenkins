package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigProperties;

public class HomePage extends Page {

    @FindBy(linkText = "Создать Item")
    private WebElement linkCreateJob;

    @FindBy(id = "name")
    private WebElement fieldName;

    @FindBy(xpath = "//*[@id=\"j-add-item-type-standalone-projects\"]/ul/li[1]")
    private WebElement freeConfig;

    @FindBy(id = "ok-button")
    private WebElement buttonSubmit;

    @FindBy (name="description")
    private WebElement desk;

    @FindBy(id="yui-gen27-button")
    private WebElement buttonSave;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public JobPage createJob() {
        linkCreateJob.click();
        type(fieldName, ConfigProperties.getProperties("job.name"));
        freeConfig.click();
        buttonSubmit.click();
        //type(desk, ConfigProperties.getProperties("job.description"));
        buttonSave.click();
        return PageFactory.initElements(driver, JobPage.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperties("home.url"));
    }
}
