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

    @FindBy(className = "hudson_model_FreeStyleProject")
    private WebElement freeConfig;

    @FindBy(id = "ok-button")
    private WebElement buttonSubmit;

    @FindBy(name = "description")
    private WebElement desk;

    @FindBy(id = "yui-gen27-button")
    private WebElement buttonSave;

    @FindBy(className = "addTab")
    private WebElement linkCreateView;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameView;

    @FindBy(xpath = "//input[@value='hudson.model.ListView']")
    private WebElement dashboardView;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public JobPage createJob() {
        linkCreateJob.click();
        type(fieldName, ConfigProperties.getProperties("job.name"));
        freeConfig.click();
        buttonSubmit.click();
        buttonSave.click();
        return PageFactory.initElements(driver, JobPage.class);
    }


    public ViewJobPage createJobToView() {
        linkCreateJob.click();
        type(fieldName, ConfigProperties.getProperties("view.name.job"));
        freeConfig.click();
        buttonSubmit.click();
        buttonSave.click();
        return PageFactory.initElements(driver, ViewJobPage.class);
    }

    public ViewJobPage createNewView() {
        linkCreateView.click();
        type(nameView, ConfigProperties.getProperties("view.name"));
        dashboardView.click();
        buttonSubmit.click();
        return PageFactory.initElements(driver, ViewJobPage.class);
    }

    public ViewJobPage createNewViewFailed() {
        linkCreateView.click();
        type(nameView, ConfigProperties.getProperties("wrong.name"));
        dashboardView.click();
        buttonSubmit.click();
        return PageFactory.initElements(driver, ViewJobPage.class);
    }


    @Override
    public void open() {
        driver.get(ConfigProperties.getProperties("home.url"));
    }
}
